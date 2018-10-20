package com.example.jingzehuang.dagger2test.c3;

import dagger.Component;

@Component(modules = com.example.jingzehuang.dagger2test.c3.SimpleModule.class, dependencies = TesterComponent.class)
public interface SimpleComponent {

    void inject(Destination destination);
}