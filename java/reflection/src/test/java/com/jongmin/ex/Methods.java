package com.jongmin.ex;

import java.util.Arrays;

import org.junit.Test;

public class Methods {

    final Class<Book> clazz = Book.class;

    @Test
    public void getPublicMethods() {
        // 상위 클래스로부터 상속받은 method까지 모두 가져옴.
        Arrays.stream(clazz.getMethods())
              .forEach(System.out::println);
    }

    @Test
    public void getAllMethods() {
        // Book의 method만 가져온다.
        Arrays.stream(clazz.getDeclaredMethods())
              .forEach(System.out::println);
    }
}
