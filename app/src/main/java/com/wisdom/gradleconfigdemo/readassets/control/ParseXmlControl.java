package com.wisdom.gradleconfigdemo.readassets.control;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.wisdom.gradleconfigdemo.readassets.entity.GlobalConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.entity.ServerCountConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.utils.ParseConfigXmlUtils;

import static com.wisdom.gradleconfigdemo.readassets.utils.UtilsConfigConstant.CONFIG_FILE_DEFAULT_DATA_NAME_ASSETS;
import static com.wisdom.gradleconfigdemo.readassets.utils.UtilsConfigConstant.CONFIG_FILE_SERVER_ACCOUNT_NAME_ASSETS;

/**
 * Created by hukun on 2018/1/8.
 */

public class ParseXmlControl {
    private static final String GLOBAL_ROOT_TAG = "PresetDefaultData";
    private static final String SERVER_ACCOUNT_ROOT_TAG = "PresetAccount";
    private static final String SERVER_LIST_ROOT_TAG = "ServerList";
    private static final String SECOND_TAG = "data";
    private static final String SECOND_LIST_TAG = "mEntityList";


    public static GlobalConfigEntity parseXmlPresetDefaultData(Context context) {
        GlobalConfigEntity globalConfigEntity = ParseConfigXmlUtils.parseXml(GLOBAL_ROOT_TAG, GlobalConfigEntity.class, ParseConfigXmlUtils.getAssetsImputStream(context,CONFIG_FILE_DEFAULT_DATA_NAME_ASSETS));
        return globalConfigEntity;
    }

    public static ServerCountConfigEntity parseXmlPresetServerAccount(Context context) {
        ServerCountConfigEntity serverCountConfigEntity = ParseConfigXmlUtils.parseXml(SECOND_TAG, ServerCountConfigEntity.ServerCountEntity.class, SERVER_ACCOUNT_ROOT_TAG, ServerCountConfigEntity.class, SECOND_LIST_TAG, ParseConfigXmlUtils.getAssetsImputStream(context, CONFIG_FILE_SERVER_ACCOUNT_NAME_ASSETS));
        return serverCountConfigEntity;
    }

    public static Drawable getConfigMainMenuLogo(Context context){

        return ParseConfigXmlUtils.getConfigMainMenuLogo(context);
    }
}
