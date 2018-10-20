package com.example.jingzehuang.dagger2test.c4;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    @Inject
    ProductTester tester;

    SimpleComponent component;

    public void init() {
        if (component == null) {
            component = DaggerSimpleComponent
                    .builder()
                    .simpleModule(new SimpleModule(this))
                    .testerModule(new TesterModule())
                    .build();
        }
        component.inject(this);
    }
}
