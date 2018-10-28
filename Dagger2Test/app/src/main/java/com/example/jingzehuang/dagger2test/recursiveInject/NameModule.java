package com.example.jingzehuang.dagger2test.recursiveInject;

import dagger.Module;
import dagger.Provides;

@Module
public class NameModule {

    @Provides
    public String getName() {
        return "Sally is SB.";
    }
}
