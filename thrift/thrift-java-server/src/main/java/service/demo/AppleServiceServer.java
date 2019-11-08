package service.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
 
public class AppleServiceServer {
 
    public static void main(String[] args) throws TTransportException {
        System.out.println("apple ·þÎñ¶Ë¿ªÆô¡£¡£");
        TProcessor tprocessor = new Apple.Processor<Apple.Iface>(new AppleServiceImpl());
        TServerSocket serverTransport = new TServerSocket(9000);
        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
         
        TServer server = new TSimpleServer(tArgs);
        server.serve();
    }
 
}