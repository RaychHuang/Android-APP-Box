package com.example.jingzehuang.dagger2test.subcomponent;

import dagger.Component;
import java.util.Set;

@Component(modules = {SimpleModule.class})
public interface SimpleComponent {

  Set<String> provideSet();
}