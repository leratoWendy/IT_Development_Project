package com.wendy.logic.config;


import com.wendy.translators.config.TranslatorConfigure;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TranslatorConfigure.class})
@ComponentScan(basePackages = "com.wendy.logic")
public class BuslogicConfig {
}
