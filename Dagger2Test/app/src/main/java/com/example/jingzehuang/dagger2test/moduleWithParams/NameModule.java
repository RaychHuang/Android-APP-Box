package com.example.jingzehuang.dagger2test.moduleWithParams;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raych on Oct.20, 18.
 */
@Module
public class NameModule {

    @Provides
    public String getName() {
        return "Sally is SB.";
    }
}
