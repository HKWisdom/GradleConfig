package com.wisdom.gradleconfigdemo;

import com.wisdom.gradleconfigdemo.base.BaseActivity;
import com.wisdom.gradleconfigdemo.mvp.model.MovieModel;
import com.wisdom.gradleconfigdemo.mvp.presenter.MoviePresenter;
import com.wisdom.gradleconfigdemo.mvp.view.IView;

public class MainActivity extends BaseActivity<MoviePresenter,MovieModel> implements IView {
    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(mModel,this);
    }


    @Override
    public void load() {

    }
}
