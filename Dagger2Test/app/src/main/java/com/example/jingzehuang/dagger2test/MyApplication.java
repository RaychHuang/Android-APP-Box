package com.example.jingzehuang.dagger2test;

import android.app.Application;

/**
 * Created by Raych on Oct.19, 18.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        AppComponentHolder.setAppComponent(appComponent);
    }
}
