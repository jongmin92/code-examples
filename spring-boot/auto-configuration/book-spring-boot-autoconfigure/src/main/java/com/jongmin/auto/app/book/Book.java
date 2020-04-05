package com.jongmin.auto.app.book;

public class Book {

    private final String name;
    private final int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
               "name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}
