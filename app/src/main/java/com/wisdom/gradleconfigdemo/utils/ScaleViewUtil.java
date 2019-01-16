package com.wisdom.gradleconfigdemo.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by hukun on 2018/7/6.
 */

public class ScaleViewUtil {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void scaleView(View view, float scaleMax) {
        view.setFocusable(true);
        view.setClickable(true);
        float scaleValue = 12;
        if (view.hasFocus()) {
            view.animate().scaleX(scaleMax).scaleY(scaleMax).z(scaleValue).setDuration(200).start();
        } else {
            view.animate().scaleX(1).scaleY(1).z(1).setDuration(200).start();
        }


    }
}
