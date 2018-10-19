package com.example.jingzehuang.dagger2test;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

//  private MainActivity activity;
//
//  public  MainActivityModule(MainActivity activity) {
//    this.activity = activity;
//  }

  @Provides
  Person providePerson() {
    return new Person();
  }

}
