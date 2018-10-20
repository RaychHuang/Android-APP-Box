package com.example.jingzehuang.dagger2test.c4;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {com.example.jingzehuang.dagger2test.c4.SimpleModule.class, com.example.jingzehuang.dagger2test.c4.TesterModule.class})
public interface SimpleComponent {

    void inject(Destination destination);
}