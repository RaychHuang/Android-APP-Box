package com.example.jingzehuang.dagger2test.subcomponent;

import dagger.Subcomponent;

@Subcomponent(modules = SubSimpleModule.class)
public interface SubSimpleComponent {

  @Subcomponent.Builder
  interface Builder {
    SubSimpleComponent build();
  }
}
