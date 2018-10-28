package com.example.jingzehuang.dagger2test.c1inject.basic;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    public void init() {
//        DaggerSimpleComponent.builder()
//                .simpleModule(new ProductModule(this))
//                .build()
//                .inject(this);
    }
}
