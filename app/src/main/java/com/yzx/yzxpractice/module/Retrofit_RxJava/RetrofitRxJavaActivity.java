package com.yzx.yzxpractice.module.Retrofit_RxJava;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.TextView;

import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.base.BaseActivity;
import com.yzx.yzxpractice.utils.L;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;

/**
 * Created by Administrator on 2017/3/9.
 */

public class RetrofitRxJavaActivity extends BaseActivity {
    @BindView(R.id.tv_console)
    protected TextView tvConsole;

    @BindView(R.id.iv_console)
    protected ImageView ivConsole;

    @OnClick(R.id.btn_shoot)
    protected void shootSth() {
        final int drawableRes = R.drawable.ic_menu_camera;
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(drawableRes,null);
                subscriber.onNext(drawable);
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                ivConsole.setImageDrawable(drawable);
            }
        });
    }

    @Override
    protected void initView() {
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_retrofit;
    }
}
