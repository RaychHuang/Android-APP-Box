package com.example.jingzehuang.dagger2test.c4scope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raych on Oct.19, 18.
 */

@Module
public class TesterModule {

    @Singleton
    @Provides
    public ProductTester provideProductTestor() {
        return new ProductTester();
    }
}
