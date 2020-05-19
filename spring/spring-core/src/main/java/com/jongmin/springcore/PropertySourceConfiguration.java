package com.jongmin.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertySourceConfiguration {

    @Autowired
    Environment env;

    @Bean
    public NameService nameService() {
        return new NameService(env.getProperty("testbean.name"));
    }
}
