package com.wisdom.gradleconfigdemo.readassets;

import com.wisdom.gradleconfigdemo.utils.LogUtil;
import com.wisdom.gradleconfigdemo.readassets.entity.ServerCountConfigEntity;

import java.util.List;

/**
 * Created by hukun on 2018/1/8.
 */

public class DataManager {
    private static final String TAG = "DataManager";
    private List<ServerCountConfigEntity.ServerCountEntity> mList;

    private DataManager() {

    }

    private static class Instance {
        private static DataManager mDataManager = new DataManager();
    }

    public static DataManager getInstance() {
        return Instance.mDataManager;
    }

    public void addDataEntity(List<ServerCountConfigEntity.ServerCountEntity> list) {
        this.mList = list;
        LogUtil.i("sssssssssssssssss","====" + list.size());
    }

    public List<ServerCountConfigEntity.ServerCountEntity> getList() {
        return mList;
    }
}
