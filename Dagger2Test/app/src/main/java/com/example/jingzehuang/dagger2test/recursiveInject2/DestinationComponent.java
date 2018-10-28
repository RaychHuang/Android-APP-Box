package com.example.jingzehuang.dagger2test.recursiveInject2;

import dagger.Component;

@Component(dependencies = ProductComponent.class)
public interface DestinationComponent {

    void inject(Destination destination);
}