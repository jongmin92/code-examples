package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("scope.xml");
    }

    @Test
    public void singletonTest() {
        final SimpleRepository bean1 = context.getBean(SimpleRepository.class);
        final SimpleRepository bean2 = context.getBean(SimpleRepository.class);

        assertThat(bean1).isEqualTo(bean2);
    }
}
