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

public class BindingCardActivity extends Activity {

    public Button bindingCardsNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_binding_card);

        Titlebar tb = (Titlebar) findViewById(R.id.bindingCardsActionBar);
        TextView title = (TextView) findViewById(R.id.textAxtionBarTitle);
        title.setText("绑定银行卡");
        tb.hideRight();


        bindingCardsNext = (Button) findViewById(R.id.bindingCardsNext);
        bindingCardsNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“绑定”
                Intent toBindCardInfo = new Intent(BindingCardActivity.this, BindCardsInfoActivity.class);
                BindingCardActivity.this.startActivity(toBindCardInfo);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_binding_card, menu);
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
