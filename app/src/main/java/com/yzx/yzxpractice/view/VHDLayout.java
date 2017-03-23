package com.yzx.yzxpractice.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Description：学习ViewDragHelper的使用
 * Created by yzx on 2017/3/23.
 */

public class VHDLayout extends LinearLayout {
    private ViewDragHelper mDragger;

    public VHDLayout(Context context) {
        this(context, null);
    }

    public VHDLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VHDLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragger = ViewDragHelper.create(this, 1f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return false;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mDragger.shouldInterceptTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragger.processTouchEvent(event);
        return true;
    }
}
