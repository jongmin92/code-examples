package com.jongmin.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jongmin.auto.app.book.Book;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @Component
    @RequiredArgsConstructor
    public static class AppRunner implements ApplicationRunner {

        private final ApplicationContext context;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            final Book book = context.getBean(Book.class);
            System.out.println(book.toString());
        }
    }
}
