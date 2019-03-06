package com.example.jingzehuang.dagger2test.subcomponent;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    public void init() {
        SimpleComponent simpleComponent = DaggerSimpleComponent.builder().build();
    }
}
