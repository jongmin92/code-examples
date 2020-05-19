package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBasedApplication2Test {

    @Test
    public void contextLoadTest() {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final MyService service = context.getBean(MyService.class);
        assertThat(service).isNotNull();
    }

    @Test
    public void importAnnotationTest() {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);

        final A a = context.getBean(A.class);
        final B b = context.getBean(B.class);

        assertThat(a).isNotNull();
        assertThat(b).isNotNull();
    }
}
