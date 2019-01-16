package com.wisdom.gradleconfigdemo.base;

/**
 * Created by hukun on 2018/1/18.
 */

import com.wisdom.gradleconfigdemo.mvp.RxManager;

/**
 * Presenter 的基类，持有model和view的引用
 */
public class BasePresenter<M,V> {
   public M mModel;
   public V mView;
   public RxManager mRxManager = new RxManager();

   public void setVM(M model, V view) {
       this.mModel = model;
       this.mView = view;
       this.start();
   }

    public void start() {

    }

    public void destroy() {
       mRxManager.clear();
    }
}
