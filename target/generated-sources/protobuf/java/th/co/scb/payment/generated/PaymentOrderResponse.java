// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: paymentmsg.proto

package th.co.scb.payment.generated;

/**
 * Protobuf type {@code th.co.scb.payment.PaymentOrderResponse}
 */
public final class PaymentOrderResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:th.co.scb.payment.PaymentOrderResponse)
    PaymentOrderResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PaymentOrderResponse.newBuilder() to construct.
  private PaymentOrderResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PaymentOrderResponse() {
    paymentResult_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PaymentOrderResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PaymentOrderResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 10: {
            th.co.scb.payment.generated.PaymentOrderRequest.Builder subBuilder = null;
            if (originalRequest_ != null) {
              subBuilder = originalRequest_.toBuilder();
            }
            originalRequest_ = input.readMessage(th.co.scb.payment.generated.PaymentOrderRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(originalRequest_);
              originalRequest_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            paymentResult_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return th.co.scb.payment.generated.Paymentmsg.internal_static_th_co_scb_payment_PaymentOrderResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return th.co.scb.payment.generated.Paymentmsg.internal_static_th_co_scb_payment_PaymentOrderResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            th.co.scb.payment.generated.PaymentOrderResponse.class, th.co.scb.payment.generated.PaymentOrderResponse.Builder.class);
  }

  public static final int ORIGINALREQUEST_FIELD_NUMBER = 1;
  private th.co.scb.payment.generated.PaymentOrderRequest originalRequest_;
  /**
   * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
   * @return Whether the originalRequest field is set.
   */
  @java.lang.Override
  public boolean hasOriginalRequest() {
    return originalRequest_ != null;
  }
  /**
   * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
   * @return The originalRequest.
   */
  @java.lang.Override
  public th.co.scb.payment.generated.PaymentOrderRequest getOriginalRequest() {
    return originalRequest_ == null ? th.co.scb.payment.generated.PaymentOrderRequest.getDefaultInstance() : originalRequest_;
  }
  /**
   * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
   */
  @java.lang.Override
  public th.co.scb.payment.generated.PaymentOrderRequestOrBuilder getOriginalRequestOrBuilder() {
    return getOriginalRequest();
  }

  public static final int PAYMENTRESULT_FIELD_NUMBER = 2;
  private volatile java.lang.Object paymentResult_;
  /**
   * <code>string paymentResult = 2;</code>
   * @return The paymentResult.
   */
  @java.lang.Override
  public java.lang.String getPaymentResult() {
    java.lang.Object ref = paymentResult_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      paymentResult_ = s;
      return s;
    }
  }
  /**
   * <code>string paymentResult = 2;</code>
   * @return The bytes for paymentResult.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPaymentResultBytes() {
    java.lang.Object ref = paymentResult_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      paymentResult_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (originalRequest_ != null) {
      output.writeMessage(1, getOriginalRequest());
    }
    if (!getPaymentResultBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, paymentResult_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (originalRequest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOriginalRequest());
    }
    if (!getPaymentResultBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, paymentResult_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof th.co.scb.payment.generated.PaymentOrderResponse)) {
      return super.equals(obj);
    }
    th.co.scb.payment.generated.PaymentOrderResponse other = (th.co.scb.payment.generated.PaymentOrderResponse) obj;

    if (hasOriginalRequest() != other.hasOriginalRequest()) return false;
    if (hasOriginalRequest()) {
      if (!getOriginalRequest()
          .equals(other.getOriginalRequest())) return false;
    }
    if (!getPaymentResult()
        .equals(other.getPaymentResult())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasOriginalRequest()) {
      hash = (37 * hash) + ORIGINALREQUEST_FIELD_NUMBER;
      hash = (53 * hash) + getOriginalRequest().hashCode();
    }
    hash = (37 * hash) + PAYMENTRESULT_FIELD_NUMBER;
    hash = (53 * hash) + getPaymentResult().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static th.co.scb.payment.generated.PaymentOrderResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(th.co.scb.payment.generated.PaymentOrderResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code th.co.scb.payment.PaymentOrderResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:th.co.scb.payment.PaymentOrderResponse)
      th.co.scb.payment.generated.PaymentOrderResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return th.co.scb.payment.generated.Paymentmsg.internal_static_th_co_scb_payment_PaymentOrderResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return th.co.scb.payment.generated.Paymentmsg.internal_static_th_co_scb_payment_PaymentOrderResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              th.co.scb.payment.generated.PaymentOrderResponse.class, th.co.scb.payment.generated.PaymentOrderResponse.Builder.class);
    }

    // Construct using th.co.scb.payment.generated.PaymentOrderResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (originalRequestBuilder_ == null) {
        originalRequest_ = null;
      } else {
        originalRequest_ = null;
        originalRequestBuilder_ = null;
      }
      paymentResult_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return th.co.scb.payment.generated.Paymentmsg.internal_static_th_co_scb_payment_PaymentOrderResponse_descriptor;
    }

    @java.lang.Override
    public th.co.scb.payment.generated.PaymentOrderResponse getDefaultInstanceForType() {
      return th.co.scb.payment.generated.PaymentOrderResponse.getDefaultInstance();
    }

    @java.lang.Override
    public th.co.scb.payment.generated.PaymentOrderResponse build() {
      th.co.scb.payment.generated.PaymentOrderResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public th.co.scb.payment.generated.PaymentOrderResponse buildPartial() {
      th.co.scb.payment.generated.PaymentOrderResponse result = new th.co.scb.payment.generated.PaymentOrderResponse(this);
      if (originalRequestBuilder_ == null) {
        result.originalRequest_ = originalRequest_;
      } else {
        result.originalRequest_ = originalRequestBuilder_.build();
      }
      result.paymentResult_ = paymentResult_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof th.co.scb.payment.generated.PaymentOrderResponse) {
        return mergeFrom((th.co.scb.payment.generated.PaymentOrderResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(th.co.scb.payment.generated.PaymentOrderResponse other) {
      if (other == th.co.scb.payment.generated.PaymentOrderResponse.getDefaultInstance()) return this;
      if (other.hasOriginalRequest()) {
        mergeOriginalRequest(other.getOriginalRequest());
      }
      if (!other.getPaymentResult().isEmpty()) {
        paymentResult_ = other.paymentResult_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      th.co.scb.payment.generated.PaymentOrderResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (th.co.scb.payment.generated.PaymentOrderResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private th.co.scb.payment.generated.PaymentOrderRequest originalRequest_;
    private com.google.protobuf.SingleFieldBuilderV3<
        th.co.scb.payment.generated.PaymentOrderRequest, th.co.scb.payment.generated.PaymentOrderRequest.Builder, th.co.scb.payment.generated.PaymentOrderRequestOrBuilder> originalRequestBuilder_;
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     * @return Whether the originalRequest field is set.
     */
    public boolean hasOriginalRequest() {
      return originalRequestBuilder_ != null || originalRequest_ != null;
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     * @return The originalRequest.
     */
    public th.co.scb.payment.generated.PaymentOrderRequest getOriginalRequest() {
      if (originalRequestBuilder_ == null) {
        return originalRequest_ == null ? th.co.scb.payment.generated.PaymentOrderRequest.getDefaultInstance() : originalRequest_;
      } else {
        return originalRequestBuilder_.getMessage();
      }
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public Builder setOriginalRequest(th.co.scb.payment.generated.PaymentOrderRequest value) {
      if (originalRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        originalRequest_ = value;
        onChanged();
      } else {
        originalRequestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public Builder setOriginalRequest(
        th.co.scb.payment.generated.PaymentOrderRequest.Builder builderForValue) {
      if (originalRequestBuilder_ == null) {
        originalRequest_ = builderForValue.build();
        onChanged();
      } else {
        originalRequestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public Builder mergeOriginalRequest(th.co.scb.payment.generated.PaymentOrderRequest value) {
      if (originalRequestBuilder_ == null) {
        if (originalRequest_ != null) {
          originalRequest_ =
            th.co.scb.payment.generated.PaymentOrderRequest.newBuilder(originalRequest_).mergeFrom(value).buildPartial();
        } else {
          originalRequest_ = value;
        }
        onChanged();
      } else {
        originalRequestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public Builder clearOriginalRequest() {
      if (originalRequestBuilder_ == null) {
        originalRequest_ = null;
        onChanged();
      } else {
        originalRequest_ = null;
        originalRequestBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public th.co.scb.payment.generated.PaymentOrderRequest.Builder getOriginalRequestBuilder() {
      
      onChanged();
      return getOriginalRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    public th.co.scb.payment.generated.PaymentOrderRequestOrBuilder getOriginalRequestOrBuilder() {
      if (originalRequestBuilder_ != null) {
        return originalRequestBuilder_.getMessageOrBuilder();
      } else {
        return originalRequest_ == null ?
            th.co.scb.payment.generated.PaymentOrderRequest.getDefaultInstance() : originalRequest_;
      }
    }
    /**
     * <code>.th.co.scb.payment.PaymentOrderRequest originalRequest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        th.co.scb.payment.generated.PaymentOrderRequest, th.co.scb.payment.generated.PaymentOrderRequest.Builder, th.co.scb.payment.generated.PaymentOrderRequestOrBuilder> 
        getOriginalRequestFieldBuilder() {
      if (originalRequestBuilder_ == null) {
        originalRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            th.co.scb.payment.generated.PaymentOrderRequest, th.co.scb.payment.generated.PaymentOrderRequest.Builder, th.co.scb.payment.generated.PaymentOrderRequestOrBuilder>(
                getOriginalRequest(),
                getParentForChildren(),
                isClean());
        originalRequest_ = null;
      }
      return originalRequestBuilder_;
    }

    private java.lang.Object paymentResult_ = "";
    /**
     * <code>string paymentResult = 2;</code>
     * @return The paymentResult.
     */
    public java.lang.String getPaymentResult() {
      java.lang.Object ref = paymentResult_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        paymentResult_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string paymentResult = 2;</code>
     * @return The bytes for paymentResult.
     */
    public com.google.protobuf.ByteString
        getPaymentResultBytes() {
      java.lang.Object ref = paymentResult_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        paymentResult_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string paymentResult = 2;</code>
     * @param value The paymentResult to set.
     * @return This builder for chaining.
     */
    public Builder setPaymentResult(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      paymentResult_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string paymentResult = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPaymentResult() {
      
      paymentResult_ = getDefaultInstance().getPaymentResult();
      onChanged();
      return this;
    }
    /**
     * <code>string paymentResult = 2;</code>
     * @param value The bytes for paymentResult to set.
     * @return This builder for chaining.
     */
    public Builder setPaymentResultBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      paymentResult_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:th.co.scb.payment.PaymentOrderResponse)
  }

  // @@protoc_insertion_point(class_scope:th.co.scb.payment.PaymentOrderResponse)
  private static final th.co.scb.payment.generated.PaymentOrderResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new th.co.scb.payment.generated.PaymentOrderResponse();
  }

  public static th.co.scb.payment.generated.PaymentOrderResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PaymentOrderResponse>
      PARSER = new com.google.protobuf.AbstractParser<PaymentOrderResponse>() {
    @java.lang.Override
    public PaymentOrderResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PaymentOrderResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PaymentOrderResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PaymentOrderResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public th.co.scb.payment.generated.PaymentOrderResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

