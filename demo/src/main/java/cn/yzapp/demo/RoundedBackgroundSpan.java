package cn.yzapp.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.text.style.ReplacementSpan;

/**
 * @author: GuSiheng
 * @time: 4/8 008-15:25.
 * @email: gusiheng@qccr.com
 * @desc: textview的背景
 */
public class RoundedBackgroundSpan extends ReplacementSpan {
    private static int CORNER_RADIUS = 5;
    private int backgroundColor = Color.BLACK;
    private int textColor = Color.WHITE;

    public RoundedBackgroundSpan(Context context) {
        super();
    }

    public RoundedBackgroundSpan(Context context, @ColorRes int backgroundColor, @ColorRes int textColor, int cornerRadius) {
        super();
        this.backgroundColor = context.getResources().getColor(backgroundColor);
        this.textColor = context.getResources().getColor(textColor);
        CORNER_RADIUS = cornerRadius;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        RectF rect = new RectF(x, top, x + measureText(paint, text, start, end), bottom);
        paint.setColor(backgroundColor);
        canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);
        paint.setColor(textColor);
        canvas.drawText(text, start, end, x, y, paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}
