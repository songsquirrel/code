package com.song.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author selfDenial
 */
@SpringBootApplication
@ComponentScan({"com.song.common", "com.song.demo"})
public class SyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyncApplication.class, args);
    }

}
