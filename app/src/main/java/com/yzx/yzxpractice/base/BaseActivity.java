package com.yzx.yzxpractice.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.utils.L;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private int contentView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.i("onCreate");
        setContentView(getContentView());
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);


    }

    protected abstract int getContentView();
}
