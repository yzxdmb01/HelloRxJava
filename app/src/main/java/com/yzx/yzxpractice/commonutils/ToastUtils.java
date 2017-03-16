/**
 * 作者：yzx
 */
package com.yzx.yzxpractice.commonutils;

import android.widget.Toast;

import com.yzx.yzxpractice.base.BaseApplication;

/**
 * Description：用于显示Toast
 * Created by yzx on 2017/3/16.
 */

public class ToastUtils {
    private static Toast mToast;


    public static void show(String msg) {
        show(msg, Toast.LENGTH_SHORT);
    }

    public static void showLong(String msg) {
        show(msg, Toast.LENGTH_LONG);
    }

    public static void show(String msg, int durtation) {
        if (mToast == null) {
            synchronized (Toast.class) {
                mToast = Toast.makeText(BaseApplication.getApplication(),msg,Toast.LENGTH_SHORT);
            }
        }
        mToast.setText(msg);
        mToast.setDuration(durtation);
        mToast.show();
    }
}
