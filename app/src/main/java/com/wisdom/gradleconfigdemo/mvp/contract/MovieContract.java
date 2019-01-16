package com.wisdom.gradleconfigdemo.mvp.contract;

import com.wisdom.gradleconfigdemo.base.BaseModel;
import com.wisdom.gradleconfigdemo.mvp.view.IView;

/**
 * Created by hukun on 2018/1/18.
 */

public class MovieContract {

    interface Model extends BaseModel {
        void getMovieData(int start, int count);
    }

    interface View extends IView {
        void startProgress();
        void stopProgress();
        void loadErro();
    }
}
