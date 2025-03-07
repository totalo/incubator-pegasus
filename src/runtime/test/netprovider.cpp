/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Microsoft Corporation
 *
 * -=- Robust Distributed System Nucleus (rDSN) -=-
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

#include <string.h>
#include <chrono>
#include <functional>
#include <memory>
#include <string>
#include <thread>

#include "gtest/gtest.h"
#include "runtime/api_layer1.h"
#include "runtime/api_task.h"
#include "runtime/global_config.h"
#include "runtime/rpc/asio_net_provider.h"
#include "runtime/rpc/network.h"
#include "runtime/rpc/network.sim.h"
#include "runtime/rpc/rpc_address.h"
#include "runtime/rpc/rpc_engine.h"
#include "runtime/rpc/rpc_message.h"
#include "runtime/rpc/serialization.h"
#include "runtime/service_engine.h"
#include "runtime/task/task.h"
#include "runtime/task/task_code.h"
#include "runtime/task/task_spec.h"
#include "test_utils.h"
#include "utils/autoref_ptr.h"
#include "utils/error_code.h"
#include "utils/flags.h"
#include "utils/fmt_logging.h"

namespace dsn {
DSN_DECLARE_uint32(conn_threshold_per_ip);

class asio_network_provider_test : public tools::asio_network_provider
{
public:
    asio_network_provider_test(rpc_engine *srv, network *inner_provider)
        : tools::asio_network_provider(srv, inner_provider)
    {
    }
};

static int TEST_PORT = 20401;
DEFINE_TASK_CODE_RPC(RPC_TEST_NETPROVIDER, TASK_PRIORITY_COMMON, THREAD_POOL_TEST_SERVER)

volatile int wait_flag = 0;
void response_handler(dsn::error_code ec,
                      dsn::message_ex *req,
                      dsn::message_ex *resp,
                      void *request_buf)
{
    if (ERR_OK == ec) {
        std::string response_string;
        char *request_str = (char *)(request_buf);
        ::dsn::unmarshall(resp, response_string);
        ASSERT_EQ(response_string, request_str);
    } else {
        LOG_INFO("error msg: {}", ec);
    }
    wait_flag = 1;
}

void reject_response_handler(dsn::error_code ec)
{
    wait_flag = 1;
    ASSERT_TRUE(ERR_TIMEOUT == ec);
}

void rpc_server_response(dsn::message_ex *request)
{
    std::string str_command;
    ::dsn::unmarshall(request, str_command);
    dsn::message_ex *response = request->create_response();
    ::dsn::marshall(response, str_command);
    dsn_rpc_reply(response);
}

void wait_response()
{
    while (wait_flag == 0)
        std::this_thread::sleep_for(std::chrono::milliseconds(5));
}

void rpc_client_session_send(rpc_session_ptr client_session, bool reject = false)
{
    message_ex *msg = message_ex::create_request(RPC_TEST_NETPROVIDER, 0, 0);
    std::unique_ptr<char[]> buf(new char[128]);
    memset(buf.get(), 0, 128);
    strcpy(buf.get(), "hello world");
    ::dsn::marshall(msg, std::string(buf.get()));

    wait_flag = 0;
    if (!reject) {
        rpc_response_task *t = new rpc_response_task(msg,
                                                     std::bind(&response_handler,
                                                               std::placeholders::_1,
                                                               std::placeholders::_2,
                                                               std::placeholders::_3,
                                                               buf.get()),
                                                     0);
        client_session->net().engine()->matcher()->on_call(msg, t);
    } else {
        rpc_response_task *t = new rpc_response_task(
            msg, std::bind(&reject_response_handler, std::placeholders::_1), 0);
        client_session->net().engine()->matcher()->on_call(msg, t);
    }
    client_session->send_message(msg);
    wait_response();
}

TEST(tools_common, asio_net_provider)
{
    if (dsn::service_engine::instance().spec().semaphore_factory_name ==
        "dsn::tools::sim_semaphore_provider")
        return;

    ASSERT_TRUE(dsn_rpc_register_handler(
        RPC_TEST_NETPROVIDER, "rpc.test.netprovider", rpc_server_response));

    std::unique_ptr<tools::asio_network_provider> asio_network(
        new tools::asio_network_provider(task::get_current_rpc(), nullptr));

    error_code start_result;
    start_result = asio_network->start(RPC_CHANNEL_TCP, TEST_PORT, true);
    ASSERT_TRUE(start_result == ERR_OK);

    // the same asio network handle, start only client is ok
    start_result = asio_network->start(RPC_CHANNEL_TCP, TEST_PORT, true);
    ASSERT_TRUE(start_result == ERR_OK);

    rpc_address network_addr = asio_network->address();
    ASSERT_TRUE(network_addr.port() == TEST_PORT);

    std::unique_ptr<tools::asio_network_provider> asio_network2(
        new tools::asio_network_provider(task::get_current_rpc(), nullptr));
    start_result = asio_network2->start(RPC_CHANNEL_TCP, TEST_PORT, true);
    ASSERT_TRUE(start_result == ERR_OK);

    start_result = asio_network2->start(RPC_CHANNEL_TCP, TEST_PORT, false);
    ASSERT_TRUE(start_result == ERR_OK);
    LOG_INFO("result: {}", start_result);

    start_result = asio_network2->start(RPC_CHANNEL_TCP, TEST_PORT, false);
    ASSERT_TRUE(start_result == ERR_SERVICE_ALREADY_RUNNING);
    LOG_INFO("result: {}", start_result);

    rpc_session_ptr client_session =
        asio_network->create_client_session(rpc_address("localhost", TEST_PORT));
    client_session->connect();

    rpc_client_session_send(client_session);

    ASSERT_TRUE(dsn_rpc_unregiser_handler(RPC_TEST_NETPROVIDER));

    TEST_PORT++;
}

TEST(tools_common, asio_udp_provider)
{
    if (dsn::service_engine::instance().spec().semaphore_factory_name ==
        "dsn::tools::sim_semaphore_provider")
        return;

    ASSERT_TRUE(dsn_rpc_register_handler(
        RPC_TEST_NETPROVIDER, "rpc.test.netprovider", rpc_server_response));

    std::unique_ptr<tools::asio_udp_provider> client(
        new tools::asio_udp_provider(task::get_current_rpc(), nullptr));

    error_code start_result;
    start_result = client->start(RPC_CHANNEL_UDP, 0, true);
    ASSERT_TRUE(start_result == ERR_OK);

    start_result = client->start(RPC_CHANNEL_UDP, TEST_PORT, false);
    ASSERT_TRUE(start_result == ERR_OK);

    message_ex *msg = message_ex::create_request(RPC_TEST_NETPROVIDER, 0, 0);
    std::unique_ptr<char[]> buf(new char[128]);
    memset(buf.get(), 0, 128);
    strcpy(buf.get(), "hello world");
    ::dsn::marshall(msg, std::string(buf.get()));

    wait_flag = 0;
    rpc_response_task *t = new rpc_response_task(msg,
                                                 std::bind(&response_handler,
                                                           std::placeholders::_1,
                                                           std::placeholders::_2,
                                                           std::placeholders::_3,
                                                           buf.get()),
                                                 0);

    client->engine()->matcher()->on_call(msg, t);
    client->send_message(msg);

    wait_response();

    ASSERT_TRUE(dsn_rpc_unregiser_handler(RPC_TEST_NETPROVIDER));
    TEST_PORT++;
}

TEST(tools_common, sim_net_provider)
{
    if (dsn::service_engine::instance().spec().semaphore_factory_name ==
        "dsn::tools::sim_semaphore_provider")
        return;

    ASSERT_TRUE(dsn_rpc_register_handler(
        RPC_TEST_NETPROVIDER, "rpc.test.netprovider", rpc_server_response));

    std::unique_ptr<tools::sim_network_provider> sim_net(
        new tools::sim_network_provider(task::get_current_rpc(), nullptr));

    error_code ans;
    ans = sim_net->start(RPC_CHANNEL_TCP, TEST_PORT, false);
    ASSERT_TRUE(ans == ERR_OK);

    ans = sim_net->start(RPC_CHANNEL_TCP, TEST_PORT, false);
    ASSERT_TRUE(ans == ERR_ADDRESS_ALREADY_USED);

    rpc_session_ptr client_session =
        sim_net->create_client_session(rpc_address("localhost", TEST_PORT));
    client_session->connect();

    rpc_client_session_send(client_session);

    ASSERT_TRUE(dsn_rpc_unregiser_handler(RPC_TEST_NETPROVIDER));

    TEST_PORT++;
}

TEST(tools_common, asio_network_provider_connection_threshold)
{
    if (dsn::service_engine::instance().spec().semaphore_factory_name ==
        "dsn::tools::sim_semaphore_provider")
        return;

    ASSERT_TRUE(dsn_rpc_register_handler(
        RPC_TEST_NETPROVIDER, "rpc.test.netprovider", rpc_server_response));

    std::unique_ptr<asio_network_provider_test> asio_network(
        new asio_network_provider_test(task::get_current_rpc(), nullptr));

    error_code start_result;
    start_result = asio_network->start(RPC_CHANNEL_TCP, TEST_PORT, false);
    ASSERT_TRUE(start_result == ERR_OK);

    auto CONN_THRESHOLD = 3;
    LOG_INFO("change FLAGS_conn_threshold_per_ip {} -> {} for test",
             FLAGS_conn_threshold_per_ip,
             CONN_THRESHOLD);
    FLAGS_conn_threshold_per_ip = CONN_THRESHOLD;

    // not exceed threshold
    for (int count = 0; count < CONN_THRESHOLD + 2; count++) {
        LOG_INFO("client # {}", count);
        rpc_session_ptr client_session =
            asio_network->create_client_session(rpc_address("localhost", TEST_PORT));
        client_session->connect();

        rpc_client_session_send(client_session);

        client_session->close();
        std::this_thread::sleep_for(std::chrono::milliseconds(5));
    }

    // exceed threshold
    bool reject = false;
    for (int count = 0; count < CONN_THRESHOLD + 2; count++) {
        LOG_INFO("client # {}", count);
        rpc_session_ptr client_session =
            asio_network->create_client_session(rpc_address("localhost", TEST_PORT));
        client_session->connect();

        if (count >= CONN_THRESHOLD)
            reject = true;
        rpc_client_session_send(client_session, reject);
    }

    ASSERT_TRUE(dsn_rpc_unregiser_handler(RPC_TEST_NETPROVIDER));

    TEST_PORT++;
}
} // namespace dsn
