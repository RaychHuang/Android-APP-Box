package com.example.jingzehuang.dagger2test.recursiveInject;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    public void init() {
        DaggerDestinationComponent.builder()
            .nameModule(new NameModule())
            .productTagModule(new ProductTagModule())
            .build()
            .inject(this);
    }
}
