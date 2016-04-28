package cn.yzapp.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.yzapp.supertextview.SuperTextView;
/**
 * @author: nestor
 * email: nestor@yzapp.cn
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setText();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setText() {
        RoundedStrokeSpan strokeSpan = new RoundedStrokeSpan(this, R.color.colorAccent, R.color.colorPrimary);
        strokeSpan.setPadding(8, -8, 10, 18);

        SuperTextView textView = (SuperTextView) findViewById(R.id.textview);
        textView.addText("你好世界", new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),new StrikethroughSpan())
                .text("电话")
                .setSpan(strokeSpan)
                .setUrl("tel:0123456789")
                .setFontColor(getResources().getColor(R.color.colorPrimary))
                .add()
                .addImage(getResources().getDrawable(R.drawable.icon_city))
                .text("我的blog")
                .setUrl("http://blog.yzapp.cn")
                .setFontStyle(Typeface.BOLD_ITALIC)
                .setFontColor(getResources().getColor(R.color.colorPrimary))
                .add();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
