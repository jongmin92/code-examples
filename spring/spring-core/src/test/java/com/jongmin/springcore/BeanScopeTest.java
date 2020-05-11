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
        final SimpleRepository bean1 = context.getBean("simpleRepository", SimpleRepository.class);
        final SimpleRepository bean2 = context.getBean("simpleRepository", SimpleRepository.class);

        assertThat(bean1).isEqualTo(bean2);
    }

    @Test
    public void prototypeTest() {
        final SimpleRepository bean1 = context.getBean("simpleRepository2", SimpleRepository.class);
        final SimpleRepository bean2 = context.getBean("simpleRepository2", SimpleRepository.class);

        assertThat(bean1).isNotEqualTo(bean2);
    }

    @Test
    public void singletonWithSingletonTest() {
        final SimpleService simpleService = context.getBean("simpleService", SimpleService.class);
        final SimpleRepository bean1 = simpleService.getSimpleRepository();
        final SimpleRepository bean2 = simpleService.getSimpleRepository();

        assertThat(bean1).isEqualTo(bean2);
    }

    @Test
    public void singletonWithPrototypeTest() {
        final SimpleService simpleService = context.getBean("simpleService2", SimpleService.class);
        final SimpleRepository bean1 = simpleService.getSimpleRepository();
        final SimpleRepository bean2 = simpleService.getSimpleRepository();

        assertThat(bean1).isEqualTo(bean2);
    }

    @Test
    public void singletonWithPrototypeProxyTest() {
        final SimpleServiceWithProxy simpleServiceWithProxy = context.getBean(SimpleServiceWithProxy.class);
        final SimpleRepository bean1 = simpleServiceWithProxy.getSimpleRepository();
        final SimpleRepository bean2 = simpleServiceWithProxy.getSimpleRepository();

        assertThat(bean1).isEqualTo(bean2);
    }
}
