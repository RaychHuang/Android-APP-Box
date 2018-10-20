package com.example.jingzehuang.dagger2test;

/**
 * Created by Raych on Oct.19, 18.
 */

public class AppComponentHolder {

    private static AppComponent myAppComponent;

    public static void setAppComponent(AppComponent component) {
        myAppComponent = component;
    }

    public static AppComponent getAppComponent() {
        return myAppComponent;
    }
}
