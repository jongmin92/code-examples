package com.jongmin.springcore;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventNotifier2 {

    @EventListener
    public void processTestEvent(TestEvent event) {
        System.out.println(event);
    }
}
