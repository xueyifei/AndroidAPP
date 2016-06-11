package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import com.example.xue2015.myandroidapp.view.DrawerView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import static android.widget.Toast.LENGTH_SHORT;


public class QuestionnaireCenterActivity extends ActivityGroup implements View.OnClickListener, ViewPager.OnPageChangeListener {

    public ListView listView_doing;
    public ListView listView_done;
    public ListView listView_count;
    public List<Map<String, Object>> dataList_doing;
    public List<Map<String, Object>> dataList_done;
    public List<Map<String, Object>> dataList_count;
    public SimpleAdapter simp_adapter_doing;
    public SimpleAdapter simp_adapter_done;
    public SimpleAdapter simp_adapter_count;
    private long mExitTime;
    protected SlidingMenu slide_drawer;

    private ImageView top_head;
    private ImageView top_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_questionnaire_center);
        LayoutInflater If = LayoutInflater.from(this);

        initView();
        initSlidingMenu();
        initBottomBar();
        TabHost th = (TabHost) findViewById(R.id.tabhost1);
//        th.setup();
        th.setup(getLocalActivityManager());

        Intent it1 = new Intent(QuestionnaireCenterActivity.this, QDoingActivity.class);
        Intent it2 = new Intent(QuestionnaireCenterActivity.this, QDoneActivity.class);
        Intent it3 = new Intent(QuestionnaireCenterActivity.this, QCountActivity.class);

        th.addTab(th.newTabSpec("doing_tab1").setIndicator("进行中问卷").setContent(it1));
        th.addTab(th.newTabSpec("done_tab2").setIndicator("已完成问卷").setContent(it2));
        th.addTab(th.newTabSpec("count_tab3").setIndicator("问卷统计").setContent(it3));


    }

    public void initView(){
        top_head = (ImageView) findViewById(R.id.top_head);
        top_more = (ImageView) findViewById(R.id.top_more);

        top_head.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (slide_drawer.isMenuShowing()) {
                    slide_drawer.showContent();
                } else {
                    slide_drawer.showMenu();
                }
            }
        });
        top_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                if (slide_drawer.isSecondaryMenuShowing()) {
//                    slide_drawer.showContent();
//                } else {
//                    slide_drawer.showSecondaryMenu();
//                }

                Intent it = new Intent(QuestionnaireCenterActivity.this, MyQuestionFriendsActivity.class);
                QuestionnaireCenterActivity.this.startActivity(it);
            }
        });

    }

    public void initSlidingMenu(){
        slide_drawer = new DrawerView(this).initSlidingMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questionnaire_center, menu);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (slide_drawer.isMenuShowing()
                    || slide_drawer.isSecondaryMenuShowing()) {
                slide_drawer.showContent();
            } else {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出", LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            }
            return true;
        }
        // 拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void initBottomBar(){
        RelativeLayout toMain = (RelativeLayout) findViewById(R.id.question_center_bottom_button_mainpage);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QuestionnaireCenterActivity.this, MainActivity.class);
                QuestionnaireCenterActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPointsShop = (RelativeLayout) findViewById(R.id.question_center_bottom_button_pointshop);
        toPointsShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QuestionnaireCenterActivity.this, PointshopActivity.class);
                QuestionnaireCenterActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPush = (RelativeLayout) findViewById(R.id.question_center_bottom_button_push);
        toPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QuestionnaireCenterActivity.this, OthersActivity.class);
                QuestionnaireCenterActivity.this.startActivity(it);
            }
        });

    }


    @Override
    public void onClick(View v) {
//        Intent it1=new Intent();
//        switch (v.getId()) {
//            case R.id.question_center_bottom_button_mainpage:
//                it1.setClass(this, MainActivity.class);
//                startActivity(it1);
//                break;
//            case R.id.question_center_bottom_button_pointshop:
//                it1.setClass(this, PointshopActivity.class);
//                startActivity(it1);
//                break;
//            case R.id.question_center_bottom_button_push:
//                it1.setClass(this, OthersActivity.class);
//                startActivity(it1);
//                break;
//            default:
//                break;
//        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
