package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class BindCardsInfoActivity extends Activity {

    public Button bindCardInfoComfire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bind_cards_info);

        Titlebar tb = (Titlebar) findViewById(R.id.bindCardInfoActionBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        title.setText("绑定银行卡");
        tb.hideRight();

        bindCardInfoComfire =(Button) findViewById(R.id.bindCardInfoComfireBind);
        bindCardInfoComfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转“我的绑定”
                Intent toMyBindind = new Intent(BindCardsInfoActivity.this, MyBindingActivity.class);
                BindCardsInfoActivity.this.startActivity(toMyBindind);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bind_cards_info, menu);
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
