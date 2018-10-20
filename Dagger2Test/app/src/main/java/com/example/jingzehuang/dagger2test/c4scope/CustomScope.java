package com.example.jingzehuang.dagger2test.c4scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Raych on Oct.19, 18.
 */

@Scope
@Retention(RUNTIME)
public @interface CustomScope {
}
