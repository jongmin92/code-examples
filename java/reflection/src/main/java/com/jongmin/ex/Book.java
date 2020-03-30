package com.jongmin.ex;

public class Book implements IBook {

    private final String name;
    private final int price;
    private int privateValue;

    int packagePrivateValue;

    public int publicValue;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
        this.privateValue = 10;
        this.packagePrivateValue = 20;
        this.publicValue = 30;
    }

    public Book(String name, int price, int privateValue, int packagePrivateValue, int publicValue) {
        this.name = name;
        this.price = price;
        this.privateValue = privateValue;
        this.packagePrivateValue = packagePrivateValue;
        this.publicValue = publicValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    private String privateMethod() {
        return "privateMethod";
    }

    String packagePrivateMethod() {
        return "packagePrivateMethod";
    }

    public String publicMethod() {
        return "publicMethod";
    }
}
