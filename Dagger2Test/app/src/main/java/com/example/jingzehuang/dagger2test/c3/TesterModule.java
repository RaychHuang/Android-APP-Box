package com.example.jingzehuang.dagger2test.c3;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raych on Oct.19, 18.
 */

@Module
public class TesterModule {

    @Provides
    public ProductTester provideProductTestor() {
        return new ProductTester();
    }
}
