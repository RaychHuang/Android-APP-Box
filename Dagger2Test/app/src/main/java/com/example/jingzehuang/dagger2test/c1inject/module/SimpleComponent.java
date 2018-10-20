package com.example.jingzehuang.dagger2test.c1inject.module;

import dagger.Component;

@Component(modules = com.example.jingzehuang.dagger2test.c1inject.module.SimpleModule.class)
public interface SimpleComponent {

    void inject(Destination destination);
}