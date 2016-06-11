package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.util.ActivityCollector;
import com.example.xue2015.myandroidapp.util.TitleLayout;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            setContentView(R.layout.activity_login);
            TitleLayout tl = (TitleLayout) this
                    .findViewById(R.id.loginActionBar);
            TextView title = (TextView) tl
                    .findViewById(R.id.textActionBarTitle);
            title.setText("登录");
            tl.hideRightButton();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView tv = (TextView) this.findViewById(R.id.iForgetMyPsw);
        tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);// 下划线
        tv.setTextColor(Color.BLUE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent parentActivityIntent = new Intent(this, MainActivity.class);
                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(parentActivityIntent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickIForgetMyPsw(View v) {
        Intent it = new Intent();
        it.setClass(this, FindPswActivity.class);
        startActivity(it);
    }

    public void onClickLogin(View v) {
        Intent it = new Intent();
        it.setClass(this, MainActivity.class);
        startActivity(it);
        ActivityCollector.finishAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

}
