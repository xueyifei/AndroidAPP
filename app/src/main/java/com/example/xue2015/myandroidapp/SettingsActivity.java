package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.R;
import com.example.xue2015.myandroidapp.base.BaseActivity;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {
    TextView title;
    TextView right_text;
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initView();
        initData();
    }

    private void initView() {
        title = (TextView)findViewById(R.id.title);
        right_text = (TextView)findViewById(R.id.right_text);
        back = (TextView)findViewById(R.id.back);
        right_text.setVisibility(View.VISIBLE);
        right_text.setClickable(true);
        right_text.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void initData() {
        title.setText("设置");
        right_text.setText("意见反馈");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
//		overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.right_text:

                break;
            case R.id.back:
                onBackPressed();
                break;

            default:
                break;
        }
    }
}
