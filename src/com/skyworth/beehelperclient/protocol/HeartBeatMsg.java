package com.skyworth.beehelperclient.protocol;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HeartBeatMsg.proto

public final class HeartBeatMsg {
  private HeartBeatMsg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface HeartBeatOrBuilder extends
      // @@protoc_insertion_point(interface_extends:HeartBeat)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 msg = 1;</code>
     */
    boolean hasMsg();
    /**
     * <code>required int32 msg = 1;</code>
     */
    int getMsg();
  }
  /**
   * Protobuf type {@code HeartBeat}
   */
  public static final class HeartBeat extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:HeartBeat)
      HeartBeatOrBuilder {
    // Use HeartBeat.newBuilder() to construct.
    private HeartBeat(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private HeartBeat(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final HeartBeat defaultInstance;
    public static HeartBeat getDefaultInstance() {
      return defaultInstance;
    }

    public HeartBeat getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private HeartBeat(
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
            case 8: {
              bitField0_ |= 0x00000001;
              msg_ = input.readInt32();
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
      return HeartBeatMsg.internal_static_HeartBeat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return HeartBeatMsg.internal_static_HeartBeat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              HeartBeatMsg.HeartBeat.class, HeartBeatMsg.HeartBeat.Builder.class);
    }

    public static com.google.protobuf.Parser<HeartBeat> PARSER =
        new com.google.protobuf.AbstractParser<HeartBeat>() {
      public HeartBeat parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartBeat(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<HeartBeat> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int MSG_FIELD_NUMBER = 1;
    private int msg_;
    /**
     * <code>required int32 msg = 1;</code>
     */
    public boolean hasMsg() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 msg = 1;</code>
     */
    public int getMsg() {
      return msg_;
    }

    private void initFields() {
      msg_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasMsg()) {
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
        output.writeInt32(1, msg_);
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
          .computeInt32Size(1, msg_);
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

    public static HeartBeatMsg.HeartBeat parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static HeartBeatMsg.HeartBeat parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static HeartBeatMsg.HeartBeat parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static HeartBeatMsg.HeartBeat parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(HeartBeatMsg.HeartBeat prototype) {
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
     * Protobuf type {@code HeartBeat}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:HeartBeat)
        HeartBeatMsg.HeartBeatOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return HeartBeatMsg.internal_static_HeartBeat_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return HeartBeatMsg.internal_static_HeartBeat_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                HeartBeatMsg.HeartBeat.class, HeartBeatMsg.HeartBeat.Builder.class);
      }

      // Construct using HeartBeatMsg.HeartBeat.newBuilder()
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
        msg_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return HeartBeatMsg.internal_static_HeartBeat_descriptor;
      }

      public HeartBeatMsg.HeartBeat getDefaultInstanceForType() {
        return HeartBeatMsg.HeartBeat.getDefaultInstance();
      }

      public HeartBeatMsg.HeartBeat build() {
        HeartBeatMsg.HeartBeat result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public HeartBeatMsg.HeartBeat buildPartial() {
        HeartBeatMsg.HeartBeat result = new HeartBeatMsg.HeartBeat(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.msg_ = msg_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof HeartBeatMsg.HeartBeat) {
          return mergeFrom((HeartBeatMsg.HeartBeat)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(HeartBeatMsg.HeartBeat other) {
        if (other == HeartBeatMsg.HeartBeat.getDefaultInstance()) return this;
        if (other.hasMsg()) {
          setMsg(other.getMsg());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasMsg()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        HeartBeatMsg.HeartBeat parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (HeartBeatMsg.HeartBeat) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int msg_ ;
      /**
       * <code>required int32 msg = 1;</code>
       */
      public boolean hasMsg() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 msg = 1;</code>
       */
      public int getMsg() {
        return msg_;
      }
      /**
       * <code>required int32 msg = 1;</code>
       */
      public Builder setMsg(int value) {
        bitField0_ |= 0x00000001;
        msg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 msg = 1;</code>
       */
      public Builder clearMsg() {
        bitField0_ = (bitField0_ & ~0x00000001);
        msg_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:HeartBeat)
    }

    static {
      defaultInstance = new HeartBeat(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:HeartBeat)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HeartBeat_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_HeartBeat_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022HeartBeatMsg.proto\"\030\n\tHeartBeat\022\013\n\003msg" +
      "\030\001 \002(\005B\016B\014HeartBeatMsg"
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
    internal_static_HeartBeat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HeartBeat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_HeartBeat_descriptor,
        new java.lang.String[] { "Msg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
