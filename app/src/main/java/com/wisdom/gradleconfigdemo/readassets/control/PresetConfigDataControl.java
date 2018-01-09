package com.wisdom.gradleconfigdemo.readassets.control;

import android.content.Context;
import android.text.TextUtils;

import com.wisdom.gradleconfigdemo.LogUtil;
import com.wisdom.gradleconfigdemo.readassets.DataManager;
import com.wisdom.gradleconfigdemo.readassets.entity.GlobalConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.entity.ServerCountConfigEntity;
import com.wisdom.gradleconfigdemo.readassets.utils.SharedPreferencesConfigUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hukun on 2018/1/8.
 */

public class PresetConfigDataControl {
    private static final int ERROR_INT = -1010153;
    private static final int DEFAULT_SERVER_ACCOUNT_TOTAL_MAX = 32;

    protected static void initLoadAllGolbalPresetData(Context context, GlobalConfigEntity configDefaultDataEntity){
        if(null != configDefaultDataEntity){
            String defaultLockPassword = configDefaultDataEntity.getDefaultLockPassword();

            LogUtil.d("----PresetConfigDataControl defaultLockPassword = " + defaultLockPassword);
            if(!TextUtils.isEmpty(defaultLockPassword) && defaultLockPassword.trim().length() == 4){
                SharedPreferencesConfigUtil.saveParentLockPassword(context, defaultLockPassword);
            }
            String screenScale = configDefaultDataEntity.getScreenScale();
            int iScreen = stringParseInt(screenScale);
            LogUtil.d("----PresetConfigDataControl iScreen = " + iScreen);
            if(iScreen != ERROR_INT){
                SharedPreferencesConfigUtil.saveScreenScaleType(context, iScreen);
            }

            String allowAddServer = configDefaultDataEntity.getAllowAddServer();
            boolean bAllowAddServer = stringParseBoolean(allowAddServer, true);
            LogUtil.d("----PresetConfigDataControl bAllowAddServer = " + bAllowAddServer);
            SharedPreferencesConfigUtil.saveAllowAddServerStatus(context, bAllowAddServer);

            String serverTotal = configDefaultDataEntity.getServerTotal();
            int iServerTotal = stringParseInt(serverTotal);
            LogUtil.d("----PresetConfigDataControl iServerTotal = " + iServerTotal);
            if(iServerTotal != ERROR_INT && iServerTotal > 0){
                iServerTotal = Math.min(iServerTotal, DEFAULT_SERVER_ACCOUNT_TOTAL_MAX);
                SharedPreferencesConfigUtil.saveServerAccountTotal(context, iServerTotal);
            }

            String showMac = configDefaultDataEntity.getShowMac();
            LogUtil.d("----PresetConfigDataControl showMac0 = " + showMac);
            if(stringIsMac(showMac)){
                showMac = showMac.toUpperCase();
                LogUtil.d("----PresetConfigDataControl showMac1 = " + showMac);
                SharedPreferencesConfigUtil.saveMacAddressShow(context, showMac);
            }

            String loginType = configDefaultDataEntity.getLoginType();
            int iLoginType = stringParseInt(loginType);
            LogUtil.d("----PresetConfigDataControl iLoginType = " + iLoginType);
            if (iLoginType != ERROR_INT) {
                SharedPreferencesConfigUtil.saveLoginType(context, iLoginType);
            }

            String okListMode = configDefaultDataEntity.getOkListMode();
            int iOkListMode = stringParseInt(okListMode);
            LogUtil.d("----PresetConfigDataControl iOkListMode = " + iOkListMode);
            if (iOkListMode != ERROR_INT) {
                SharedPreferencesConfigUtil.saveOkListMode(context,iOkListMode);
            }
        }
    }

    protected static void initLoadAllServerAccountPresetData(Context context, ServerCountConfigEntity configServerAccountEntity){
        List<ServerCountConfigEntity.ServerCountEntity> list = new ArrayList<>();
        if(null != configServerAccountEntity){
            List<ServerCountConfigEntity.ServerCountEntity> dataEntity = configServerAccountEntity.getEntityList();
            if(null != dataEntity && dataEntity.size() > 0){
                for (ServerCountConfigEntity.ServerCountEntity entity: dataEntity) {
                        //TODO:这里可以将读取的assets目录的文件写到数据库中
                    list.add(entity);
//                    DBLogin dbLogin = createDBLogin(entity);
//                    if(null != dbLogin){
//                        ControlLoginData.insertLoginData(dbLogin, null);
//                    }
                }
                DataManager.getInstance().addDataEntity(list);
            }else {
                LogUtil.i("DataManager : " + "list is null");
            }
        }
    }



    private static int getIsEmpty(String str){
        boolean empty = isEmpty(str);
        if(empty){
            return 0;
        }
        return 1;
    }

    private static boolean isEmpty(String str){
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim());
    }

    /**
     * string 转 int
     * @param str
     * @return  当返回值为 ERROR_INT = -1010153; 时， 表示本次转化失败。
     */
    private static int stringParseInt(String str){
        int i = ERROR_INT;
        if(!TextUtils.isEmpty(str)){
            try {
                i = Integer.parseInt(str.trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /**
     * string 转 int
     * @param str
     * @param idefault
     * @return  当返回值为 ERROR_INT = -1010153; 时， 表示本次转化失败,返回默认值
     */
    private static int stringParseInt(String str, int idefault){
        int i = ERROR_INT;
        if(!TextUtils.isEmpty(str)){
            try {
                i = Integer.parseInt(str.trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        if(i == ERROR_INT){
            i = idefault;
        }

        return i;
    }

    /**
     * string 转 boolean
     * @param str
     * @return 转化失败，返回 defaultBool
     */
    private static boolean stringParseBoolean(String str, boolean defaultBool){
        boolean bool = defaultBool;
        if(!TextUtils.isEmpty(str)){
            if(str.equalsIgnoreCase("true")){
                bool = true;
            }else if(str.equalsIgnoreCase("false")){
                bool = false;
            }
        }
        return bool;
    }

    private static boolean stringIsMac(String val) {
        String trueMacAddress = "([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}";
        if(!TextUtils.isEmpty(val)){
            return val.matches(trueMacAddress);
        }
        return false;
    }
}
