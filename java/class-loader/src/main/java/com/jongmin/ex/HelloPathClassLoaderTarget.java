package com.jongmin.ex;

public class HelloPathClassLoaderTarget implements IHelloClass {

    public HelloPathClassLoaderTarget() {
    }

    @Override
    public String getClassLoaderName() {
        return getClass().getClassLoader().toString();
    }
}
