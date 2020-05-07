package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("app.xml");
    }

    @Test
    public void constructorBaseTest() {
        assertThat(context.getBean(ThingTwo.class)).isNotNull();
        assertThat(context.getBean(ThingThree.class)).isNotNull();
        assertThat(context.getBean(ThingOne.class)).isNotNull();
    }

    @Test
    public void constructorArgumentTypeMatchingTest() {
        final ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
        assertThat(exampleBean).isNotNull();
        assertThat(exampleBean.getYears()).isEqualTo(4500);
        assertThat(exampleBean.getUltimateAnswer()).isEqualTo("2500");
    }

    @Test
    public void constructorArgumentIndexTest() {
        final ExampleBean exampleBean = context.getBean("exampleBean2", ExampleBean.class);
        assertThat(exampleBean).isNotNull();
        assertThat(exampleBean.getYears()).isEqualTo(4500);
        assertThat(exampleBean.getUltimateAnswer()).isEqualTo("2500");
    }

    @Test
    public void constructorArgumentNameTest() {
        final ExampleBean exampleBean = context.getBean("exampleBean3", ExampleBean.class);
        assertThat(exampleBean).isNotNull();
        assertThat(exampleBean.getYears()).isEqualTo(4500);
        assertThat(exampleBean.getUltimateAnswer()).isEqualTo("2500");
    }

    public static class CircularDependencyTest {

        @Test
        public void circularDependencyTest() {
            assertThrows(BeanCreationException.class,
                         () -> new ClassPathXmlApplicationContext("circular.xml"));
        }
    }
}
