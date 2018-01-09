package com.wisdom.gradleconfigdemo.readassets.utils;


import com.wisdom.gradleconfigdemo.BuildConfig;

import java.io.File;

public class UtilsConfigConstant {

	public static String CONFIG_BOX_SAVEDATA_PATH = "data/iptv/config_nestalker";

	public static String CONFIG_BOX_SYS_SAVEDATA_PATH = "system/etc/config_nestalker/";

	public static String CONFIG_USB_PATH = "nestalkercfg";

	public static String CONFIG_FILE_SERVERLIST_NAME = "serverlist" + ".config";
	public static String CONFIG_FILE_SERVERLIST_NAME_NEW = "server" + ".config";
	public static String CONFIG_FILE_SERVER_ACCOUNT_NAME = "serveraccount" + ".config";
	public static String CONFIG_FILE_DEFAULT_DATA_NAME = "global" + ".config";
	public static String CONFIG_FILE_DEFAULT_LOGO_NAME = "menu_logo" + ".png";
	public static String CONFIG_FILE_DEFAULT_CUSTOM_LOGIN_LOGO_NAME = "custom_login_logo" + ".png";
	public static String CONFIG_FILE_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_NAME = "main_login_logo" + ".png";//主activity的背景图片定制

	public static String CONFIG_FILE_SERVERLIST_NAME_ASSETS = "serverlist" + BuildConfig.CUSTOMERNAME + ".config";
	public static String CONFIG_FILE_SERVERLIST_NAME_ASSETS_NEW = "server" + BuildConfig.CUSTOMERNAME + ".config";
	public static String CONFIG_FILE_SERVER_ACCOUNT_NAME_ASSETS = "serveraccount" + BuildConfig.CUSTOMERNAME + ".config";
	public static String CONFIG_FILE_DEFAULT_DATA_NAME_ASSETS = "global" + BuildConfig.CUSTOMERNAME + ".config";
	public static String CONFIG_FILE_DEFAULT_LOGO_NAME_ASSETS = "menu_logo" + BuildConfig.CUSTOMERNAME + ".png";
	public static String CONFIG_FILE_DEFAULT_CUSTOM_LOGIN_LOGO_NAME_ASSETS = "custom_login_logo" + BuildConfig.CUSTOMERNAME + ".png";
	public static String CONFIG_FILE_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_NAME_ASSETS = "main_login_logo" + BuildConfig.CUSTOMERNAME + ".png";

	public static String CONFIG_USB_SERVER_LIST_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME;
	public static String CONFIG_USB_SERVER_LIST_FILE_PATH_NEW = CONFIG_USB_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME_NEW;
	public static String CONFIG_USB_SERVER_ACCOUNT_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_SERVER_ACCOUNT_NAME;
	public static String CONFIG_USB_DEFAULT_DATA_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_DEFAULT_DATA_NAME;
	public static String CONFIG_USB_DEFAULT_LOGO_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_DEFAULT_LOGO_NAME;
	public static String CONFIG_USB_DEFAULT_CUSTOM_LOGIN_LOGO_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_LOGIN_LOGO_NAME;
	public static String CONFIG_USB_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_FILE_PATH = CONFIG_USB_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_NAME;

	public static String CONFIG_BOX_SERVER_LIST_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME;
	public static String CONFIG_BOX_SERVER_LIST_FILE_PATH_NEW = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME_NEW;
	public static String CONFIG_BOX_SERVER_ACCOUNT_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVER_ACCOUNT_NAME;
	public static String CONFIG_BOX_DEFAULT_DATA_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_DATA_NAME;
	public static String CONFIG_BOX_DEFAULT_LOGO_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_LOGO_NAME;
	public static String CONFIG_BOX_DEFAULT_CUSTOM_LOGIN_LOGO_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_LOGIN_LOGO_NAME;
	public static String CONFIG_BOX_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_FILE_PATH = CONFIG_BOX_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_NAME;

	public static String CONFIG_BOX_SYS_SERVER_LIST_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME;
	public static String CONFIG_BOX_SYS_SERVER_LIST_FILE_PATH_NEW = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVERLIST_NAME_NEW;
	public static String CONFIG_BOX_SYS_SERVER_ACCOUNT_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_SERVER_ACCOUNT_NAME;
	public static String CONFIG_BOX_SYS_DEFAULT_DATA_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_DATA_NAME;
	public static String CONFIG_BOX_SYS_DEFAULT_LOGO_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_LOGO_NAME;
	public static String CONFIG_BOX_SYS_DEFAULT_CUSTOM_LOGIN_LOGO_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_LOGIN_LOGO_NAME;
	public static String CONFIG_BOX_SYS_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_FILE_PATH = CONFIG_BOX_SYS_SAVEDATA_PATH + File.separator + CONFIG_FILE_DEFAULT_CUSTOM_MAIN_LOGIN_LOGO_NAME;

}
