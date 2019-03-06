package com.example.jingzehuang.dagger2test.multibinding;

import dagger.Component;
import java.util.Map;
import java.util.Set;

@Component(modules = ParentModule.class)
interface ParentComponent {
  Set<String> strings();
  Map<String, String> stringMap();
  ChildComponent.Builder provideChildComponentBuilder();
}
