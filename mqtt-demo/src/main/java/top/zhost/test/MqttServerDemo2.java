package top.zhost.test;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttServerDemo2 {
    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://172.18.33.117:1883";
	//public static final String MQTT_BROKER_HOST = "tcp://172.20.124.14:1883";
    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "vb/task_result";

    private static String userName = "admin";
    private static String password = "ruijie123";

    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "zz_server_test_mqtt";
    private static MqttTopic topic;
    private static MqttClient client;

    public static void main(String... args) {
        // 推送消息
        MqttMessage message = new MqttMessage();
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(10);
            options.setKeepAliveInterval(20);

            topic = client.getTopic(MQTT_TOPIC);

            message.setQos(1);
            message.setRetained(false);
            String messageContent = "{\"taskItemId\":\"1\",\"mac\":\"1\",\"success\":\"true\"}";
            message.setPayload(messageContent.getBytes());
            client.connect(options);

            while (true) {
                MqttDeliveryToken token = topic.publish(message);
                token.waitForCompletion();
                System.out.println("server已经发送 ");
                Thread.sleep(10000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}