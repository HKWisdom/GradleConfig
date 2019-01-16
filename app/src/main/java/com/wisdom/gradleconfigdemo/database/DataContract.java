package com.wisdom.gradleconfigdemo.database;

import android.net.Uri;

/**
 * Created by hukun on 2018/7/13.
 */

public class DataContract {
    public static final String AUTHORITY = "com.wisdom.test.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String CHANNEL_PATH = "channel_path";
    public static final String CATEGORY_PATH = "category_path";
    public static final Uri CHANNEL_URI = CONTENT_URI.buildUpon().appendPath(CHANNEL_PATH).build();
    public static final Uri CATEGORY_URI = CONTENT_URI.buildUpon().appendPath(CATEGORY_PATH).build();
}
