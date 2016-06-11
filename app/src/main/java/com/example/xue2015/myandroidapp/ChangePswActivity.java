package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xue2015.myandroidapp.util.ActivityCollector;
import com.example.xue2015.myandroidapp.util.TitleLayout;

public class ChangePswActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            setContentView(R.layout.activity_change_psw);
            TitleLayout tl = (TitleLayout) this
                    .findViewById(R.id.changePswActionBar);
            TextView title = (TextView) tl
                    .findViewById(R.id.textActionBarTitle);
            title.setText("修改密码");
            tl.hideRightButton();
        } catch (Exception e) {
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

    public void onClickChangePsw(View v) {
        Toast.makeText(ChangePswActivity.this, "修改成功", Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
