package com.wendy.webservices.config;


import com.wendy.logic.config.BuslogicConfig;
import com.wendy.translators.config.TranslatorConfigure;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BuslogicConfig.class})
@ComponentScan(basePackages = "com.wendy.webservices")
public class webconfig {
}
