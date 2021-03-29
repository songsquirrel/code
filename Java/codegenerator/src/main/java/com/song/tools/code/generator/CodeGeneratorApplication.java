package com.song.tools.code.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 去除SpringBoot数据库配置
 * @author selfDenial
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodeGeneratorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CodeGeneratorApplication.class, args);
        run.getBean("");
    }

}
