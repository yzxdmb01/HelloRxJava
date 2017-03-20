package com.yzx.yzxpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description：
 * Created by yzx on 2017/3/20.
 */

public class PageIndicator extends View {
    private int CURRENT_PAGE = 1;   //当前页码
    private int DISPLAY_PAGE_NUMBERS = 3;//总共显示的页码数
    private int PAGE_COUNT = 0; //总页数
    private int CELL_WIDTH;     //单元格宽
    private int CELL_HEIGHT;    //单元格高
    private Paint mPaint;

    public PageIndicator(Context context) {
        super(context);
    }

    public PageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint = new Paint();
        setCellWH();
    }

    /**
     * 设置单元格宽高
     */
    private void setCellWH() {
        CELL_WIDTH = (getWidth() - getPaddingLeft() - getPaddingRight()) / DISPLAY_PAGE_NUMBERS;
        CELL_HEIGHT = getHeight() - getPaddingTop() - getPaddingBottom();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < DISPLAY_PAGE_NUMBERS; i++) {
            int startX = i * CELL_WIDTH + getPaddingLeft();
            int startY = getPaddingTop();
            canvas.drawRect(startX,startY,startX+CELL_WIDTH,startY+CELL_HEIGHT,mPaint);
            mPaint.setColor(Color.GREEN);
        }
    }
}
