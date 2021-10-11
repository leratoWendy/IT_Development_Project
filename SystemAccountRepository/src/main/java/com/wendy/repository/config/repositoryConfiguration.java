package com.wendy.repository.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.wendy.repository.persistence")
@EntityScan("com.wendy.domain.persistence")
@PropertySource(value = "classpath:repoconfigProps.properties")
public class repositoryConfiguration {
}
