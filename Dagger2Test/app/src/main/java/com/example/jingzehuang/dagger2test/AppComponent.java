package com.example.jingzehuang.dagger2test;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {

    SharedPreferences sharedPreferences();

    MyApplication myApplication();
}
