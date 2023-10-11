package com.login.jdbclogin.CustomerKycTermination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

@Configuration

public class RabbitMQConfiguration {
    static Logger log = LoggerFactory.getLogger(RabbitMQConfiguration.class.getName());

    @Autowired
    Environment prop;

    @Bean
    public ConnectionFactory createNewConnection() {
        try {
            CachingConnectionFactory connection = new CachingConnectionFactory();
            connection.setHost("127.0.0.1");
            connection.setUsername("admin");
            connection.setPassword("SecurePassword");
            connection.setPort(15672);
            return connection;
        }catch(Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            log.error("Error message: "+exceptionAsString);
            return null;
        }
    }
    // Iprs broker setup

    @Bean
    public Exchange createIprsExchange() {
        return new DirectExchange(prop.getProperty("apiservice-iprs.exchange"), true, false);
    }

    @Bean
    public Binding bindIprsQueue() {
        return new Binding(prop.getProperty("apiservice-iprs.queue"), Binding.DestinationType.QUEUE,
                prop.getProperty("apiservice-iprs.exchange"), prop.getProperty("apiservice-iprs.key"), null);
    }
    @Bean
    public Exchange createFullfilmentsExchange() {
        return new DirectExchange(prop.getProperty("apiservice-fullfillment.exchange"), true, false);
    }

    @Bean
    public Binding bindFullfilmentQueue() {
        return new Binding(prop.getProperty("apiservice-fullfillment.queue"), Binding.DestinationType.QUEUE,
                prop.getProperty("apiservice-fullfillment.exchange"), prop.getProperty("apiservice-fullfillment.key"), null);
    }




}
