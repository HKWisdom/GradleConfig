package com.wisdom.gradleconfigdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by hukun on 2018/1/18.
 */

public class MyApplication extends Application {

    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
