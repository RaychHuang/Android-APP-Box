package com.example.jingzehuang.dagger2test;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raych on Oct.19, 18.
 */

@Module
public class AppModule {

    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    SharedPreferences provideSharedPreferences(){
        return application.getSharedPreferences("spfile", Context.MODE_PRIVATE);
    }

    @Provides
    MyApplication provideApplication(){
        return application;
    }
}
