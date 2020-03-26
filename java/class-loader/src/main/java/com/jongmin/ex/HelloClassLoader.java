package com.jongmin.ex;

public class HelloClassLoader extends ClassLoader {

    public HelloClassLoader() {
        super(HelloClassLoader.class.getClassLoader());
    }

    public HelloClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> foundClass = findLoadedClass(name);
        if (foundClass == null) {
            try {
                if (getParent() != null) {
                    foundClass = getParent().loadClass(name);
                } else {
                    foundClass = findSystemClass(name);
                }
            } catch (ClassNotFoundException e) {
                foundClass = findClass(name);
            }
        }

        return foundClass;
    }
}
