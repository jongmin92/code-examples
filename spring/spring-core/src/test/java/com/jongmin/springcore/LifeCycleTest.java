package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("lifecycle.xml");
        context.registerShutdownHook();
    }

    @Test
    public void initializingBeanTest() {
        final LifeCycleService service = context.getBean(LifeCycleService.class);

        assertThat(service.getAfterPropertiesValue()).isEqualTo(100);
    }

    @Test
    public void initTest() {
        final LifeCycleService service = context.getBean(LifeCycleService.class);

        assertThat(service.getInitValue()).isEqualTo(300);
    }
}
