package com.skyworth.beehelperclient.protocol;
//Generated by the protocol buffer compiler.  DO NOT EDIT!
//source: DeviceItem.proto

public final class DeviceMsg {
  private DeviceMsg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface DeviceInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:DeviceInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required string deviceUid = 1;</code>
     */
    boolean hasDeviceUid();
    /**
     * <code>required string deviceUid = 1;</code>
     */
    java.lang.String getDeviceUid();
    /**
     * <code>required string deviceUid = 1;</code>
     */
    com.google.protobuf.ByteString
        getDeviceUidBytes();

    /**
     * <code>required string deviceIp = 2;</code>
     */
    boolean hasDeviceIp();
    /**
     * <code>required string deviceIp = 2;</code>
     */
    java.lang.String getDeviceIp();
    /**
     * <code>required string deviceIp = 2;</code>
     */
    com.google.protobuf.ByteString
        getDeviceIpBytes();

    /**
     * <code>optional string deviceName = 3;</code>
     */
    boolean hasDeviceName();
    /**
     * <code>optional string deviceName = 3;</code>
     */
    java.lang.String getDeviceName();
    /**
     * <code>optional string deviceName = 3;</code>
     */
    com.google.protobuf.ByteString
        getDeviceNameBytes();
  }
  /**
   * Protobuf type {@code DeviceInfo}
   */
  public static final class DeviceInfo extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:DeviceInfo)
      DeviceInfoOrBuilder {
    // Use DeviceInfo.newBuilder() to construct.
    private DeviceInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private DeviceInfo(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final DeviceInfo defaultInstance;
    public static DeviceInfo getDefaultInstance() {
      return defaultInstance;
    }

    public DeviceInfo getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private DeviceInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000001;
              deviceUid_ = bs;
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              deviceIp_ = bs;
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              deviceName_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return DeviceMsg.internal_static_DeviceInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return DeviceMsg.internal_static_DeviceInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              DeviceMsg.DeviceInfo.class, DeviceMsg.DeviceInfo.Builder.class);
    }

    public static com.google.protobuf.Parser<DeviceInfo> PARSER =
        new com.google.protobuf.AbstractParser<DeviceInfo>() {
      public DeviceInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeviceInfo(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<DeviceInfo> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int DEVICEUID_FIELD_NUMBER = 1;
    private java.lang.Object deviceUid_;
    /**
     * <code>required string deviceUid = 1;</code>
     */
    public boolean hasDeviceUid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string deviceUid = 1;</code>
     */
    public java.lang.String getDeviceUid() {
      java.lang.Object ref = deviceUid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          deviceUid_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string deviceUid = 1;</code>
     */
    public com.google.protobuf.ByteString
        getDeviceUidBytes() {
      java.lang.Object ref = deviceUid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        deviceUid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEVICEIP_FIELD_NUMBER = 2;
    private java.lang.Object deviceIp_;
    /**
     * <code>required string deviceIp = 2;</code>
     */
    public boolean hasDeviceIp() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string deviceIp = 2;</code>
     */
    public java.lang.String getDeviceIp() {
      java.lang.Object ref = deviceIp_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          deviceIp_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string deviceIp = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDeviceIpBytes() {
      java.lang.Object ref = deviceIp_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        deviceIp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEVICENAME_FIELD_NUMBER = 3;
    private java.lang.Object deviceName_;
    /**
     * <code>optional string deviceName = 3;</code>
     */
    public boolean hasDeviceName() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string deviceName = 3;</code>
     */
    public java.lang.String getDeviceName() {
      java.lang.Object ref = deviceName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          deviceName_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string deviceName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDeviceNameBytes() {
      java.lang.Object ref = deviceName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        deviceName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      deviceUid_ = "";
      deviceIp_ = "";
      deviceName_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasDeviceUid()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDeviceIp()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getDeviceUidBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getDeviceIpBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getDeviceNameBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getDeviceUidBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getDeviceIpBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getDeviceNameBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static DeviceMsg.DeviceInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static DeviceMsg.DeviceInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static DeviceMsg.DeviceInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static DeviceMsg.DeviceInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static DeviceMsg.DeviceInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static DeviceMsg.DeviceInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static DeviceMsg.DeviceInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static DeviceMsg.DeviceInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static DeviceMsg.DeviceInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static DeviceMsg.DeviceInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(DeviceMsg.DeviceInfo prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code DeviceInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:DeviceInfo)
        DeviceMsg.DeviceInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return DeviceMsg.internal_static_DeviceInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return DeviceMsg.internal_static_DeviceInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                DeviceMsg.DeviceInfo.class, DeviceMsg.DeviceInfo.Builder.class);
      }

      // Construct using DeviceInfoProto.DeviceInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        deviceUid_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        deviceIp_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        deviceName_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return DeviceMsg.internal_static_DeviceInfo_descriptor;
      }

      public DeviceMsg.DeviceInfo getDefaultInstanceForType() {
        return DeviceMsg.DeviceInfo.getDefaultInstance();
      }

      public DeviceMsg.DeviceInfo build() {
        DeviceMsg.DeviceInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public DeviceMsg.DeviceInfo buildPartial() {
        DeviceMsg.DeviceInfo result = new DeviceMsg.DeviceInfo(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.deviceUid_ = deviceUid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.deviceIp_ = deviceIp_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.deviceName_ = deviceName_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof DeviceMsg.DeviceInfo) {
          return mergeFrom((DeviceMsg.DeviceInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(DeviceMsg.DeviceInfo other) {
        if (other == DeviceMsg.DeviceInfo.getDefaultInstance()) return this;
        if (other.hasDeviceUid()) {
          bitField0_ |= 0x00000001;
          deviceUid_ = other.deviceUid_;
          onChanged();
        }
        if (other.hasDeviceIp()) {
          bitField0_ |= 0x00000002;
          deviceIp_ = other.deviceIp_;
          onChanged();
        }
        if (other.hasDeviceName()) {
          bitField0_ |= 0x00000004;
          deviceName_ = other.deviceName_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasDeviceUid()) {
          
          return false;
        }
        if (!hasDeviceIp()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        DeviceMsg.DeviceInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (DeviceMsg.DeviceInfo) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object deviceUid_ = "";
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public boolean hasDeviceUid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public java.lang.String getDeviceUid() {
        java.lang.Object ref = deviceUid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            deviceUid_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public com.google.protobuf.ByteString
          getDeviceUidBytes() {
        java.lang.Object ref = deviceUid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          deviceUid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public Builder setDeviceUid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        deviceUid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public Builder clearDeviceUid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        deviceUid_ = getDefaultInstance().getDeviceUid();
        onChanged();
        return this;
      }
      /**
       * <code>required string deviceUid = 1;</code>
       */
      public Builder setDeviceUidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        deviceUid_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object deviceIp_ = "";
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public boolean hasDeviceIp() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public java.lang.String getDeviceIp() {
        java.lang.Object ref = deviceIp_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            deviceIp_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public com.google.protobuf.ByteString
          getDeviceIpBytes() {
        java.lang.Object ref = deviceIp_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          deviceIp_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public Builder setDeviceIp(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        deviceIp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public Builder clearDeviceIp() {
        bitField0_ = (bitField0_ & ~0x00000002);
        deviceIp_ = getDefaultInstance().getDeviceIp();
        onChanged();
        return this;
      }
      /**
       * <code>required string deviceIp = 2;</code>
       */
      public Builder setDeviceIpBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        deviceIp_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object deviceName_ = "";
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public boolean hasDeviceName() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public java.lang.String getDeviceName() {
        java.lang.Object ref = deviceName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            deviceName_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public com.google.protobuf.ByteString
          getDeviceNameBytes() {
        java.lang.Object ref = deviceName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          deviceName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public Builder setDeviceName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        deviceName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public Builder clearDeviceName() {
        bitField0_ = (bitField0_ & ~0x00000004);
        deviceName_ = getDefaultInstance().getDeviceName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string deviceName = 3;</code>
       */
      public Builder setDeviceNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        deviceName_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:DeviceInfo)
    }

    static {
      defaultInstance = new DeviceInfo(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:DeviceInfo)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_DeviceInfo_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DeviceInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020DeviceItem.proto\"E\n\nDeviceInfo\022\021\n\tdevi" +
      "ceUid\030\001 \002(\t\022\020\n\010deviceIp\030\002 \002(\t\022\022\n\ndeviceN" +
      "ame\030\003 \001(\tB\021B\017DeviceInfoProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_DeviceInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_DeviceInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_DeviceInfo_descriptor,
        new java.lang.String[] { "DeviceUid", "DeviceIp", "DeviceName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
