package com.example.jingzehuang.dagger2test.c3;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Raych on Oct.19, 18.
 */

@Component (modules = com.example.jingzehuang.dagger2test.c3.TesterModule.class)
public interface TesterComponent {

    ProductTester getProductTester();
}
