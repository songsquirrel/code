package com.song.tools.code.generator.controller;

import com.song.tools.code.generator.service.CodeGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Song.X
 * Date: 2021/3/30
 * Description:
 */
@Controller
@RequestMapping("/codeGenerator")
public class OperateController {

    @Resource
    CodeGeneratorService codeGenerator;

    @GetMapping("/test")
    public void test(){
        codeGenerator.outputCodeFolder();
    }
}
