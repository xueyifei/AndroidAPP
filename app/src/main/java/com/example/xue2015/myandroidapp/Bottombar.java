package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by xue2015 on 2015/7/26.
 */

public class Bottombar extends LinearLayout {

    public Bottombar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //��ȡ�ǵ�ǰ��java��Ӧ�Ĳ����еĿؼ�
        LayoutInflater.from(context).inflate(R.layout.bottombar, this);

        Button mainPage = (Button) findViewById(R.id.mainPageBottomBar);
        Button question = (Button) findViewById(R.id.questionCenterBottomBar);
        Button point = (Button) findViewById(R.id.pointsBottomBar);
        Button others = (Button) findViewById(R.id.othersBottomBar);

        mainPage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //�����ת������ҳ�����¼�����



            }
        });

        question.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //�����ת�����ʾ����ġ����¼�����
                Activity currentActivity = (Activity) getContext();
                Intent it = new Intent(currentActivity, QuestionnaireCenterActivity.class );
                currentActivity.startActivity(it);
            }
        });

        point.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //�����ת���������̳ǡ����¼�����
                Activity currentActivity = (Activity) getContext();
                Intent it = new Intent(currentActivity, PointshopActivity.class );
                currentActivity.startActivity(it);
            }
        });

        others.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //�����ת�����������͡����¼�����
                Activity currentActivity = (Activity) getContext();
                Intent it = new Intent(currentActivity, OthersActivity.class );
                currentActivity.startActivity(it);

            }
        });
    }
}
