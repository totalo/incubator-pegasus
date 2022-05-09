/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * <p>DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *
 * @generated
 */
package org.apache.pegasus.apps;

import org.apache.pegasus.base.blob;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(
    value = "Autogenerated by Thrift Compiler (0.11.0)",
    date = "2020-04-13")
public class check_and_mutate_request
    implements org.apache.thrift.TBase<check_and_mutate_request, check_and_mutate_request._Fields>,
        java.io.Serializable,
        Cloneable,
        Comparable<check_and_mutate_request> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC =
      new org.apache.thrift.protocol.TStruct("check_and_mutate_request");

  private static final org.apache.thrift.protocol.TField HASH_KEY_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "hash_key", org.apache.thrift.protocol.TType.STRUCT, (short) 1);
  private static final org.apache.thrift.protocol.TField CHECK_SORT_KEY_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "check_sort_key", org.apache.thrift.protocol.TType.STRUCT, (short) 2);
  private static final org.apache.thrift.protocol.TField CHECK_TYPE_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "check_type", org.apache.thrift.protocol.TType.I32, (short) 3);
  private static final org.apache.thrift.protocol.TField CHECK_OPERAND_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "check_operand", org.apache.thrift.protocol.TType.STRUCT, (short) 4);
  private static final org.apache.thrift.protocol.TField MUTATE_LIST_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "mutate_list", org.apache.thrift.protocol.TType.LIST, (short) 5);
  private static final org.apache.thrift.protocol.TField RETURN_CHECK_VALUE_FIELD_DESC =
      new org.apache.thrift.protocol.TField(
          "return_check_value", org.apache.thrift.protocol.TType.BOOL, (short) 6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY =
      new check_and_mutate_requestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY =
      new check_and_mutate_requestTupleSchemeFactory();

  public blob hash_key; // required
  public blob check_sort_key; // required
  /** @see cas_check_type */
  public cas_check_type check_type; // required

  public blob check_operand; // required
  public java.util.List<mutate> mutate_list; // required
  public boolean return_check_value; // required

  /**
   * The set of fields this struct contains, along with convenience methods for finding and
   * manipulating them.
   */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HASH_KEY((short) 1, "hash_key"),
    CHECK_SORT_KEY((short) 2, "check_sort_key"),
    /** @see cas_check_type */
    CHECK_TYPE((short) 3, "check_type"),
    CHECK_OPERAND((short) 4, "check_operand"),
    MUTATE_LIST((short) 5, "mutate_list"),
    RETURN_CHECK_VALUE((short) 6, "return_check_value");

    private static final java.util.Map<java.lang.String, _Fields> byName =
        new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /** Find the _Fields constant that matches fieldId, or null if its not found. */
    public static _Fields findByThriftId(int fieldId) {
      switch (fieldId) {
        case 1: // HASH_KEY
          return HASH_KEY;
        case 2: // CHECK_SORT_KEY
          return CHECK_SORT_KEY;
        case 3: // CHECK_TYPE
          return CHECK_TYPE;
        case 4: // CHECK_OPERAND
          return CHECK_OPERAND;
        case 5: // MUTATE_LIST
          return MUTATE_LIST;
        case 6: // RETURN_CHECK_VALUE
          return RETURN_CHECK_VALUE;
        default:
          return null;
      }
    }

    /** Find the _Fields constant that matches fieldId, throwing an exception if it is not found. */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null)
        throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /** Find the _Fields constant that matches name, or null if its not found. */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RETURN_CHECK_VALUE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;

  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap =
        new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(
        _Fields.HASH_KEY,
        new org.apache.thrift.meta_data.FieldMetaData(
            "hash_key",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.StructMetaData(
                org.apache.thrift.protocol.TType.STRUCT, blob.class)));
    tmpMap.put(
        _Fields.CHECK_SORT_KEY,
        new org.apache.thrift.meta_data.FieldMetaData(
            "check_sort_key",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.StructMetaData(
                org.apache.thrift.protocol.TType.STRUCT, blob.class)));
    tmpMap.put(
        _Fields.CHECK_TYPE,
        new org.apache.thrift.meta_data.FieldMetaData(
            "check_type",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.EnumMetaData(
                org.apache.thrift.protocol.TType.ENUM, cas_check_type.class)));
    tmpMap.put(
        _Fields.CHECK_OPERAND,
        new org.apache.thrift.meta_data.FieldMetaData(
            "check_operand",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.StructMetaData(
                org.apache.thrift.protocol.TType.STRUCT, blob.class)));
    tmpMap.put(
        _Fields.MUTATE_LIST,
        new org.apache.thrift.meta_data.FieldMetaData(
            "mutate_list",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.ListMetaData(
                org.apache.thrift.protocol.TType.LIST,
                new org.apache.thrift.meta_data.StructMetaData(
                    org.apache.thrift.protocol.TType.STRUCT, mutate.class))));
    tmpMap.put(
        _Fields.RETURN_CHECK_VALUE,
        new org.apache.thrift.meta_data.FieldMetaData(
            "return_check_value",
            org.apache.thrift.TFieldRequirementType.DEFAULT,
            new org.apache.thrift.meta_data.FieldValueMetaData(
                org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
        check_and_mutate_request.class, metaDataMap);
  }

  public check_and_mutate_request() {}

  public check_and_mutate_request(
      blob hash_key,
      blob check_sort_key,
      cas_check_type check_type,
      blob check_operand,
      java.util.List<mutate> mutate_list,
      boolean return_check_value) {
    this();
    this.hash_key = hash_key;
    this.check_sort_key = check_sort_key;
    this.check_type = check_type;
    this.check_operand = check_operand;
    this.mutate_list = mutate_list;
    this.return_check_value = return_check_value;
    setReturn_check_valueIsSet(true);
  }

  /** Performs a deep copy on <i>other</i>. */
  public check_and_mutate_request(check_and_mutate_request other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHash_key()) {
      this.hash_key = new blob(other.hash_key);
    }
    if (other.isSetCheck_sort_key()) {
      this.check_sort_key = new blob(other.check_sort_key);
    }
    if (other.isSetCheck_type()) {
      this.check_type = other.check_type;
    }
    if (other.isSetCheck_operand()) {
      this.check_operand = new blob(other.check_operand);
    }
    if (other.isSetMutate_list()) {
      java.util.List<mutate> __this__mutate_list =
          new java.util.ArrayList<mutate>(other.mutate_list.size());
      for (mutate other_element : other.mutate_list) {
        __this__mutate_list.add(new mutate(other_element));
      }
      this.mutate_list = __this__mutate_list;
    }
    this.return_check_value = other.return_check_value;
  }

  public check_and_mutate_request deepCopy() {
    return new check_and_mutate_request(this);
  }

  @Override
  public void clear() {
    this.hash_key = null;
    this.check_sort_key = null;
    this.check_type = null;
    this.check_operand = null;
    this.mutate_list = null;
    setReturn_check_valueIsSet(false);
    this.return_check_value = false;
  }

  public blob getHash_key() {
    return this.hash_key;
  }

  public check_and_mutate_request setHash_key(blob hash_key) {
    this.hash_key = hash_key;
    return this;
  }

  public void unsetHash_key() {
    this.hash_key = null;
  }

  /** Returns true if field hash_key is set (has been assigned a value) and false otherwise */
  public boolean isSetHash_key() {
    return this.hash_key != null;
  }

  public void setHash_keyIsSet(boolean value) {
    if (!value) {
      this.hash_key = null;
    }
  }

  public blob getCheck_sort_key() {
    return this.check_sort_key;
  }

  public check_and_mutate_request setCheck_sort_key(blob check_sort_key) {
    this.check_sort_key = check_sort_key;
    return this;
  }

  public void unsetCheck_sort_key() {
    this.check_sort_key = null;
  }

  /** Returns true if field check_sort_key is set (has been assigned a value) and false otherwise */
  public boolean isSetCheck_sort_key() {
    return this.check_sort_key != null;
  }

  public void setCheck_sort_keyIsSet(boolean value) {
    if (!value) {
      this.check_sort_key = null;
    }
  }

  /** @see cas_check_type */
  public cas_check_type getCheck_type() {
    return this.check_type;
  }

  /** @see cas_check_type */
  public check_and_mutate_request setCheck_type(cas_check_type check_type) {
    this.check_type = check_type;
    return this;
  }

  public void unsetCheck_type() {
    this.check_type = null;
  }

  /** Returns true if field check_type is set (has been assigned a value) and false otherwise */
  public boolean isSetCheck_type() {
    return this.check_type != null;
  }

  public void setCheck_typeIsSet(boolean value) {
    if (!value) {
      this.check_type = null;
    }
  }

  public blob getCheck_operand() {
    return this.check_operand;
  }

  public check_and_mutate_request setCheck_operand(blob check_operand) {
    this.check_operand = check_operand;
    return this;
  }

  public void unsetCheck_operand() {
    this.check_operand = null;
  }

  /** Returns true if field check_operand is set (has been assigned a value) and false otherwise */
  public boolean isSetCheck_operand() {
    return this.check_operand != null;
  }

  public void setCheck_operandIsSet(boolean value) {
    if (!value) {
      this.check_operand = null;
    }
  }

  public int getMutate_listSize() {
    return (this.mutate_list == null) ? 0 : this.mutate_list.size();
  }

  public java.util.Iterator<mutate> getMutate_listIterator() {
    return (this.mutate_list == null) ? null : this.mutate_list.iterator();
  }

  public void addToMutate_list(mutate elem) {
    if (this.mutate_list == null) {
      this.mutate_list = new java.util.ArrayList<mutate>();
    }
    this.mutate_list.add(elem);
  }

  public java.util.List<mutate> getMutate_list() {
    return this.mutate_list;
  }

  public check_and_mutate_request setMutate_list(java.util.List<mutate> mutate_list) {
    this.mutate_list = mutate_list;
    return this;
  }

  public void unsetMutate_list() {
    this.mutate_list = null;
  }

  /** Returns true if field mutate_list is set (has been assigned a value) and false otherwise */
  public boolean isSetMutate_list() {
    return this.mutate_list != null;
  }

  public void setMutate_listIsSet(boolean value) {
    if (!value) {
      this.mutate_list = null;
    }
  }

  public boolean isReturn_check_value() {
    return this.return_check_value;
  }

  public check_and_mutate_request setReturn_check_value(boolean return_check_value) {
    this.return_check_value = return_check_value;
    setReturn_check_valueIsSet(true);
    return this;
  }

  public void unsetReturn_check_value() {
    __isset_bitfield =
        org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RETURN_CHECK_VALUE_ISSET_ID);
  }

  /**
   * Returns true if field return_check_value is set (has been assigned a value) and false otherwise
   */
  public boolean isSetReturn_check_value() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RETURN_CHECK_VALUE_ISSET_ID);
  }

  public void setReturn_check_valueIsSet(boolean value) {
    __isset_bitfield =
        org.apache.thrift.EncodingUtils.setBit(
            __isset_bitfield, __RETURN_CHECK_VALUE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
      case HASH_KEY:
        if (value == null) {
          unsetHash_key();
        } else {
          setHash_key((blob) value);
        }
        break;

      case CHECK_SORT_KEY:
        if (value == null) {
          unsetCheck_sort_key();
        } else {
          setCheck_sort_key((blob) value);
        }
        break;

      case CHECK_TYPE:
        if (value == null) {
          unsetCheck_type();
        } else {
          setCheck_type((cas_check_type) value);
        }
        break;

      case CHECK_OPERAND:
        if (value == null) {
          unsetCheck_operand();
        } else {
          setCheck_operand((blob) value);
        }
        break;

      case MUTATE_LIST:
        if (value == null) {
          unsetMutate_list();
        } else {
          setMutate_list((java.util.List<mutate>) value);
        }
        break;

      case RETURN_CHECK_VALUE:
        if (value == null) {
          unsetReturn_check_value();
        } else {
          setReturn_check_value((java.lang.Boolean) value);
        }
        break;
    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
      case HASH_KEY:
        return getHash_key();

      case CHECK_SORT_KEY:
        return getCheck_sort_key();

      case CHECK_TYPE:
        return getCheck_type();

      case CHECK_OPERAND:
        return getCheck_operand();

      case MUTATE_LIST:
        return getMutate_list();

      case RETURN_CHECK_VALUE:
        return isReturn_check_value();
    }
    throw new java.lang.IllegalStateException();
  }

  /**
   * Returns true if field corresponding to fieldID is set (has been assigned a value) and false
   * otherwise
   */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
      case HASH_KEY:
        return isSetHash_key();
      case CHECK_SORT_KEY:
        return isSetCheck_sort_key();
      case CHECK_TYPE:
        return isSetCheck_type();
      case CHECK_OPERAND:
        return isSetCheck_operand();
      case MUTATE_LIST:
        return isSetMutate_list();
      case RETURN_CHECK_VALUE:
        return isSetReturn_check_value();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null) return false;
    if (that instanceof check_and_mutate_request)
      return this.equals((check_and_mutate_request) that);
    return false;
  }

  public boolean equals(check_and_mutate_request that) {
    if (that == null) return false;
    if (this == that) return true;

    boolean this_present_hash_key = true && this.isSetHash_key();
    boolean that_present_hash_key = true && that.isSetHash_key();
    if (this_present_hash_key || that_present_hash_key) {
      if (!(this_present_hash_key && that_present_hash_key)) return false;
      if (!this.hash_key.equals(that.hash_key)) return false;
    }

    boolean this_present_check_sort_key = true && this.isSetCheck_sort_key();
    boolean that_present_check_sort_key = true && that.isSetCheck_sort_key();
    if (this_present_check_sort_key || that_present_check_sort_key) {
      if (!(this_present_check_sort_key && that_present_check_sort_key)) return false;
      if (!this.check_sort_key.equals(that.check_sort_key)) return false;
    }

    boolean this_present_check_type = true && this.isSetCheck_type();
    boolean that_present_check_type = true && that.isSetCheck_type();
    if (this_present_check_type || that_present_check_type) {
      if (!(this_present_check_type && that_present_check_type)) return false;
      if (!this.check_type.equals(that.check_type)) return false;
    }

    boolean this_present_check_operand = true && this.isSetCheck_operand();
    boolean that_present_check_operand = true && that.isSetCheck_operand();
    if (this_present_check_operand || that_present_check_operand) {
      if (!(this_present_check_operand && that_present_check_operand)) return false;
      if (!this.check_operand.equals(that.check_operand)) return false;
    }

    boolean this_present_mutate_list = true && this.isSetMutate_list();
    boolean that_present_mutate_list = true && that.isSetMutate_list();
    if (this_present_mutate_list || that_present_mutate_list) {
      if (!(this_present_mutate_list && that_present_mutate_list)) return false;
      if (!this.mutate_list.equals(that.mutate_list)) return false;
    }

    boolean this_present_return_check_value = true;
    boolean that_present_return_check_value = true;
    if (this_present_return_check_value || that_present_return_check_value) {
      if (!(this_present_return_check_value && that_present_return_check_value)) return false;
      if (this.return_check_value != that.return_check_value) return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetHash_key()) ? 131071 : 524287);
    if (isSetHash_key()) hashCode = hashCode * 8191 + hash_key.hashCode();

    hashCode = hashCode * 8191 + ((isSetCheck_sort_key()) ? 131071 : 524287);
    if (isSetCheck_sort_key()) hashCode = hashCode * 8191 + check_sort_key.hashCode();

    hashCode = hashCode * 8191 + ((isSetCheck_type()) ? 131071 : 524287);
    if (isSetCheck_type()) hashCode = hashCode * 8191 + check_type.getValue();

    hashCode = hashCode * 8191 + ((isSetCheck_operand()) ? 131071 : 524287);
    if (isSetCheck_operand()) hashCode = hashCode * 8191 + check_operand.hashCode();

    hashCode = hashCode * 8191 + ((isSetMutate_list()) ? 131071 : 524287);
    if (isSetMutate_list()) hashCode = hashCode * 8191 + mutate_list.hashCode();

    hashCode = hashCode * 8191 + ((return_check_value) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(check_and_mutate_request other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetHash_key()).compareTo(other.isSetHash_key());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHash_key()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hash_key, other.hash_key);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison =
        java.lang.Boolean.valueOf(isSetCheck_sort_key()).compareTo(other.isSetCheck_sort_key());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheck_sort_key()) {
      lastComparison =
          org.apache.thrift.TBaseHelper.compareTo(this.check_sort_key, other.check_sort_key);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison =
        java.lang.Boolean.valueOf(isSetCheck_type()).compareTo(other.isSetCheck_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheck_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.check_type, other.check_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison =
        java.lang.Boolean.valueOf(isSetCheck_operand()).compareTo(other.isSetCheck_operand());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCheck_operand()) {
      lastComparison =
          org.apache.thrift.TBaseHelper.compareTo(this.check_operand, other.check_operand);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison =
        java.lang.Boolean.valueOf(isSetMutate_list()).compareTo(other.isSetMutate_list());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMutate_list()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mutate_list, other.mutate_list);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison =
        java.lang.Boolean.valueOf(isSetReturn_check_value())
            .compareTo(other.isSetReturn_check_value());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReturn_check_value()) {
      lastComparison =
          org.apache.thrift.TBaseHelper.compareTo(
              this.return_check_value, other.return_check_value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot)
      throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("check_and_mutate_request(");
    boolean first = true;

    sb.append("hash_key:");
    if (this.hash_key == null) {
      sb.append("null");
    } else {
      sb.append(this.hash_key);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("check_sort_key:");
    if (this.check_sort_key == null) {
      sb.append("null");
    } else {
      sb.append(this.check_sort_key);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("check_type:");
    if (this.check_type == null) {
      sb.append("null");
    } else {
      sb.append(this.check_type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("check_operand:");
    if (this.check_operand == null) {
      sb.append("null");
    } else {
      sb.append(this.check_operand);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mutate_list:");
    if (this.mutate_list == null) {
      sb.append("null");
    } else {
      sb.append(this.mutate_list);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("return_check_value:");
    sb.append(this.return_check_value);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (hash_key != null) {
      hash_key.validate();
    }
    if (check_sort_key != null) {
      check_sort_key.validate();
    }
    if (check_operand != null) {
      check_operand.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(
          new org.apache.thrift.protocol.TCompactProtocol(
              new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in)
      throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and
      // doesn't call the default constructor.
      __isset_bitfield = 0;
      read(
          new org.apache.thrift.protocol.TCompactProtocol(
              new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class check_and_mutate_requestStandardSchemeFactory
      implements org.apache.thrift.scheme.SchemeFactory {
    public check_and_mutate_requestStandardScheme getScheme() {
      return new check_and_mutate_requestStandardScheme();
    }
  }

  private static class check_and_mutate_requestStandardScheme
      extends org.apache.thrift.scheme.StandardScheme<check_and_mutate_request> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, check_and_mutate_request struct)
        throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true) {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
          break;
        }
        switch (schemeField.id) {
          case 1: // HASH_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.hash_key = new blob();
              struct.hash_key.read(iprot);
              struct.setHash_keyIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CHECK_SORT_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.check_sort_key = new blob();
              struct.check_sort_key.read(iprot);
              struct.setCheck_sort_keyIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHECK_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.check_type = cas_check_type.findByValue(iprot.readI32());
              struct.setCheck_typeIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CHECK_OPERAND
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.check_operand = new blob();
              struct.check_operand.read(iprot);
              struct.setCheck_operandIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // MUTATE_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list32 = iprot.readListBegin();
                struct.mutate_list = new java.util.ArrayList<mutate>(_list32.size);
                mutate _elem33;
                for (int _i34 = 0; _i34 < _list32.size; ++_i34) {
                  _elem33 = new mutate();
                  _elem33.read(iprot);
                  struct.mutate_list.add(_elem33);
                }
                iprot.readListEnd();
              }
              struct.setMutate_listIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // RETURN_CHECK_VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.return_check_value = iprot.readBool();
              struct.setReturn_check_valueIsSet(true);
            } else {
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, check_and_mutate_request struct)
        throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.hash_key != null) {
        oprot.writeFieldBegin(HASH_KEY_FIELD_DESC);
        struct.hash_key.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.check_sort_key != null) {
        oprot.writeFieldBegin(CHECK_SORT_KEY_FIELD_DESC);
        struct.check_sort_key.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.check_type != null) {
        oprot.writeFieldBegin(CHECK_TYPE_FIELD_DESC);
        oprot.writeI32(struct.check_type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.check_operand != null) {
        oprot.writeFieldBegin(CHECK_OPERAND_FIELD_DESC);
        struct.check_operand.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.mutate_list != null) {
        oprot.writeFieldBegin(MUTATE_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(
              new org.apache.thrift.protocol.TList(
                  org.apache.thrift.protocol.TType.STRUCT, struct.mutate_list.size()));
          for (mutate _iter35 : struct.mutate_list) {
            _iter35.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(RETURN_CHECK_VALUE_FIELD_DESC);
      oprot.writeBool(struct.return_check_value);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }
  }

  private static class check_and_mutate_requestTupleSchemeFactory
      implements org.apache.thrift.scheme.SchemeFactory {
    public check_and_mutate_requestTupleScheme getScheme() {
      return new check_and_mutate_requestTupleScheme();
    }
  }

  private static class check_and_mutate_requestTupleScheme
      extends org.apache.thrift.scheme.TupleScheme<check_and_mutate_request> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, check_and_mutate_request struct)
        throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot =
          (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetHash_key()) {
        optionals.set(0);
      }
      if (struct.isSetCheck_sort_key()) {
        optionals.set(1);
      }
      if (struct.isSetCheck_type()) {
        optionals.set(2);
      }
      if (struct.isSetCheck_operand()) {
        optionals.set(3);
      }
      if (struct.isSetMutate_list()) {
        optionals.set(4);
      }
      if (struct.isSetReturn_check_value()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetHash_key()) {
        struct.hash_key.write(oprot);
      }
      if (struct.isSetCheck_sort_key()) {
        struct.check_sort_key.write(oprot);
      }
      if (struct.isSetCheck_type()) {
        oprot.writeI32(struct.check_type.getValue());
      }
      if (struct.isSetCheck_operand()) {
        struct.check_operand.write(oprot);
      }
      if (struct.isSetMutate_list()) {
        {
          oprot.writeI32(struct.mutate_list.size());
          for (mutate _iter36 : struct.mutate_list) {
            _iter36.write(oprot);
          }
        }
      }
      if (struct.isSetReturn_check_value()) {
        oprot.writeBool(struct.return_check_value);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, check_and_mutate_request struct)
        throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot =
          (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.hash_key = new blob();
        struct.hash_key.read(iprot);
        struct.setHash_keyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.check_sort_key = new blob();
        struct.check_sort_key.read(iprot);
        struct.setCheck_sort_keyIsSet(true);
      }
      if (incoming.get(2)) {
        struct.check_type = cas_check_type.findByValue(iprot.readI32());
        struct.setCheck_typeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.check_operand = new blob();
        struct.check_operand.read(iprot);
        struct.setCheck_operandIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TList _list37 =
              new org.apache.thrift.protocol.TList(
                  org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.mutate_list = new java.util.ArrayList<mutate>(_list37.size);
          mutate _elem38;
          for (int _i39 = 0; _i39 < _list37.size; ++_i39) {
            _elem38 = new mutate();
            _elem38.read(iprot);
            struct.mutate_list.add(_elem38);
          }
        }
        struct.setMutate_listIsSet(true);
      }
      if (incoming.get(5)) {
        struct.return_check_value = iprot.readBool();
        struct.setReturn_check_valueIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(
      org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme())
            ? STANDARD_SCHEME_FACTORY
            : TUPLE_SCHEME_FACTORY)
        .getScheme();
  }
}
