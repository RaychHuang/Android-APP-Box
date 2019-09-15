package com.ray.pictureloader;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication INSTANCE;

    public static MyApplication getAppInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
