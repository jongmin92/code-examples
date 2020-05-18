package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
    }

    @Test
    void basicConceptsTest() {
        final AppConfig appConfig = context.getBean(AppConfig.class);
        final MyService service = context.getBean(MyService.class);

        assertThat(appConfig).isNotNull();
        assertThat(service).isNotNull();
    }
}
