package com.test.server;
import com.test.grpcTest.grpc_api.GrpcServiceGrpc;
import com.test.grpcTest.grpc_api.UnaryRequest;
import com.test.grpcTest.grpc_api.UnaryResponse;
import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
//Grpc����������
public class GrpcServer {
    private int port = 50051;//grpc����˿�
    private Server server;//grpc server
    public static void main(String[] args) throws IOException,InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
    private void start() throws IOException {
        //ָ��grpc�������˿ڡ��ӿڷ����������grpc������
        server = ServerBuilder.forPort(port).addService(new GreeterImpl())
            .build().start();
        System.out.println("service start...");
        //���ͣ���߼�
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                GrpcServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
//�ڲ��࣬�̳г����� GrpcServiceGrpc.GrpcServiceImplBase��
//����д���񷽷� sendUnaryRequest
    private class GreeterImpl extends GrpcServiceGrpc.GrpcServiceImplBase {
//UnaryRequest �ͻ������������
//StreamObserver<UnaryResponse> ���ظ��ͻ��˵ķ�װ����
        public void sendUnaryRequest(UnaryRequest request,StreamObserver<UnaryResponse> responseObserver) {
            ByteString message = request.getData();
            System.out.println("server, serviceName:" + request.getServiceName()
                + "; methodName:" + request.getMethodName()+"; datas:"+new String(message.toByteArray()));
            UnaryResponse.Builder builder = UnaryResponse.newBuilder();           
            builder.setServiceName("GrpcServiceResponse").setMethodName("sendUnaryResponse");
            responseObserver.onNext(builder.build());
            responseObserver.onCompleted();
        }
    }
}