package com.example.jingzehuang.dagger2test.c4scope;

import dagger.Module;
import dagger.Provides;

@Module
public class SimpleModule {

    private Destination destination;

    public SimpleModule(Destination destination) {
        this.destination = destination;
    }

    @CustomScope
    @Provides
    public Product provideProduct() {
        return new Product();
    }
}
