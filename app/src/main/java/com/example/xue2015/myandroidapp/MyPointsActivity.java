package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TextView;

public class MyPointsActivity extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_points);

        Titlebar tb = (Titlebar) findViewById(R.id.mypointsActionBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        title.setText("我的积分");
        tb.hideRight();

        TabHost tbh = (TabHost) findViewById(R.id.mypointsTabhost);
        tbh.setup(getLocalActivityManager());

        Intent it1 = new Intent(MyPointsActivity.this, MyPointsProfitActivity.class);
        Intent it2 = new Intent(MyPointsActivity.this, MyPointsSpendingActivity.class);

        tbh.addTab(tbh.newTabSpec("profitInfo_tab1").setIndicator("收益明细").setContent(it1));
        tbh.addTab(tbh.newTabSpec("spendingInfo_tab2").setIndicator("支出明细").setContent(it2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_points, menu);
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
