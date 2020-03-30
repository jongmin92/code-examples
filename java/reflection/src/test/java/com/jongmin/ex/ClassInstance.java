package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ClassInstance {

    @Test
    public void getClassInstance_direct() {
        final Class<Book> clazz = Book.class;
        assertThat(clazz, notNullValue());
    }

    @Test
    public void getClassInstance_usingInstance() {
        final Book book = new Book("Java8", 20000);
        final Class<? extends Book> clazz = book.getClass();
        assertThat(clazz, notNullValue());
    }

    @Test
    public void getClassInstance_usingClassName() throws ClassNotFoundException {
        final Class<?> clazz = Class.forName("com.jongmin.ex.Book");
        assertThat(clazz, notNullValue());
    }
}
