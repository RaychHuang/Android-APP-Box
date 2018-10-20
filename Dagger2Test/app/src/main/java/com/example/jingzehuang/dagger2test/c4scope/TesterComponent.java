package com.example.jingzehuang.dagger2test.c4scope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Raych on Oct.19, 18.
 */

@Singleton
@Component (modules = TesterModule.class)
public interface TesterComponent {

    ProductTester getProductTester();
}
