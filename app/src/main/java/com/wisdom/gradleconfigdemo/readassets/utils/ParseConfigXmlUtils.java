package com.wisdom.gradleconfigdemo.readassets.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.wisdom.gradleconfigdemo.readassets.utils.UtilsConfigConstant.CONFIG_FILE_DEFAULT_LOGO_NAME_ASSETS;

/**
 * Created by hukun on 2018/1/8.
 */

public class ParseConfigXmlUtils {

    /**
     * 获取assets下的图片
     * @param context
     * @return
     */
    public static Drawable getConfigMainMenuLogo(Context context) {
        Drawable menu_logo = Drawable.createFromStream(getAssetsImputStream(context, CONFIG_FILE_DEFAULT_LOGO_NAME_ASSETS), "menu_logo");
        if (menu_logo != null) {
            return menu_logo;
        }
        return null;
    }

    public static<T> T parseXml(String tag, Class<T> clas, String filePath){
        if(!TextUtils.isEmpty(filePath)){
            File file = new File(filePath);
            if(null != file && file.exists() && file.isFile()){
                XStream xs = new XStream(new DomDriver());
                xs.alias(tag, clas);
                T t = (T)xs.fromXML(file);
                return t;
            }
        }
        return null;
    }

    public static<T> T parseXml(String tag, Class<T> clas, InputStream is){
        if(null != is){
            XStream xs = new XStream(new DomDriver());
            xs.alias(tag, clas);
            T t = (T)xs.fromXML(is);
            return t;
        }
        return null;
    }

    public static<T, K> K parseXml(String tagT, Class<T> clasT, String pTagK, Class<K> pClasK, String listName, String filePath){
        if(!TextUtils.isEmpty(filePath)){
            File file = new File(filePath);
            if(null != file && file.exists() && file.isFile()){
                XStream xs = new XStream(new DomDriver());
                xs.alias(pTagK, pClasK);
                xs.alias(tagT, clasT);
                xs.addImplicitCollection(pClasK, listName);
                K k = (K)xs.fromXML(file);
                return k;
            }
        }
        return null;
    }

    public static<T, K> K parseXml(String tagT, Class<T> clasT, String pTagK, Class<K> pClasK, String listName, InputStream is){
        if(null != is){
            XStream xs = new XStream(new DomDriver());
            xs.alias(pTagK, pClasK);
            xs.alias(tagT, clasT);
            xs.addImplicitCollection(pClasK, listName);
            K k = (K)xs.fromXML(is);
            return k;
        }
        return null;
    }



    public static InputStream getAssetsImputStream(Context context, String fileName) {
        InputStream open = null;
        try {
            open = context.getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return open;
    }
}
