package com.yzx.yzxpractice.module.CustomView;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.base.BaseActivity;

/**
 * Created by Administrator on 2017/3/8.
 */

public class CustomViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_custom_view;
    }
}

