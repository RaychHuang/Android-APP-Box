package com.example.jingzehuang.dagger2test.c1inject.module;

import dagger.Module;
import dagger.Provides;

@Module
public class SimpleModule {

    private Destination destination;

    public SimpleModule(Destination destination) {
        this.destination = destination;
    }

    @Provides
    public Product provideProduct() {
        return new Product("Module");
    }
}
