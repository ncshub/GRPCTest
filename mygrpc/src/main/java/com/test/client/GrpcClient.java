package com.test.client;
import java.util.concurrent.TimeUnit;
import com.test.grpcTest.grpc_api.GrpcServiceGrpc;
import com.test.grpcTest.grpc_api.UnaryRequest;
import com.test.grpcTest.grpc_api.UnaryResponse;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
//grpc�ͻ�����
public class GrpcClient {
    private final ManagedChannel channel;//�ͻ������������ͨ��channel
    private final GrpcServiceGrpc.GrpcServiceBlockingStub blockStub;//����ʽ�ͻ��˴���ڵ�
    public GrpcClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();//ָ��grpc��������ַ�Ͷ˿ڳ�ʼ��ͨ��channel
        blockStub = GrpcServiceGrpc.newBlockingStub(channel);//����ͨ��channel��ʼ���ͻ��˴���ڵ�
    }
    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    //�ͻ��˷���
    public void sayHello(String str){
        //��װ�������
        UnaryRequest request = UnaryRequest.newBuilder().setServiceName("GrpcServiceRequest").setMethodName("sendUnaryRequest").setData(ByteString.copyFrom(str.getBytes()))
            .build();
        //�ͻ��˴���ڵ����grpc����ӿڣ������������
        UnaryResponse response = blockStub.sendUnaryRequest(request);
        System.out.println("client, serviceName:"+response.getServiceName()+"; methodName:"+response.getMethodName());
    }
    public static void main(String[] args) throws InterruptedException{
        //��ʼ��grpc�ͻ��˶���
        GrpcClient client = new GrpcClient("127.0.0.1",50051);
        for(int i=0; i<5; i++){
            client.sayHello("client word:"+ i);
            Thread.sleep(3000);
        }
    }
}