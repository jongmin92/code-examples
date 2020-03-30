package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SuperClass {

    @Test
    public void getSuperClass() {
        final Class<Book> clazz = Book.class;

        Class<? super Book> superClazz = clazz.getSuperclass();
        assertThat(superClazz, sameInstance(Object.class));
    }
}
