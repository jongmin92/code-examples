package com.jongmin.ex;

import java.util.Arrays;

import org.junit.Test;

public class Fields {

    final Class<Book> clazz = Book.class;

    @Test
    public void getPublicFields() throws NoSuchFieldException {
        Arrays.stream(clazz.getFields())
              .forEach(System.out::println);
    }

    @Test
    public void getAllFields() throws NoSuchFieldException {
        Arrays.stream(clazz.getDeclaredFields())
              .forEach(System.out::println);
    }
}
