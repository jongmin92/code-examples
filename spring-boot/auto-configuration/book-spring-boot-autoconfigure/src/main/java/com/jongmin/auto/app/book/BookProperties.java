package com.jongmin.auto.app.book;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("book")
public class BookProperties {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
