package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 * @author mingge
 *
 */
@Component
public class DemoEventPublisher {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    public void pushlish(String msg,String mail){
        applicationContext.publishEvent(new DemoEvent(this, msg,mail));
    }
    
}
