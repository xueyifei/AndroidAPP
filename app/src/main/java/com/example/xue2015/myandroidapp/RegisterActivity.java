package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.util.ActivityCollector;
import com.example.xue2015.myandroidapp.util.TitleLayout;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        try{
            setContentView(R.layout.activity_register);
            TitleLayout tl=(TitleLayout) this.findViewById(R.id.registerActionBar);
            TextView title=(TextView) tl.findViewById(R.id.textActionBarTitle);
            title.setText("注册");
            tl.hideRightButton();
        } catch(Exception e){
            e.printStackTrace();
        }
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

    public void onClickRegister(View v) {
        Intent it = new Intent();
        it.setClass(this, LoginActivity.class);
        startActivity(it);
        ActivityCollector.finishAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
