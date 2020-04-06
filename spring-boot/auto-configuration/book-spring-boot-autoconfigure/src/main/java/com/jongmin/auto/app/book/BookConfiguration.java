package com.jongmin.auto.app.book;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(Book.class)
@EnableConfigurationProperties(BookProperties.class)
public class BookConfiguration {

    @Bean
    public Book book(BookProperties bookProperties) {
        return new Book(bookProperties.getName(), bookProperties.getPrice());
    }
}
