package com.test.grpcTest.grpc_api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0)",
    comments = "Source: test.proto")
public class GrpcServiceGrpc {

  private GrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "GrpcService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.test.grpcTest.grpc_api.UnaryRequest,
      com.test.grpcTest.grpc_api.UnaryResponse> METHOD_SEND_UNARY_REQUEST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "GrpcService", "SendUnaryRequest"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.test.grpcTest.grpc_api.UnaryRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.test.grpcTest.grpc_api.UnaryResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcServiceStub newStub(io.grpc.Channel channel) {
    return new GrpcServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GrpcServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public void sendUnaryRequest(com.test.grpcTest.grpc_api.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.test.grpcTest.grpc_api.UnaryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_UNARY_REQUEST, responseObserver);
    }

    public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_UNARY_REQUEST,
            asyncUnaryCall(
              new MethodHandlers<
                com.test.grpcTest.grpc_api.UnaryRequest,
                com.test.grpcTest.grpc_api.UnaryResponse>(
                  this, METHODID_SEND_UNARY_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcServiceStub extends io.grpc.stub.AbstractStub<GrpcServiceStub> {
    private GrpcServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public void sendUnaryRequest(com.test.grpcTest.grpc_api.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.test.grpcTest.grpc_api.UnaryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_UNARY_REQUEST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcServiceBlockingStub extends io.grpc.stub.AbstractStub<GrpcServiceBlockingStub> {
    private GrpcServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public com.test.grpcTest.grpc_api.UnaryResponse sendUnaryRequest(com.test.grpcTest.grpc_api.UnaryRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_UNARY_REQUEST, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcServiceFutureStub extends io.grpc.stub.AbstractStub<GrpcServiceFutureStub> {
    private GrpcServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 一对一服务请求
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.test.grpcTest.grpc_api.UnaryResponse> sendUnaryRequest(
        com.test.grpcTest.grpc_api.UnaryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_UNARY_REQUEST, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_UNARY_REQUEST = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(GrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_UNARY_REQUEST:
          serviceImpl.sendUnaryRequest((com.test.grpcTest.grpc_api.UnaryRequest) request,
              (io.grpc.stub.StreamObserver<com.test.grpcTest.grpc_api.UnaryResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SEND_UNARY_REQUEST);
  }

}
