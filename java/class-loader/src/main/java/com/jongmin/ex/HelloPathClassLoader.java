package com.jongmin.ex;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloPathClassLoader extends ClassLoader {

    public HelloPathClassLoader() {
        System.out.println(getClass().getClassLoader());
    }

    public HelloPathClassLoader(ClassLoader parent) {
        super(parent);
    }

    public static void main(String[] args) {
        HelloPathClassLoader loader = new HelloPathClassLoader();
        IHelloClass helloObj = loader.helloLoadCalss("com.jongmin.ex.HelloPathClassLoaderTarget");
        System.out.println(helloObj.getClassLoaderName());
    }

    private IHelloClass helloLoadCalss(String className) {
        IHelloClass newObject = null;
        Class<?> foundClass = null;
        try {
            foundClass = findClass(className);
            newObject = (IHelloClass) foundClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return newObject;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        Class<?> foundClass = null;
        String path = String.format("%s/build/classes/java/main/%s.class",
                                    System.getProperty("user.dir"),
                                    className.replace('.', '/'));
        byte[] classBytes = readClassBytes(path);
        if (classBytes == null) {
            super.findClass(className);
        } else {
            foundClass = defineClass(className, classBytes, 0, classBytes.length);
        }

        return foundClass;
    }

    private byte[] readClassBytes(String path) {
        FileInputStream fis = null;
        byte[] classBytes = null;

        try {
            fis = new FileInputStream(path);
            classBytes = new byte[fis.available()];
            fis.read(classBytes);

            if (fis != null) {
                fis.close();
                fis = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classBytes;
    }
}
