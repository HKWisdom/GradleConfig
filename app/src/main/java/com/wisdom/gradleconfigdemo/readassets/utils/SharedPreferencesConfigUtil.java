/**
 * SharedPreferencesUtil.java[V 1.0.0]
 * classes : com.sen5.sen5iptv.utils.SharedPreferencesUtil
 * Xlee Create at 2016-2-16 上午10:51:15
 */
package com.wisdom.gradleconfigdemo.readassets.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesConfigUtil {
    private static final String CONFIG_FIRST_LOAD_CONFIG = "config_first_load_config";
    private static final int DEFAULT_LOGIN_TYPE = -1;
    public static final int PLAY_TYPE_LIVE = 0;
    public static final int PLAY_TYPE_RADIO = 1;
    public static final int OK_LIST_MODE = 1;
    private static SharedPreferences sSharedPreferences;
    private static final String SHARED_PREFERENCES_NAME = "config_defaultfile";
    private static final String SHARED_SCREEN_SCALE_TYPE = "config_screen_scale_type";
    private static final String SHARED_SCREEN_DECODE_TYPE = "config_screen_decode_type";
    private static final String CONFIG_PARENT_LOCK_PASSWORD = "config_parent_lock_password";
    private static final String CONFIG_FIRST_LOGIN = "config_first_login";
    private static final String CONFIG_LOGIN_TYPE = "config_login_type";
    private static final String CONFIG_PLAY_TYPE = "config_play_type";
    private static final String CONFIG_OK_LIST_MODE = "config_ok_list_mode";

    private static final String CONFIG_LOAD_CONFIG_DATA = "load_config_data";

    public static final String DEFAULT_PARENT_LOCK_PASSWORD = "0000";
    private static final int DEFAULT_SERVER_ACCOUNT_TOTAL = 16;
    private static final int DEFAULT_SERVER_TYPE = 3;

    private static final String CONFIG_ALLOW_ADD_SERVER = "config_allow_add_server";
    private static final String CONFIG_SERVER_ACCOUNT_TOTAL = "config_server_total";
    private static final String CONFIG_SERVER_TYPE = "config_server_type";
    private static final String CONFIG_MAC_SHOW = "config_mac_show";


    public static void saveLoadConfigStatus(Context context, boolean status) {
        saveBoolean(context, CONFIG_LOAD_CONFIG_DATA, status);
    }

    public static boolean getLoadConfigStatus(Context context) {
        return getBoolean(context, CONFIG_LOAD_CONFIG_DATA, false);
    }

    public static void saveAllowAddServerStatus(Context context, boolean status) {
        saveBoolean(context, CONFIG_ALLOW_ADD_SERVER, status);
    }

    public static boolean getAllowAddServerStatus(Context context) {
        return getBoolean(context, CONFIG_ALLOW_ADD_SERVER, true);
    }

    public static void saveScreenScaleType(Context context, int value) {
        saveInt(context, SHARED_SCREEN_SCALE_TYPE, value);
    }

//    public static int getScreenScaleType(Context context) {
//        return getInt(context, SHARED_SCREEN_SCALE_TYPE, DisplayUtil.SCREEN_FULL);
//    }

    public static void saveDecodeType(Context context, int value) {
        saveInt(context, SHARED_SCREEN_DECODE_TYPE, value);
    }

    public static int getServerAccountTotal(Context context) {
        return getInt(context, CONFIG_SERVER_ACCOUNT_TOTAL, DEFAULT_SERVER_ACCOUNT_TOTAL);
    }

    public static void saveServerAccountTotal(Context context, int value) {
        saveInt(context, CONFIG_SERVER_ACCOUNT_TOTAL, value);
    }


    public static int getDefaultServerType(Context context) {
        return getInt(context, CONFIG_SERVER_TYPE, DEFAULT_SERVER_TYPE);
    }

    public static void saveDefaultServerType(Context context, int value) {
        saveInt(context, CONFIG_SERVER_TYPE, value);
    }

//    public static int getDecodeType(Context context) {
//        return getInt(context, SHARED_SCREEN_DECODE_TYPE, EventDecodeType.DECODE_DEFAULT);
//    }

    public static String getParentLockPassword(Context context, String defString) {
        return getString(context, CONFIG_PARENT_LOCK_PASSWORD, defString);
    }

    public static String getParentLockPassword(Context context) {

        return getString(context, CONFIG_PARENT_LOCK_PASSWORD, DEFAULT_PARENT_LOCK_PASSWORD);
    }

    public static void saveParentLockPassword(Context context, String value) {
        saveString(context, CONFIG_PARENT_LOCK_PASSWORD, value);
    }


    public static String getMacAddressShow(Context context, String mac) {

        return getString(context, CONFIG_MAC_SHOW, mac);
    }

    public static void saveMacAddressShow(Context context, String value) {
        saveString(context, CONFIG_MAC_SHOW, value);
    }

    public static void saveFirstLogin(Context context, boolean status) {
        saveBoolean(context, CONFIG_FIRST_LOGIN, status);
    }

    public static boolean getFirstLogin(Context context, boolean defBoolean) {
        return getBoolean(context, CONFIG_FIRST_LOGIN, defBoolean);
    }

    public static void saveFirstLoadConfig(Context context, boolean status) {
        saveBoolean(context, CONFIG_FIRST_LOAD_CONFIG, status);
    }

    public static boolean getFirstLoadConfig(Context context, boolean defBoolean) {
        return getBoolean(context, CONFIG_FIRST_LOAD_CONFIG, defBoolean);
    }

    public static void saveLoginType(Context context, int value) {
        saveInt(context, CONFIG_LOGIN_TYPE, value);
    }

    public static int getLoginType(Context context) {
        return getInt(context, CONFIG_LOGIN_TYPE, DEFAULT_LOGIN_TYPE);
    }

    public static void savePlayType(Context context, int value) {
        saveInt(context, CONFIG_PLAY_TYPE, value);
    }

    public static int getPlayType(Context context) {
        return getInt(context, CONFIG_PLAY_TYPE, PLAY_TYPE_LIVE);
    }

    public static void saveOkListMode(Context context, int value) {
        saveInt(context, CONFIG_OK_LIST_MODE, value);
    }

    public static int getOkListMode(Context context) {
        return getInt(context, CONFIG_OK_LIST_MODE, OK_LIST_MODE);
    }



    /**
     * 存储sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param value
     */
    private static void saveString(Context context, String key, String value) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        sSharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * 读取sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param defValue
     */
    private static String getString(Context context, String key, String defValue) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sSharedPreferences.getString(key, defValue);
    }

    /**
     * 存储sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param value
     */
    private static void saveInt(Context context, String key, int value) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        sSharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * 读取sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param defValue
     */
    private static int getInt(Context context, String key, int defValue) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sSharedPreferences.getInt(key, defValue);
    }

    /**
     * 存储sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param value
     */
    private static void saveBoolean(Context context, String key, boolean value) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        sSharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * 读取sp，上下文，key，value
     *
     * @param context
     * @param key
     * @param defValue
     */
    private static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sSharedPreferences.getBoolean(key, defValue);
    }

    public static boolean clearAll(Context context) {
        if (sSharedPreferences == null) {
            sSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sSharedPreferences.edit().clear().commit();
    }

}
