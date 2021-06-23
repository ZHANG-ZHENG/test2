package top.zhost.test;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttClientDemo {
    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://sub.zhost.top:1883";

    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "zz_mqtt_test";

    /**
     * 订阅标识
     */
//    public static final String MQTT_TOPIC = "xiasuhuei321";

    /**
     *
     */
    public static final String USERNAME = "admin";
    /**
     * 密码
     */
    public static final String PASSWORD = "Ruijie@Artemis";
    public static final String TOPIC_FILTER = "test";

    private volatile static MqttClient mqttClient;
    private static MqttConnectOptions options;
    
    private void testConnect() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，
            // MemoryPersistence设置clientid的保存形式，默认为以内存保存
            mqttClient = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID+System.currentTimeMillis(), new MemoryPersistence());
            // 配置参数信息
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，
            // 这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置用户名
            options.setUserName(USERNAME);
            // 设置密码
            options.setPassword(PASSWORD.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 连接
            mqttClient.connect(options);
            // 订阅
            mqttClient.subscribe(TOPIC_FILTER);
            // 设置回调
            mqttClient.setCallback(new MqttCallback() {
              
                public void connectionLost(Throwable throwable) {
                    System.out.println("connectionLost");
                }

               
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("Topic: " + s + " Message: " + mqttMessage.toString());
                }

                
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            Thread.sleep(10000);
            mqttClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }    	
    }

    public static void main(String... args) {
    	Thread t = new Thread() {
    		@Override
    		public void run() {
    			MqttClientDemo mqttClientDemo = new MqttClientDemo();
    			mqttClientDemo.testConnect();
    		}
    	};
    	t.start();

    }

}
