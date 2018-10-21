package com.example.jingzehuang.dagger2test.moduleWithParams;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    public void init() {
        DaggerSimpleComponent.builder()
                .simpleModule(new SimpleModule(this))
                .build()
                .inject(this);
    }
}
