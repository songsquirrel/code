package com.song.tools.code.generator;

import com.song.tools.code.generator.service.CodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



/**
 * 去除SpringBoot数据库配置
 * @author selfDenial
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApplication.class, args);
    }

}
