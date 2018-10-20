package com.example.jingzehuang.dagger2test;

import dagger.Component;

@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

  void inject(MainActivity activity);

}
