package com.wisdom.gradleconfigdemo.readassets.control;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.wisdom.gradleconfigdemo.readassets.entity.GlobalConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.entity.ServerCountConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.utils.SharedPreferencesConfigUtil;

/**
 * Created by hukun on 2018/1/8.
 */

public class LoadConfigData {

    public static void load(Context context){
//        if(SharedPreferencesConfigUtil.getLoadConfigStatus(context)){
//            LogUtil.d("----------already load usb data");
//            return;
//        }

        GlobalConfigEntity configDefaultDataEntity = ParseXmlControl.parseXmlPresetDefaultData(context);
        PresetConfigDataControl.initLoadAllGolbalPresetData(context, configDefaultDataEntity);


        ServerCountConfigEntity configServerAccountEntity = ParseXmlControl.parseXmlPresetServerAccount(context);
        PresetConfigDataControl.initLoadAllServerAccountPresetData(context, configServerAccountEntity);

//        if(configDefaultDataEntity != null || null != configServerAccountEntity){
//            setSaveLoadConfigStatus(context);
//        }
    }


    public static void setSaveLoadConfigStatus(Context context){
        SharedPreferencesConfigUtil.saveLoadConfigStatus(context, true);
    }

    public static Drawable getConfigMainMenuLogo(Context context){

        return ParseXmlControl.getConfigMainMenuLogo(context);
    }
}
