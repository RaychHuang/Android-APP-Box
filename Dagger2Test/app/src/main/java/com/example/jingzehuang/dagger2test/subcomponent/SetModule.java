package com.example.jingzehuang.dagger2test.subcomponent;

import dagger.multibindings.Multibinds;
import java.util.Set;

public abstract class SetModule {

  @Multibinds
  abstract Set<String> aSet();
}
