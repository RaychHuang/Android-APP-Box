package com.example.jingzehuang.dagger2test.recursiveInject2;

import dagger.Module;
import dagger.Provides;

@Module
public class NameModule {

    @Provides
    public String getName() {
        return "Sally is SB.";
    }
}
