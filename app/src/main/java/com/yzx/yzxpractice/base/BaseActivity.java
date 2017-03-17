package com.yzx.yzxpractice.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.yzx.yzxpractice.R;
import com.yzx.yzxpractice.commonweidgt.LoadingDialog;
import com.yzx.yzxpractice.commonutils.L;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity {

//    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    protected Context mContext;
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doBeforeSetContentView();
        setContentView(getLayoutId());

        unBinder = ButterKnife.bind(this);
        mContext = this;

        setToolBar();
        this.initPresenter();
        this.initView();

    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            L.i("设置ToolBar");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } else {
            L.i("没设置ToolBar");
        }
    }

    /**
     * 获取布局文件ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * MVP结构模式初始化Presenter
     */
    protected abstract void initPresenter();

    //设置layout前配置，现在先不搞这东西
    private void doBeforeSetContentView() {
    }

    /**
     * 显示加载进度条
     */
    protected void showProgressDialog() {
        LoadingDialog.showLoadingDialog(this);
    }

    /**
     * 进度条
     *
     * @param msg 自定义文字
     */
    protected void showProgressDialog(String msg) {
        LoadingDialog.showLoadingDialog(this, msg);
    }

    protected void hideProgressDialog() {
        LoadingDialog.hideLoadingDiaog();
    }

    /**
     * 设置返回按钮行为
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) unBinder.unbind();
    }
}
