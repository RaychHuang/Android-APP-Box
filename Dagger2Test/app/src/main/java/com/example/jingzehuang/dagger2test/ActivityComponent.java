package com.example.jingzehuang.dagger2test;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity activity);

}
