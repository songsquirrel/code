package com.walker.demo.stream.controller;

import com.walker.demo.stream.service.RocketMQService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author song
 * @date ces
 */
@RestController
public class Product {
    @Resource
    private RocketMQService mqService;

    @GetMapping("/send")
    public String sendMsg(){
        mqService.send();
        return "send message success!";
    }
}
