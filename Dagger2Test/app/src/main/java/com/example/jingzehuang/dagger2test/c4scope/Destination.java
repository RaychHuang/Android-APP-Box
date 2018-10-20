package com.example.jingzehuang.dagger2test.c4scope;

import javax.inject.Inject;

public class Destination {

    @Inject
    Product product;

    @Inject
    ProductTester tester;

    TesterComponent testerComponent;
    SimpleComponent component;

    public void init() {
        if (testerComponent == null) {
            testerComponent = DaggerTesterComponent
                    .builder()
                    .testerModule(new TesterModule())
                    .build();
        }

        if (component == null) {
            component = DaggerSimpleComponent
                    .builder()
                    .simpleModule(new SimpleModule(this))
                    .testerComponent(testerComponent)
                    .build();
        }

        component.inject(this);
    }
}
