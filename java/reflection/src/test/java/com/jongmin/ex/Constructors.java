package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.junit.Test;

public class Constructors {

    final Class<Book> clazz = Book.class;

    @Test
    public void testConstructors() {
        Arrays.stream(clazz.getConstructors())
              .forEach(System.out::println);
    }

    @Test
    public void testCreateInstanceUsingConstructor() throws Exception {
        final Constructor<Book> constructor = clazz.getConstructor(String.class, int.class);
        assertThat(constructor, notNullValue());

        final String name = "name";
        final int price = 0;

        final Book book = constructor.newInstance(name, price);
        assertThat(book, notNullValue());
        assertThat(book.getName(), is(name));
        assertThat(book.getPrice(), is(price));
    }
}
