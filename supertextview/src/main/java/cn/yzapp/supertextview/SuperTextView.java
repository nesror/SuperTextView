package cn.yzapp.supertextview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;

/**
 * @author: nestor
 * email: nestor@yzapp.cn
 */
public class SuperTextView extends android.support.v7.widget.AppCompatTextView {
    private SpannableString mSpannableString;
    private int length;

    public SuperTextView(Context context) {
        super(context);
    }

    public SuperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 清空文本
     */
    public void clear() {
        setText(null);
        length = 0;
    }

    /**
     * 设置文本
     *
     * @return SuperTextView
     */
    public SuperTextView text(CharSequence text) {
        mSpannableString = new SpannableString(text);
        length = text.length();
        return this;
    }

    /**
     * 设置自定义样式
     *
     * @return SuperTextView
     */
    public SuperTextView setSpan(CharacterStyle span) {
        mSpannableString.setSpan(span, 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 设置字体颜色
     *
     * @return SuperTextView
     */
    public SuperTextView setFontColor(@ColorInt int color) {
        mSpannableString.setSpan(new ForegroundColorSpan(color), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 设置背景颜色
     *
     * @return SuperTextView
     */
    public SuperTextView setBackColor(@ColorInt int color) {
        mSpannableString.setSpan(new BackgroundColorSpan(color), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 设置字体大小
     *
     * @return SuperTextView
     */
    public SuperTextView setFontSize(int size) {
        mSpannableString.setSpan(new AbsoluteSizeSpan(size, true), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 设置字体相对大小
     *
     * @return SuperTextView
     */
    public SuperTextView setFontRelativeSize(float relativeSize) {
        mSpannableString.setSpan(new RelativeSizeSpan(relativeSize), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 设置正常，粗体，斜体，粗斜体
     *
     * @param typeface android.graphics.Typeface.NORMAL\BOLD\ITALIC\BOLD_ITALIC
     * @return SuperTextView
     */
    public SuperTextView setFontStyle(int typeface) {
        mSpannableString.setSpan(new StyleSpan(typeface), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 下划线
     *
     * @return SuperTextView
     */
    public SuperTextView setFontUnderLine() {
        mSpannableString.setSpan(new UnderlineSpan(), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 删除线
     *
     * @return SuperTextView
     */
    public SuperTextView setFontStrike() {
        mSpannableString.setSpan(new StrikethroughSpan(), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 上标
     *
     * @return SuperTextView
     */
    public SuperTextView setFontSubscript() {
        mSpannableString.setSpan(new SubscriptSpan(), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 下标
     *
     * @return SuperTextView
     */
    public SuperTextView setFontSuperscript() {
        mSpannableString.setSpan(new SuperscriptSpan(), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }

    /**
     * 超级链接
     *
     * @param url tel:电话;
     *            mailto:邮件;
     *            http://网址;
     *            sms:短信 或者smsto;
     *            mms:彩信 或者mmsto;
     *            geo:地图（geo:38.899533,-77.036476）
     * @return SuperTextView
     */
    public SuperTextView setUrl(String url) {
        mSpannableString.setSpan(new URLSpan(url), 0, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setMovementMethod(LinkMovementMethod.getInstance());
        return this;
    }

    /**
     * 添加设置好字体样式的文本
     *
     * @return SuperTextView
     */
    public SuperTextView add() {
        append(mSpannableString);
        return this;
    }

    /**
     * 直接增加的方法
     *
     * @param text  文字
     * @param spans 文本样式们
     * @return SuperTextView
     */
    public SuperTextView addText(CharSequence text, CharacterStyle... spans) {
        SpannableString spannableString = new SpannableString(text);
        for (CharacterStyle span : spans) {
            spannableString.setSpan(span, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        append(spannableString);
        return this;
    }

    /**
     * 添加图片，更多图片样式请使用setSpan方法
     *
     * @param d Drawable
     * @return SuperTextView
     */
    public SuperTextView addImage(Drawable d) {
        SpannableString spanString = new SpannableString(" ");
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
        spanString.setSpan(span, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        append(spanString);
        return this;
    }

}
