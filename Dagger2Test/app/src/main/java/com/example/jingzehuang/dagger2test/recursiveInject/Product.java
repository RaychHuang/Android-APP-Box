package com.example.jingzehuang.dagger2test.recursiveInject;

import javax.inject.Inject;

public class Product {

    private String name;
    @Inject
    ProductTag tag;

    @Inject
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
