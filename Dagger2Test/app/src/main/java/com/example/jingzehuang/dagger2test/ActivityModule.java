package com.example.jingzehuang.dagger2test;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

  private MainActivity activity;

  public  ActivityModule(MainActivity activity) {
    this.activity = activity;
  }

  @Provides
  Person providePerson() {
    return new Person();
  }

}
