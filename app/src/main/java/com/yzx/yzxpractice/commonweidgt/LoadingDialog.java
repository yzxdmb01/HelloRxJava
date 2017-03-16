/**
 * 作者：yzx
 */
package com.yzx.yzxpractice.commonweidgt;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzx.yzxpractice.R;

/**
 * Description：显示和隐藏progress
 * Created by yzx on 2017/3/16.
 */

public class LoadingDialog {
    private static Dialog mProgressDialog;


    /**
     * 显示ProgressDialog
     *
     * @param context
     * @return
     */
    public static Dialog showLoadingDialog(Context context) {
        return showLoadingDialog(context, null);
    }

    public static Dialog showLoadingDialog(Context context, String msg) {
        return showLoadingDialog(context, msg, false);
    }

    public static Dialog showLoadingDialog(Context context, String msg, boolean cancelable) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        TextView tvProgressBraText = (TextView) view.findViewById(R.id.tv_progress_bar_text);
        tvProgressBraText.setText(msg);
        tvProgressBraText.setVisibility(msg == null || msg.trim().isEmpty() ? View.GONE : View.VISIBLE);

        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setCancelable(cancelable);
        mProgressDialog.setCanceledOnTouchOutside(true);
        mProgressDialog.setContentView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mProgressDialog.show();

        return mProgressDialog;
    }

    /**
     * 关闭显示ProgressDialog
     */
    public static void hideLoadingDiaog() {
        if (mProgressDialog != null) mProgressDialog.cancel();
    }

}
