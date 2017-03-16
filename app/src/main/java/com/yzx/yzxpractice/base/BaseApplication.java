/**
 * 作者：yzx
 */
package com.yzx.yzxpractice.base;

import android.app.Application;
import android.content.Context;

/**
 * Description：
 * Created by yzx on 2017/3/16.
 */

public class BaseApplication extends Application{
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Context getApplication(){
        return baseApplication;
    }
}
