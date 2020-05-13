package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
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

    @Test
    public void applicationContextAwareTest() {
        final LifeCycleService service = context.getBean(LifeCycleService.class);

        final ApplicationContext context = service.getContext();
        assertThat(context).isNotNull();
        assertThat(context).isInstanceOf(ClassPathXmlApplicationContext.class);
    }

    @Test
    public void beanNameAwareTest() {
        final LifeCycleService service = context.getBean(LifeCycleService.class);

        final String beanName = service.getBeanName();
        assertThat(beanName).isNotNull();
        assertThat(beanName).isEqualTo("lifeCycleService");
    }
}
