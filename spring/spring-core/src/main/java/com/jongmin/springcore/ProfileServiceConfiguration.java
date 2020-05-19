package com.jongmin.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileServiceConfiguration {

    @Profile("development")
    @Bean("dev-a")
    public A devA() {
        return new A();
    }

    @Profile("production")
    @Bean("prod-a")
    public A prodA() {
        return new A();
    }
}
