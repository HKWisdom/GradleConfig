package com.wisdom.gradleconfigdemo.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.WindowManager;

import com.wisdom.gradleconfigdemo.MyApplication;

public class PixelUtil {
    public static int dp2px(float dp) {
        WindowManager wm = (WindowManager) MyApplication.sContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return (int) (dp * metrics.density);
    }

    public static float px2dp(int px) {
        WindowManager wm = (WindowManager) MyApplication.sContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return ((float) px / metrics.density);
    }

    public static Size getScreenSize() {
        WindowManager wm = (WindowManager) MyApplication.sContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return new Size(metrics.widthPixels, metrics.heightPixels);
    }
}
