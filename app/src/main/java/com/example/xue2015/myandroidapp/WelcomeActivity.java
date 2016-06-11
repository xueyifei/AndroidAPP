package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.util.ActivityCollector;
import com.example.xue2015.myandroidapp.util.MyPagerHandler_Welcome;
import com.example.xue2015.myandroidapp.util.TitleLayout;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by xue2015 on 2015/8/10.
 */
public class WelcomeActivity extends Activity implements ViewPager.OnPageChangeListener {

    public ViewPager vp;
    ImageView[] images;
    ImageView img;
    LinearLayout ll;
    ViewGroup vg;
    public MyPagerHandler_Welcome handler = new MyPagerHandler_Welcome(
            new WeakReference<WelcomeActivity>(this));
    MyPagerAdapter pa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        final ArrayList<View> aViews = new ArrayList<View>();
        LayoutInflater If = LayoutInflater.from(this);
        vg = (ViewGroup) If.inflate(R.layout.activity_welcome, null);
        View v1 = If.inflate(R.layout.img1, null);
        View v2 = If.inflate(R.layout.img2, null);
        View v3 = If.inflate(R.layout.img3, null);
        aViews.add(v1);
        aViews.add(v2);
        aViews.add(v3);
        vp = (ViewPager) vg.findViewById(R.id.viewpager);
        ll = (LinearLayout) vg.findViewById(R.id.group);

        images = new ImageView[aViews.size()];
        for (int i = 0; i < images.length; i++) {
            img = new ImageView(this);
            img.setLayoutParams(new ViewGroup.LayoutParams(40, 40));
            img.setPadding(40, 0, 40, 0);
            if (i == 0)
                img.setBackgroundResource(R.drawable.u10);
            else
                img.setBackgroundResource(R.drawable.u8);
            images[i] = img;
            ll.addView(images[i]);
        }

        pa = new MyPagerAdapter(aViews);

        setContentView(vg);
        vp.setAdapter(pa);
        vp.setOnPageChangeListener(this);
        // vp.setCurrentItem(Integer.MAX_VALUE/2);//默认在中间，使用户看不到边界，现在还有些问题
        handler.sendEmptyMessageDelayed(MyPagerHandler.MSG_UPDATE_IMAGE,
                MyPagerHandler.MSG_DELAY);
        TitleLayout tl = (TitleLayout) this.findViewById(R.id.mainActionBar);
        TextView title = (TextView) tl.findViewById(R.id.textActionBarTitle);
        title.setText("问卷调查APP");
        tl.hideLeftButtun();
        tl.hideRightButton();
    }

    public void onPageSelected(int arg0) {
        handler.sendMessage(Message.obtain(handler,
                MyPagerHandler.MSG_PAGE_CHANGED, arg0, 0));
        for (int i = 0; i < images.length; i++)
            if (i == arg0 % images.length)
                images[i].setBackgroundResource(R.drawable.u10);
            else
                images[i].setBackgroundResource(R.drawable.u8);

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                handler.sendEmptyMessage(MyPagerHandler.MSG_KEEP_SILENT);
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                handler.sendEmptyMessageDelayed(MyPagerHandler.MSG_UPDATE_IMAGE,
                        MyPagerHandler.MSG_DELAY);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public void onClickLogin(View v) {
        Intent it = new Intent();
        it.setClass(this, LoginActivity.class);
        startActivity(it);
        // 加了finish()之后将无法通过按“返回键”返回该界面
        // this.finish();
    }

    public void onClickRegister(View v) {
        Intent it = new Intent();
        it.setClass(this, RegisterActivity.class);
        startActivity(it);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
