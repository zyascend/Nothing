package com.zyascend.Nothing.common.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;

import com.zyascend.Nothing.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能：有@人功能的textView
 * 作者：zyascend on 2017/5/22 22:54
 * 邮箱：zyascend@qq.com
 */

public class SpanTextView extends AppCompatTextView {

    private SpannableString spannableString;
    private Context context;
    private final String DEF_RULE ="@[^,，：:\\s@]+"; // @人的正则表达式
    private String MatchRule ="";
    private String str="";
    private ReminderClickListener reminderListener;
    //private MovementMethod mMovement;


    public SpanTextView(Context context) {
        super(context);
        this.context = context;
    }

    public SpanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public SpanTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    public boolean hasFocusable(){
        return false;
    }

    /**
     * @param text
     * @return
     */
    public void setText(String text,ReminderClickListener listener) {
        if(getMatchRule()==null) {
            /* 默认一个@的匹配规则 */
            setMatchRule(DEF_RULE);
        }
        this.reminderListener = listener;
        super.setText(setHighlight(text, getMatchRule()));
    }

    /**
     * '@XXX
     * @param text 文字
     * @param rule 匹配规则
     * @return
     */
    private SpannableString setHighlight(String text,String rule) {
        spannableString = new SpannableString(text);
        Pattern pattern = Pattern.compile(rule);
        Matcher matcher = pattern.matcher(text);
        int length = text.length();
        int end = 0;
        for (int i = 0; i < length; i++) {
            if (matcher.find()) {
                int start = matcher.start();
                end = matcher.end();
                str = text.substring(start + 1, end);
                spannableString.setSpan(new ClickSpan(str), start, end, Spanned.SPAN_MARK_POINT);
            }
        }
        return spannableString;
    }


    public String getMatchRule() {
        return MatchRule;
    }
    public void setMatchRule(String matchRule){
        this.MatchRule = matchRule;
    }

    private class ClickSpan extends ClickableSpan {

        private String reminder = "";

        ClickSpan(String name) {
            this.reminder = name;
        }

        @Override
        public void onClick(View view) {
            if (reminderListener!=null){
                reminderListener.onReminderClick(reminder);
            }
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            /** 给文字染色 **/
            ds.setColor(Color.parseColor("#fe644a"));
            /** 去掉下划线 ， 默认自带下划线 **/
            ds.setUnderlineText(false);
        }
    }

    public interface ReminderClickListener {
        void onReminderClick(String reminder);
    }
}
