package com.walker.demo.stream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author song
 * @date 2021/5/3
 * @description rocketMQ service
 */
@Slf4j
@EnableBinding(Source.class)
public class RocketMQService {

    @Resource
    @Qualifier("output")
    private MessageChannel messageChannel;
    @Value("${spring.cloud.stream.bindings.output.destination:undefined}")
    private String topic;

    @Value("${spring.application.name:undefined")
    private String sender;

    public int send(){
        MessageBuilder<String> test_message_send = MessageBuilder.withPayload("test message send");
        Message<String> build = test_message_send.build();
        messageChannel.send(build);
        return 0;
    }
}
