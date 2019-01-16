package com.wisdom.gradleconfigdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wisdom.gradleconfigdemo.mvp.RxManager;
import com.wisdom.gradleconfigdemo.utils.TUtil;

/**
 * Created by hukun on 2018/1/18.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    protected P mPresenter;
    protected M mModel;
    protected Context mContext;
    protected RxManager mRxManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        mRxManager = new RxManager();
        setContentView(getResId());
        mContext = this;
        mPresenter = TUtil.getT(this,0);
        mModel = TUtil.getT(this,1);
        this.initPresenter();
        this.initView();
    }

    protected abstract void initView();

    protected abstract void initPresenter();

    protected abstract int getResId();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
