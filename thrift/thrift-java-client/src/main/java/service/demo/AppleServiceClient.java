package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
 
import service.demo.Apple.Client;
 
public class AppleServiceClient {
 
    public static void main(String[] args) {
        System.out.println("客户端开始。。");
        TTransport transport = null;
        try{
            transport = new TSocket("localhost",9000,3000);
            TProtocol protocol = new TBinaryProtocol(transport);
            Client client = new Apple.Client(protocol);
            transport.open();
             
            String result = client.appleString("abc");
            System.out.println("服务端返回  。  " + result);
             
            int a = client.appleAdd(8);
            int b = client.appleMult(29, 3);
            System.out.println("a= " + a + "  b="+b);
             
        }catch(TTransportException e){
            e.printStackTrace();
        }catch(TException e){
            e.printStackTrace();
        }finally{
            if(null!=transport){
                transport.close();
            }
        }
    }
 
}
