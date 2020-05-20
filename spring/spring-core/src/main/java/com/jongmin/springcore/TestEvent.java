package com.jongmin.springcore;

import org.springframework.context.ApplicationEvent;

import lombok.ToString;

@ToString
public class TestEvent extends ApplicationEvent {

    private final String content;

    /**
     * Create a new {@code ApplicationEvent}.
     * @param source the object on which the event initially occurred or with
     * which the event is associated (never {@code null})
     */
    public TestEvent(Object source, String content) {
        super(source);
        this.content = content;
    }
}
