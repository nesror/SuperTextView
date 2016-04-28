package cn.yzapp.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.text.style.ReplacementSpan;


public class RoundedStrokeSpan extends ReplacementSpan {
    private int mCornerRadius = 8;
    private int mStrokeColor = 0;
    private int mTextColor = 0;
    private int mStrokeWidth = 4;

    private int mPaddingLeft = 0;
    private int mPaddingTop = 0;
    private int mPaddingRight = 0;
    private int mPaddingBottom = 0;

    public RoundedStrokeSpan(Context context, @ColorRes int strokeColor, @ColorRes int textColor) {
        super();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mStrokeColor = context.getColor(strokeColor);
            mTextColor = context.getColor(textColor);
        } else {
            mStrokeColor = context.getResources().getColor(strokeColor);
            mTextColor = context.getResources().getColor(textColor);
        }
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        RectF rect = new RectF(x,
                top - mPaddingTop,
                x + measureWidthText(paint, text, start, end) + mPaddingLeft + mPaddingRight,
                top + measureHeightText(paint, text, start, end) + mPaddingBottom);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(mStrokeWidth);
        paint.setColor(mStrokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawRoundRect(rect, mCornerRadius, mCornerRadius, paint);
        paint.setColor(mTextColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, start, end, x + mPaddingLeft, y, paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end) + mPaddingLeft + mPaddingRight);
    }

    private float measureWidthText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }

    private float measureHeightText(Paint paint, CharSequence text, int start, int end) {
        Rect bounds = new Rect();
        paint.getTextBounds(text.toString(), start, end, bounds);
        return bounds.height();
    }

    public int getCornerRadius() {
        return mCornerRadius;
    }

    public void setCornerRadius(int mCornerRadius) {
        this.mCornerRadius = mCornerRadius;
    }

    public int getStrokeColor() {
        return mStrokeColor;
    }

    public void setStrokeColor(int mStrokeColor) {
        this.mStrokeColor = mStrokeColor;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
    }

    public void setPadding(int left, int top, int right, int bottom) {
        this.mPaddingLeft = left;
        this.mPaddingTop = top;
        this.mPaddingRight = right;
        this.mPaddingBottom = bottom;
    }
}
