package com.yzx.yzxpractice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yzx.yzxpractice.commonutils.CalcUtils;

/**
 * Description：
 * Created by yzx on 2017/3/23.
 */

public class PageScrollView extends HorizontalScrollView {
    private int displayItemCount = 3;
    private LinearLayout linearLayout;
    private Context context;

    private int itemWidth;

    public PageScrollView(Context context) {
        super(context);
        init(context);
    }

    public PageScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PageScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        this.setHorizontalScrollBarEnabled(false);
        this.addView(linearLayout);

        initData();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = displayItemCount * itemWidth;
        int myWidthSpec = MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY);
        super.onMeasure(myWidthSpec, heightMeasureSpec);
//        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            linearLayout.addView(createTextView(i + 1 + ""));
        }
    }


    private TextView createTextView(String item) {
        TextView tv = new TextView(context);
        tv.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv.setSingleLine(true);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        tv.setText(item);
        tv.setGravity(Gravity.CENTER);
        int padding = CalcUtils.dip2px(15);
        tv.setPadding(padding, padding, padding, padding);
        if (itemWidth == 0) itemWidth = getViewMeasuredWidth(tv);
        return tv;
    }

    private int getViewMeasuredWidth(View view) {
        int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int width = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        view.measure(width, height);
        return view.getMeasuredWidth();
    }
}
