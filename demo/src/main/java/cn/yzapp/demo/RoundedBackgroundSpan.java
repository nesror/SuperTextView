package cn.yzapp.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.text.style.ReplacementSpan;

/**
 * @author: GuSiheng
 * @time: 4/8 008-15:25.
 * @email: gusiheng@qccr.com
 * @desc: textview的背景
 */
public class RoundedBackgroundSpan extends ReplacementSpan {
    private int mCornerRadius = 5;
    private int backgroundColor = Color.BLACK;
    private int mStrokeWidth = 2;
    private float mHalf = mStrokeWidth / 2;

    public RoundedBackgroundSpan(Context context) {
        super();
    }

    public RoundedBackgroundSpan(Context context, @ColorRes int backgroundColor, int cornerRadius, int strokeWidth) {
        super();
        this.backgroundColor = context.getResources().getColor(backgroundColor);
        mCornerRadius = cornerRadius;
        mStrokeWidth = strokeWidth;
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {

        canvas.drawText(text, start, end, x, y, paint);

        RectF rect = new RectF(x + mHalf, top + mHalf, x + measureText(paint, text, start, end) - mHalf, bottom - mHalf);
        //设置边框颜色
        paint.setColor(backgroundColor);
        paint.setStyle(Paint.Style.STROKE);
        //设置边框宽度
        paint.setStrokeWidth(mStrokeWidth);
        canvas.drawRoundRect(rect, mCornerRadius, mCornerRadius, paint);

    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}
