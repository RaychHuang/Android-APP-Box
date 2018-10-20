package com.example.jingzehuang.dagger2test.c4scope;

import javax.inject.Singleton;

import dagger.Component;

@CustomScope
@Component(modules = SimpleModule.class, dependencies = TesterComponent.class)
public interface SimpleComponent {

    void inject(Destination destination);
}