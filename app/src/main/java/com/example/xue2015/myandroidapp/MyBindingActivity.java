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
import android.widget.ImageButton;
import android.widget.TextView;

public class MyBindingActivity extends Activity {

    public Button getVertifyCiode;
    public ImageButton bindBankCard;
    public Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_binding);

        Titlebar tb =(Titlebar) findViewById(R.id.mybindingActionBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        Button register= (Button) findViewById(R.id.mybindingButtonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“登录”
                Intent toBindCards = new Intent(MyBindingActivity.this, LoginActivity.class);
                MyBindingActivity.this.startActivity(toBindCards);
            }
        });
        title.setText("我的绑定");
        tb.hideRight();

        getVertifyCiode = (Button) findViewById(R.id.mybindingButtonGetVeriCode);
        getVertifyCiode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取验证码
                getVertifyCiode.setText("等待59s");

            }
        });

        //处理绑定银行卡，但是现在在想到底应该怎么样去处理这个跳转
        bindBankCard = (ImageButton) findViewById(R.id.mybindingToBindingCard);
        bindBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“银行卡绑定”
                Intent toBindCards = new Intent(MyBindingActivity.this, BindingCardActivity.class);
                MyBindingActivity.this.startActivity(toBindCards);
            }
        });




//        register = (Button) findViewById(R.id.mybindingButtonRegister);
//        /*register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //注册，跳转到“登入"界面
//
           // }
       // });*/

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_binding, menu);
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
