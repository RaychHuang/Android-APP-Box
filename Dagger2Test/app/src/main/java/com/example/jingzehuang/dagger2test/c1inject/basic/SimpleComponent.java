package com.example.jingzehuang.dagger2test.c1inject.basic;

import dagger.Component;

@Component(modules = com.example.jingzehuang.dagger2test.c1inject.basic.SimpleModule.class)
public interface SimpleComponent {

    void inject(Destination destination);
}