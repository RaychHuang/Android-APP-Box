package com.example.jingzehuang.dagger2test.subcomponent;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import dagger.multibindings.Multibinds;
import java.util.Set;

@Module
public abstract class SimpleModule {

  @Multibinds
  abstract Set<String> aSet();
}
