package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.view.DrawerView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class OthersActivity extends Activity {

    protected SlidingMenu slide_drawer;
    private ImageView top_head;
    private ImageView top_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_others);

        initBottomBar();
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.title_bar);
        TextView title = (TextView) rl.findViewById(R.id.title);
        title.setText("精彩推送");

        initView();
        initSlidingMenu();
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
                Intent it = new Intent(OthersActivity.this, MyQuestionFriendsActivity.class);
                OthersActivity.this.startActivity(it);
            }
        });

    }

    public void initSlidingMenu(){
        slide_drawer = new DrawerView(this).initSlidingMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_others, menu);
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

    public void initBottomBar(){
        RelativeLayout toMain = (RelativeLayout) findViewById(R.id.others_bottom_button_mainpage);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(OthersActivity.this, MainActivity.class);
                OthersActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPointsShop = (RelativeLayout) findViewById(R.id.others_bottom_button_pointshop);
        toPointsShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(OthersActivity.this, PointshopActivity.class);
                OthersActivity.this.startActivity(it);
            }
        });

        RelativeLayout toQueationCenter = (RelativeLayout) findViewById(R.id.others_bottom_button_questionnairecenter);
        toQueationCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(OthersActivity.this, QuestionnaireCenterActivity.class);
                OthersActivity.this.startActivity(it);
            }
        });
    }
}
