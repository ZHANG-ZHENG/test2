package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 事件测试类
 * @author mingge
 *
 */
public class EventTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);
        DemoEventPublisher demoEventPublisher=context.getBean(DemoEventPublisher.class);
        demoEventPublisher.pushlish("张三1","565792147@qq.com");
        demoEventPublisher.pushlish("张三2","565792147@qq.com");
        demoEventPublisher.pushlish("张三3","565792147@qq.com");
        demoEventPublisher.pushlish("张三4","565792147@qq.com");
        demoEventPublisher.pushlish("张三5","565792147@qq.com");
        context.close();
    }
}