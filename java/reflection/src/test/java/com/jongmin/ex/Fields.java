package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Field;
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

    @Test
    public void setField() throws Exception {
        final int price = 0;
        final Book book = new Book("name", price);

        assertThat(book.getPrice(), is(price));

        final int privateValue = 1;
        final Field privateValueField = clazz.getDeclaredField("privateValue");
        assertThat(privateValueField, notNullValue());

        privateValueField.setAccessible(true);
        privateValueField.setInt(book,privateValue);
        assertThat(book.getPrivateValue(), is(privateValue));
    }
}
