package com.yzx.yzxpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yzx.yzxpractice.commonutils.L;

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
    private float textSize;

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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = 300;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = width / DISPLAY_PAGE_NUMBERS;
        }
        setMeasuredDimension(width, height);
    }

    private void init() {
        mPaint = new Paint();
    }

    /**
     * 设置单元格宽高
     */
    private void setCellWH() {
        CELL_WIDTH = (getWidth() - getPaddingLeft() - getPaddingRight()) / DISPLAY_PAGE_NUMBERS;
        CELL_HEIGHT = getHeight() - getPaddingTop() - getPaddingBottom();
        textSize = CELL_HEIGHT / 4f;
//        L.i("w:" + CELL_WIDTH + ",h:" + CELL_HEIGHT);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        setCellWH();
//        super.onDraw(canvas);
        //画格子
        mPaint.setColor(Color.YELLOW);
        for (int i = 0; i < DISPLAY_PAGE_NUMBERS; i++) {
            int startX = i * CELL_WIDTH + getPaddingLeft();
            int startY = getPaddingTop();
            canvas.drawRect(startX, startY, startX + CELL_WIDTH, startY + CELL_HEIGHT, mPaint);
        }
        //写字
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(CELL_HEIGHT / 4);
        for (int i = 0; i < DISPLAY_PAGE_NUMBERS; i++) {
            int startX = i * CELL_WIDTH + getPaddingLeft();
            int startY = getPaddingTop();
            canvas.drawText(i + 1 + "", startX + CELL_WIDTH / 2, startY + CELL_HEIGHT / 2 + textSize / 2, mPaint);
        }
    }
}
