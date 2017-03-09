package com.yzx.yzxpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.yzx.yzxpractice.base.BaseActivity;
import com.yzx.yzxpractice.module.CustomView.CustomViewActivity;
import com.yzx.yzxpractice.module.Retrofit_RxJava.RetrofitRxJavaActivity;
import com.yzx.yzxpractice.utils.L;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_main)
    LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_custom_view).setOnClickListener(this);//自定义view
        findViewById(R.id.btn_retrofit_java).setOnClickListener(this);//retrofit练习
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
            case R.id.btn_retrofit_java:
                startActivity(new Intent(this, RetrofitRxJavaActivity.class));
                break;
        }
    }
}
