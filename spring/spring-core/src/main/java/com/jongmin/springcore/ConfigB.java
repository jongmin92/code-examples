package com.jongmin.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(ConfigA.class)
@Configuration
public class ConfigB {

    @Bean
    public B b() {
        return new B();
    }
}
