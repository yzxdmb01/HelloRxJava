package com.yzx.yzxpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yzx.yzxpractice.commonutils.ToastUtils;

/**
 * Description:
 * Created by yzx on 2017/3/22.
 * <p>
 * 思路：
 */

public class PageView extends ViewGroup {
    private int DISPLAY_PAGE_NUMS = 3;  //显示的页数
    private int PAGE_COUNT;     //总页数

    private int cellWidth;
    private int cellHeight;


    public PageView(Context context) {
        super(context);
        init(context);
    }

    public PageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //先加入子view
        for (int i = 0; i < DISPLAY_PAGE_NUMS; i++) {
            TextView textView = new TextView(context);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(lp);
            textView.setTextSize(30);
            textView.setGravity(Gravity.CENTER);
            textView.setText(i + 1 + "");
            addView(textView);
        }
        Button btnPre = new Button(context);
        btnPre.setText("<");
        addView(btnPre, 0);
        Button btnNext = new Button(context);
        btnNext.setText(">");
        addView(btnNext, getChildCount());
        btnPre.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("上一页");
            }
        });
        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show("下一页");
            }
        });

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        calcChildWH();
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int cl = i * cellWidth;
            int ct = 0;
            int cr = (i + 1) * cellWidth;
            int cb = cellHeight;
            childView.layout(cl, ct, cr, cb);
        }

    }

    private void calcChildWH() {
        cellWidth = getWidth() / (DISPLAY_PAGE_NUMS + 2);
        cellHeight = getHeight();
    }

    //暂时先不用重写
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

}
