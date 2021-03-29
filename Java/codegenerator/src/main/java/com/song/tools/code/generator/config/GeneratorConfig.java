package com.song.tools.code.generator.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.io.IOException;

/**
 * @author Song.X
 * Date: 2021/3/25
 * Description:
 */
@org.springframework.context.annotation.Configuration
public class GeneratorConfig {
    @Value("${code.generator.output.path:./output/}")
    private String outputPath;

    @Value("${code.generator.template.path:templates/}")
    private String templatePath;

    @Value("${code.generator.charset:UTF-8")
    private String charset;


    /**
     * 配置freemarker
     *
     * @return configuration
     * @throws IOException
     */
    @Bean(name = "freeMakerConfiguration")
    @Scope(scopeName = "singleton")
    public Configuration injectTemplate() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(getClass(), templatePath);
        cfg.setDefaultEncoding(charset);
        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

        // Wrap unchecked exceptions thrown during template processing into TemplateException-s:
        cfg.setWrapUncheckedExceptions(true);

        // Do not fall back to higher scopes when reading a null loop variable:
        cfg.setFallbackOnNullLoopVariable(false);
        return cfg;
    }
}
