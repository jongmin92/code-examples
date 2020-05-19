package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertySourceTest {

    @Test
    public void propertySourceTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                PropertySourceConfiguration.class);

        final NameService nameService = context.getBean(NameService.class);
        assertThat(nameService.getName()).isEqualTo("myTestBean");
    }
}
