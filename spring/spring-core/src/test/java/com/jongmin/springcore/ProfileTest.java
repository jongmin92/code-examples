package com.jongmin.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileTest {

    @Test
    public void activateProfileTest() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development");
        context.register(ProfileServiceConfiguration.class);
        context.refresh();

        final A a = context.getBean("dev-a", A.class);
        assertThat(a).isNotNull();
    }
}
