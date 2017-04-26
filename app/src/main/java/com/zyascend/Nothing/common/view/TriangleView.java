package com.zyascend.Nothing.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能：三角形指示器
 * 作者：zyascend on 2017/4/25 16:41
 * 邮箱：zyascend@qq.com
 */

public class TriangleView extends View {


    /**
     * 绘制三角形的画笔
     */
    private Paint mPaint;
    /**
     * path构成一个三角形
     */
    private Path mPath;
    /**
     * 三角形的宽度
     */
    private int mTriangleWidth;
    /**
     * 三角形的高度
     */
    private int mTriangleHeight;

    private int width;
    private int height;


    public TriangleView(Context context) {
        this(context,null);
    }

    public TriangleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TriangleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 初始化画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#ffffffff"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setPathEffect(new CornerPathEffect(3));

    }

    /**
     * 初始化三角形的宽度
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);

        width = w;
        height = h;

        mTriangleWidth = w /8;
        // 初始化三角形
        mTriangleHeight = h;

        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(mTriangleWidth, 0);
        mPath.lineTo(mTriangleWidth / 2, -mTriangleHeight);
        mPath.close();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2-mTriangleWidth/2,height);
        canvas.drawPath(mPath, mPaint);
    }

}
