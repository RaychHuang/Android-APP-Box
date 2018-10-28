package com.example.jingzehuang.dagger2test.recursiveInject2;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    public void init() {
        ProductComponent productComponent = DaggerProductComponent
            .builder()
            .nameModule(new NameModule())
            .productTagModule(new ProductTagModule())
            .build();

        DaggerDestinationComponent.builder()
            .productComponent(productComponent)
            .build()
            .inject(this);
    }
}
