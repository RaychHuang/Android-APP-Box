package com.example.jingzehuang.dagger2test.c1inject.basic;

import javax.inject.Inject;

public class Product {

    private String name;

    @Inject
    public Product() {
        this.name = "Basic";
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
