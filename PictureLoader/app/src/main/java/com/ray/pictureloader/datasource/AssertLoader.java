package com.ray.pictureloader.datasource;

import android.content.Context;

import com.ray.pictureloader.MyApplication;

import java.io.IOException;
import java.io.InputStream;

public class AssertLoader {

    private static final AssertLoader INSTANCE = new AssertLoader(MyApplication.getAppInstance());

    private static final String fileName = "";

    private Context context;

    public static AssertLoader getInstance() {
        return INSTANCE;
    }

    private AssertLoader(Context context) {
        this.context = context;
    }

    public InputStream getGsonInputStream() throws IOException {
        return context.getAssets().open(fileName);
    }
}
