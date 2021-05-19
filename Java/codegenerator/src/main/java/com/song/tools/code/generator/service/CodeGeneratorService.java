package com.song.tools.code.generator.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardOpenOption.*;

/**
 * @author Song.X
 * Date: 2021/3/25
 * Description:
 */
@Service
public class CodeGeneratorService {

    private final Configuration configuration;

    public CodeGeneratorService(@Qualifier("freeMakerConfiguration") Configuration configuration) {
        this.configuration = configuration;
    }

    public void outputCodeFolder() {

        Map<String, String> root = new HashMap<>();
        root.put("user", "xs");
        try {
            Writer out = new OutputStreamWriter(Files.newOutputStream(Paths.get("ceshi.html")));
            Template template = configuration.getTemplate("test.ftl");
            template.process(root, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
