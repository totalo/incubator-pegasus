#!/bin/bash

./run.sh clear_onebox
echo

./run.sh start_onebox -r 6 -w -p 16
echo

primary=`echo cluster_info | ./run.sh shell 2>&1 | grep primary_meta_server | awk '{print $3}'`
pid=`echo "app temp -d" | ./run.sh shell 2>&1 | grep " 10.239.35.112:34801 " | head -n 1 |awk '{print $1}'`

echo "set meta.fd.ignore = 10.239.35.112:34801"
echo "remote_command -l $primary meta.fd.ignore 10.239.35.112:34801" | ./run.sh shell &>/dev/null
echo "sleep 20 (to wait replica1 become unalive)"
sleep 20
echo "nodes -d" | ./run.sh shell 2>&1 | grep "10.239.35.112:34801"
echo

echo "set meta.fd.ignore = none"
echo "remote_command -l $primary meta.fd.ignore none" | ./run.sh shell &>/dev/null
echo "sleep 5 (to wait replica1 become alive)"
sleep 5
echo "nodes -d" | ./run.sh shell 2>&1 | grep "10.239.35.112:34801"
echo

echo "set meta.lb.assign_delay_ms = 1000"
echo "remote_command -l $primary meta.lb.assign_delay_ms 1000" | ./run.sh shell &>/dev/null
echo "sleep 5 (to wait replica1 coredump)"
sleep 5

echo "find core in onebox/replica1:"
echo "------------------------------"
grep "^F" onebox/replica1/data/log/log.1.txt

