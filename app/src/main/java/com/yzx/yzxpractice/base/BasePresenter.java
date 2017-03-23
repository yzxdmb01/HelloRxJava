package com.yzx.yzxpractice.base;

import android.content.Context;

/**
 * Description：
 * Created by yzx on 2017/3/22.
 */

public class BasePresenter<T, E> {
    public Context mContext;
    public E mModel;
    public T mView;

    /**
     * @param v
     * @param m
     */
    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart(){}
    public void onDestory(){}
}
