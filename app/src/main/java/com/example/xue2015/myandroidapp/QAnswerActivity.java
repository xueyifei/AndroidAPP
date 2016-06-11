package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class QAnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qanswer);

        initBottomBar();
        Titlebar tb = (Titlebar) findViewById(R.id.QAnswerActionbar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        Button done=(Button)findViewById(R.id.qanswer_bottom_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QAnswerActivity.this, QuestionnaireCenterActivity.class);
                QAnswerActivity.this.startActivity(it);
            }
        });
        title.setText("答题");
        tb.hideRight();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qanswer, menu);
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
        RelativeLayout toMain = (RelativeLayout) findViewById(R.id.qanswer_bottom_button_mainpage);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QAnswerActivity.this, MainActivity.class);
                QAnswerActivity.this.startActivity(it);
            }
        });

        RelativeLayout toQuestionnaireCenter = (RelativeLayout) findViewById(R.id.qanswer_bottom_button_questionnairecenter);
        toQuestionnaireCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QAnswerActivity.this, QuestionnaireCenterActivity.class);
                QAnswerActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPointShop = (RelativeLayout) findViewById(R.id.qanswer_bottom_button_pointshop);
        toPointShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QAnswerActivity.this, PointshopActivity.class);
                QAnswerActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPush = (RelativeLayout) findViewById(R.id.qanswer_bottom_button_push);
        toPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(QAnswerActivity.this, OthersActivity.class);
                QAnswerActivity.this.startActivity(it);
            }
        });


    }
}
