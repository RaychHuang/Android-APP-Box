package com.example.jingzehuang.dagger2test.c1inject.basic;

import dagger.Module;
import dagger.Provides;

@Module
public class SimpleModule {

    private Destination destination;

    public SimpleModule(Destination destination) {
        this.destination = destination;
    }
}
