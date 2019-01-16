package com.wisdom.gradleconfigdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisdom.gradleconfigdemo.MyApplication;

import java.io.IOException;
import java.util.WeakHashMap;

public class TextTypefaceUtil {
    private static WeakHashMap<String, Typeface> sTypefaceRef = new WeakHashMap<>();

    private static final String TYPE_FACE_ROBOTO_LIGHT = "Roboto-Light.ttf";

    public static void inject(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        inject(decorView);
    }

    public static void inject(View view) {
        try {
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int childCount = vg.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = vg.getChildAt(i);
                    if (child != null) {
                        inject(child);
                    }
                }
            } else if (view instanceof TextView) {
                Typeface typeface = getTypeface(MyApplication.sContext, TYPE_FACE_ROBOTO_LIGHT);
                if (typeface != null) {
                    TextView tv = (TextView) view;
                    tv.setTypeface(typeface);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Typeface getTypeface(Context context, String name) throws IOException {
        Typeface typeface = null;
        if ((typeface = sTypefaceRef.get(name)) == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), name);
            if (typeface != null) {
                sTypefaceRef.put(name, typeface);
            }
        }
        return typeface;
    }

    public static Typeface getDefaultTypeface() {
        try {
            return getTypeface(MyApplication.sContext, TYPE_FACE_ROBOTO_LIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
