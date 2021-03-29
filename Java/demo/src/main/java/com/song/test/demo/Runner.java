package com.song.test.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Song.X
 * Date: 2020/11/19
 * Description:
 */
@Component
public class Runner implements CommandLineRunner {

    @Resource
    InitDao dao;

    @Override
    public void run(String... args) throws Exception {
        String fromDual = dao.getFromDual();
        if ("123".equals(fromDual)) {
            System.out.println("---------success!");
        }
    }
}
