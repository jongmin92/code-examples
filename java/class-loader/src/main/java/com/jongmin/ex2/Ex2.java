package com.jongmin.ex2;

public class Ex2 {
    public static void main(String[] args) {
        final ClassLoader classLoader = Ex2.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
