package com.jongmin.auto.app.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean
    public Book book() {
        return new Book("spring-boot", 25000);
    }
}
