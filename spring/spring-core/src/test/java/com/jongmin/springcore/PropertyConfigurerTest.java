package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyConfigurerTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("property-configurer.xml");
    }

    @Test
    public void propertySourcePlaceHolderTest() {
        final BasicDataSource dataSource = context.getBean(BasicDataSource.class);

        assertThat(dataSource).isNotNull();
        assertThat(dataSource.getDriverClassName()).isEqualTo("org.hsqldb.jdbcDriver");
        assertThat(dataSource.getUrl()).isEqualTo("jdbc:hsqldb:hsql://dev:9002");
        assertThat(dataSource.getUsername()).isEqualTo("root");
        assertThat(dataSource.getPassword()).isEqualTo("password");
    }
}
