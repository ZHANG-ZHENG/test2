package top.zhost.test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description 基于发布/订阅模式传输类型的生产者测试
 */
public class TopicReceiver {

    private static final String ACTIVEMQ_URL = "tcp://sub.zhost.top:61616";

    public static void main(String[] args) throws JMSException, InterruptedException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin","Ruijie@Artemis",ACTIVEMQ_URL);
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 打开连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
        Destination destination = session.createTopic("topicTest");
        // 创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        // 向队列推送10个文本消息数据
        int i = 0;
        while(true){
        	i++;
            // 创建文本消息
            TextMessage message = session.createTextMessage("第" + i + "个文本消息");
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("已发送的消息：" + message.getText());
            Thread.sleep(2000);
        }
        //关闭连接
       // connection.close();
    }

}
