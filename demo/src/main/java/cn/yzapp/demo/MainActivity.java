package cn.yzapp.demo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.joda.time.Period;

import java.text.DecimalFormat;

import cn.yzapp.supertextview.SuperTextView;

/**
 * @author: nestor
 * email: nestor@yzapp.cn
 */
public class MainActivity extends AppCompatActivity {

    private SuperTextView textView;
    private SuperTextView textView2;
    private MyHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long now = System.currentTimeMillis();
                mHandler.setNow(now + 2000, now + 8000, now);
                Snackbar.make(view, "QUICK", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textView = (SuperTextView) findViewById(R.id.textview);
        textView2 = (SuperTextView) findViewById(R.id.textview2);

        setText();

        long now = SystemClock.currentThreadTimeMillis();
        mHandler = new MyHandler();
        mHandler.setNow(now + 20000, now + 80000, now);

    }

    private void setText() {

        textView.text("电话")
                .setUrl("tel:0123456789")
                .setFontColor(getResources().getColor(R.color.colorPrimary))
                .add()
                .addImage(getResources().getDrawable(R.drawable.icon_city))
                .text("我的blog")
                .setUrl("http://blog.yzapp.cn")
                .setFontStyle(Typeface.BOLD_ITALIC)
                .setFontColor(getResources().getColor(R.color.colorPrimary))
                .add()
                .text("和我签订契约，成为魔法少女吧！")
                .setFontColor(getResources().getColor(R.color.colorAccent))
                .add();
    }


    class MyHandler extends Handler {
        private long now;
        private long beginDate, endDate;

        public void setNow(long beginDate, long endDate, long now) {
            this.now = now;
            this.beginDate = beginDate;
            this.endDate = endDate;
            sendMessageDelayed(obtainMessage(0), 0);
        }

        @Override
        public void handleMessage(Message msg) {
            now += 100;
            setText(beginDate, endDate, now);
            if ((now - endDate) <= 0) {
                sendMessageDelayed(obtainMessage(0), 100);
            }
        }
    }

    private void setText(long beginDate, long endDate, long now) {
        textView2.clear();
        Period p;
        if ((now - endDate) > 0) {
            //结束
            String start = "今日抢光，明日请早";
            textView2.text(start)
                    .setFontColor(Color.RED)
                    .add();

        } else if ((now - beginDate) < 0) {
            //没有开始
            String start = "距开始仅剩 ";
            p = new Period(now, beginDate);
            int hour = p.getHours();
            int min = p.getMinutes();
            float sec = p.getSeconds() + (float) p.getMillis() / 1000;

            DecimalFormat fnum = new DecimalFormat("##0.0");
            String secText;
            if (sec < 10) {
                secText = " 0" + fnum.format(sec) + " ";
            } else {
                secText = " " + fnum.format(sec) + " ";
            }

            addText(start, hour, min, secText);
        } else {
            String start = "距结束仅剩 ";
            p = new Period(now, endDate);
            int hour = p.getHours();
            int min = p.getMinutes();
            float sec = p.getSeconds() + (float) p.getMillis() / 1000;

            DecimalFormat fnum = new DecimalFormat("##0.0");
            String secText;
            if (sec < 10) {
                secText = " 0" + fnum.format(sec) + " ";
            } else {
                secText = " " + fnum.format(sec) + " ";
            }


            addText(start, hour, min, secText);
        }
    }

    private void addText(String start, int hour, int min, String secText) {
        textView2.text(start)
                .add()
                .text(" " + (hour < 10 ? "0" + hour : hour) + " ")
                .setSpan(new RoundedBackgroundSpan(this))
                .add()
                .text(" : ")
                .setFontStyle(Typeface.BOLD)
                .setFontColor(Color.BLACK)
                .add()
                .text(" " + (min < 10 ? "0" + min : min) + " ")
                .setSpan(new RoundedBackgroundSpan(this))
                .add()
                .text(" : ")
                .setFontStyle(Typeface.BOLD)
                .setFontColor(Color.BLACK)
                .add()
                .text(secText)
                .setSpan(new RoundedBackgroundSpan(this))
                .add();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
