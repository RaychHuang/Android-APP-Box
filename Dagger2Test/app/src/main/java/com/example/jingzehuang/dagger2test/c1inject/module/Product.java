package com.example.jingzehuang.dagger2test.c1inject.module;

import javax.inject.Inject;

public class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
