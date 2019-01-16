package com.wisdom.gradleconfigdemo.readassets.utils;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.wisdom.gradleconfigdemo.utils.LogUtil;
import com.wisdom.gradleconfigdemo.readassets.entity.ServerConfigEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.wisdom.gradleconfigdemo.readassets.utils.UtilsConfigConstant.CONFIG_FILE_SERVERLIST_NAME_ASSETS_NEW;

/**
 * Created by hukun on 2018/1/5.
 */

public class UtilsServerConfig {
    private static final String TAG = "UtilsServerConfig";

    /**
     * 解析在assets中的server.config文件
     * @param context
     * @return
     */
    public static ServerConfigEntity parseServerData(Context context) {
        String s = "";
        ServerConfigEntity serverConfigEntity = null;
        try {
            InputStream inputStream = context.getAssets().open(CONFIG_FILE_SERVERLIST_NAME_ASSETS_NEW);
            if (inputStream == null) {
                return null;
            }
            int len = 0;
            byte[] bytes = new byte[512];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = inputStream.read(bytes)) != -1) {
                baos.write(bytes,0,len);
            }
            s = new String(baos.toByteArray());
             serverConfigEntity = JSON.parseObject(s, ServerConfigEntity.class);
             if (serverConfigEntity == null) {
                 LogUtil.i(TAG,"serverConfigEntity is null");
             }

        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.i(TAG,e.getMessage());
        }
        return serverConfigEntity;
    }


    /**
     * 获取所有的server类型数据
     * @param context
     * @return
     */
    public static List<ServerConfigEntity.ServerEntity> parseServerConfigList(Context context) {
        ServerConfigEntity serverConfigEntity = parseServerData(context);
        if (serverConfigEntity  != null) {
            List<ServerConfigEntity.ServerEntity> serverEntityList = serverConfigEntity.getServerEntityList();
            Collections.sort(serverEntityList, new Comparator<ServerConfigEntity.ServerEntity>() {
                @Override
                public int compare(ServerConfigEntity.ServerEntity o1, ServerConfigEntity.ServerEntity o2) {
                    return Integer.valueOf(o1.getPosition()).compareTo(Integer.valueOf(o2.getPosition()));
                }
            });
            return serverEntityList;
        }else {
            return new ArrayList<ServerConfigEntity.ServerEntity>();
        }
    }
}
