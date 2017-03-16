package com.yzx.yzxpractice.commonutils;

import android.util.Log;

import com.yzx.yzxpractice.base.AppConfig;

/**
 * 用于打印log
 * Created by Administrator on 2017/3/7.
 */

public class L {

    public static void i(Object o) {
        if (AppConfig.isDebug) {
            StackTraceElement[] temp = Thread.currentThread().getStackTrace();
            StackTraceElement a = temp[3];
            Log.i("yzx-" + a.getFileName().split("\\.")[0] + "." + a.getMethodName() + ",line:" + a.getLineNumber(), "" + o);
        }
    }
}
