package top.zhost.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class Sender {
    //默认代理地址 "failover://tcp://localhost:61616"  服务器地址不同IP修改不同的IP
    //private static final String BROKER_URL=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final String BROKER_URL="failover://tcp://sub.zhost.top:61616";
    //消息队列名称
    private static final String SUBJECT="zz-queue";
    private static int i=1;
    public static void main(String[] args) throws JMSException, InterruptedException {
        //初始化连接工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("admin","Ruijie@Artemis",BROKER_URL);
        //建立连接
        Connection conn=  connectionFactory.createConnection();
        //启动连接
        conn.start();
        //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session= conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建目标队列
        Destination dest = session.createQueue(SUBJECT);
        //通过session创建消息的发送者
        MessageProducer producer=session.createProducer(dest);
        while(true){
            //定义要发送的消息
            TextMessage message= session.createTextMessage("======ActiveMQ发送消息===="+i+"===");
            //发送消息
            producer.send(message);
            System.out.println("message:"+message);
            //休眠2秒
            Thread.sleep(2000);
            i++;
        }
//      conn.close();

    }

}
