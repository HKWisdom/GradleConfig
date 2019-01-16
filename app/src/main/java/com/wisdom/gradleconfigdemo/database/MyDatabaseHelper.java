package com.wisdom.gradleconfigdemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hukun on 2018/7/18.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "channel.db";//数据库名
    public static final String DB_TABLE_CHANNEL = "db_live_channel_table";//表名
    public static final String DB_TABLE_CATEGORY = "db_category_table";//表名
    public MyDatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DB_TABLE_CHANNEL + "(" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: db_id
                "\"channel_string_id\" TEXT," + // 1: channel_string_id
                "\"title\" TEXT," + // 2: title
                "\"url\" TEXT);"); // 3: url

        db.execSQL("CREATE TABLE " + DB_TABLE_CATEGORY + " (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: db_id
                "\"db_login_id\" INTEGER," + // 1: db_login_id
                "\"channel_type\" INTEGER  ," + // 2: channel_type
                "\"title\" TEXT," + // 3: title
                "\"id\" TEXT);"); // 4: id
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_CHANNEL);
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_CATEGORY);
        onCreate(db);
    }
}
