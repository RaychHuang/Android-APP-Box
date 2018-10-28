package com.example.jingzehuang.dagger2test.recursiveInject2;

import dagger.Module;
import dagger.Provides;

@Module
public class ProductModule {

    @Provides
    public Product provideProduct(String name) {
        return new Product(name);
    }
}
