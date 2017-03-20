package com.yzx.yzxpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzx.yzxpractice.base.BaseActivity;
import com.yzx.yzxpractice.base.RxBus;
import com.yzx.yzxpractice.module.CustomView.CustomViewActivity;
import com.yzx.yzxpractice.module.Retrofit_RxJava.RetrofitRxJavaActivity;
import com.yzx.yzxpractice.module.Retrofit_RxJava.model.TestEvent;

import butterknife.BindView;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.tv_console)
    TextView tvConsole;
    Subscription subscription;//订阅事件


    @Override
    protected void initView() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        //测试RxBus接收
        subscription = RxBus.getInstance().toObservable(TestEvent.class)
                .subscribe(new Action1<TestEvent>() {
                    @Override
                    public void call(TestEvent testEvent) {
                        tvConsole.setText(testEvent.getTitle() + ",\n" + testEvent.getContent());
                    }
                });

        findViewById(R.id.btn_custom_view).setOnClickListener(this);//自定义View/第三方View
        findViewById(R.id.btn_retrofit_java).setOnClickListener(this);//retrofit练习
        findViewById(R.id.btn_test).setOnClickListener(this);   //测试按钮
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
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
            case R.id.btn_test:
                testSth();
                break;
        }
    }

    private void testSth() {
        String a = null;
        String b = "";
        if (i++ % 2 == 0) {
            tvConsole.setText("a isEmpty:" + TextUtils.isEmpty(a));
        } else {
            tvConsole.setText("b isEmpty:" + TextUtils.isEmpty(b));
        }
    }

    int i = 0;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != subscription && !subscription.isUnsubscribed()) subscription.unsubscribe();
    }
}
