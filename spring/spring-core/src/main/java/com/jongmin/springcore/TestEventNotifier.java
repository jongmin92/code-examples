package com.jongmin.springcore;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventNotifier implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println(event);
    }
}
