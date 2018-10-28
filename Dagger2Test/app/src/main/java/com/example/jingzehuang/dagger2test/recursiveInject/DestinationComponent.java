package com.example.jingzehuang.dagger2test.recursiveInject;

import dagger.Component;

@Component(modules = {NameModule.class, ProductTagModule.class})
public interface DestinationComponent {

    void inject(Destination destination);
}