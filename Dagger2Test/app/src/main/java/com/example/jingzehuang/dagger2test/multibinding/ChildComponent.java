package com.example.jingzehuang.dagger2test.multibinding;

import dagger.Subcomponent;
import java.util.Map;
import java.util.Set;

@Subcomponent(modules = ChildModule.class)
interface ChildComponent {
  Set<String> strings();
  Map<String, String> stringMap();

  @Subcomponent.Builder
  interface Builder {

    Builder childModule(ChildModule childModule);

    ChildComponent build();
  }
}