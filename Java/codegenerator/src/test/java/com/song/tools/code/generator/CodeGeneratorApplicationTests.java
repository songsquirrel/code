package com.song.tools.code.generator;

import com.song.tools.code.generator.service.CodeGeneratorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

@SpringBootTest
class CodeGeneratorApplicationTests {

    @Resource
    CodeGeneratorService codeGenerator;

    @Test
    void contextLoads() {
        codeGenerator.outputCodeFolder();
    }

}
