package com.example.jingzehuang.dagger2test.c4;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Raych on Oct.19, 18.
 */

@Singleton
@Component (modules = com.example.jingzehuang.dagger2test.c4.TesterModule.class)
public interface TesterComponent {

    ProductTester getProductTester();
}
