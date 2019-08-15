package com.zimo.utils.JMS;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;

import javax.jms.ConnectionFactory;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/6/6,1:43 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class MQConfig {

    private final String ActiveMQ_URL = "";

    private final String ActiveMQ_USER = "";

    private final String ActiveMQ_PASSWORD = "";


    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(ActiveMQ_URL);
        connectionFactory.setUserName(ActiveMQ_USER);
        connectionFactory.setPassword(ActiveMQ_PASSWORD);
        return connectionFactory;
    }
}
