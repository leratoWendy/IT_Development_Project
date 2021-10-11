package com.wendy.translators.config;


import com.wendy.repository.config.repositoryConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({repositoryConfiguration.class})
@ComponentScan(basePackages = "com.wendy.translators")
public class TranslatorConfigure {
}
