package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBasedApplicationContextTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("classpath:app.xml");
    }

    @Test
    public void testCreateBean() {
        assertThat(context).isNotNull();

        final SimpleService simpleService = context.getBean(SimpleService.class);
        assertThat(simpleService).isNotNull();
        assertThat(simpleService.getSimpleRepository()).isNotNull();

        final SimpleRepository simpleRepository = context.getBean(SimpleRepository.class);
        assertThat(simpleRepository).isNotNull();
    }

    @Test
    public void testBeanDefinition() {
        assertThat(context.containsBeanDefinition("simpleService")).isTrue();
        assertThat(context.containsBeanDefinition("simpleRepository")).isTrue();
    }

    @Test
    public void testCreateBeanByFactoryMethod() {
        final ClientService clientService = context.getBean("clientService", ClientService.class);
        assertThat(clientService).isNotNull();
    }

    @Test
    public void testCreateBeanByFactoryBean() {
        final ClientService clientService = context.getBean("clientService2", ClientService.class);
        assertThat(clientService).isNotNull();
    }
}
