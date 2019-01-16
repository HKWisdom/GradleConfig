package com.wisdom.gradleconfigdemo.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wisdom.gradleconfigdemo.MyApplication;

import static com.wisdom.gradleconfigdemo.database.DataContract.AUTHORITY;
import static com.wisdom.gradleconfigdemo.database.DataContract.CATEGORY_PATH;
import static com.wisdom.gradleconfigdemo.database.DataContract.CATEGORY_URI;
import static com.wisdom.gradleconfigdemo.database.DataContract.CHANNEL_PATH;
import static com.wisdom.gradleconfigdemo.database.DataContract.CHANNEL_URI;
import static com.wisdom.gradleconfigdemo.database.MyDatabaseHelper.DB_TABLE_CATEGORY;
import static com.wisdom.gradleconfigdemo.database.MyDatabaseHelper.DB_TABLE_CHANNEL;

/**
 * Created by hukun on 2018/1/5.
 */

public class ChannelProvider extends ContentProvider {

    private MyDatabaseHelper mDatabaseHelper;

    public static final int CHANNEL_CODE = 0;
    public static final int CATEGORY_CODE = 1;
    private SQLiteDatabase mDb;

    //添加匹配规则
    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, CHANNEL_PATH, CHANNEL_CODE);
        matcher.addURI(AUTHORITY, CATEGORY_PATH, CATEGORY_CODE);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDatabaseHelper = new MyDatabaseHelper(MyApplication.sContext);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
            mDb = mDatabaseHelper.getReadableDatabase();
        switch (buildUriMatcher().match(uri)) {
            case CHANNEL_CODE:
                return mDb.query(DB_TABLE_CHANNEL, projection, selection, selectionArgs, sortOrder, null, null);
            case CATEGORY_CODE:
                return mDb.query(DB_TABLE_CATEGORY, projection, selection, selectionArgs, sortOrder, null, null);
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        mDb = mDatabaseHelper.getWritableDatabase();
        switch (buildUriMatcher().match(uri)) {
            case CHANNEL_CODE:
                long rowId = mDb.insert(DB_TABLE_CHANNEL, null, values);
                Uri newUri = ContentUris.withAppendedId(CHANNEL_URI, rowId);
                getContext().getContentResolver().notifyChange(newUri, null);
                return newUri;
            case CATEGORY_CODE:
                long rowCategoryId = mDb.insert(DB_TABLE_CATEGORY, null, values);
                Uri newCategoryUri = ContentUris.withAppendedId(CATEGORY_URI, rowCategoryId);
                getContext().getContentResolver().notifyChange(newCategoryUri, null);
                return newCategoryUri;
            default:
                throw new android.database.SQLException("Unknown uri: " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
