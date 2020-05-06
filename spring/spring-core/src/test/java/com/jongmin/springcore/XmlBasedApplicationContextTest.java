package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBasedApplicationContextTest {

    @Test
    public void testCreateBean() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app.xml");
        assertThat(context).isNotNull();

        final Object simpleServiceObject = context.getBean("simpleService");
        assertThat(simpleServiceObject).isNotNull();

        final SimpleService simpleService = context.getBean(SimpleService.class);
        assertThat(simpleService).isNotNull();

        final SimpleService simpleService2 = context.getBean("simpleService", SimpleService.class);
        assertThat(simpleService2).isNotNull();
    }
}
