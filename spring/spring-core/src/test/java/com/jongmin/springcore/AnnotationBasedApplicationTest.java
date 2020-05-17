package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBasedApplicationTest {

    private static ApplicationContext context;

    @BeforeAll
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("annotation-app.xml");
    }

    @Test
    public void primaryTest() {
        final MovieRecommender movieRecommender = context.getBean(MovieRecommender.class);
        final MovieCatalog movieCatalog = movieRecommender.getMovieCatalog();

        assertThat(movieRecommender).isNotNull();
        assertThat(movieCatalog).isNotNull();
        assertThat(movieCatalog.getName()).isEqualTo("first");
    }
}
