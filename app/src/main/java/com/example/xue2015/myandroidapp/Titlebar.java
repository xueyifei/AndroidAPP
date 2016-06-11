package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xue2015 on 2015/7/26.
 */
public class Titlebar extends LinearLayout {
    public Titlebar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titlebar_top,this);

        Button left = (Button) findViewById(R.id.buttonActionBarLeft);
        Button right = (Button) findViewById(R.id.buttonActionBarRight);

        left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity a = (Activity) getContext();
                a.finish();
            }
        });

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You click the Edit Button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void hideLeft(){
        Button remove = (Button) this.findViewById(R.id.buttonActionBarLeft);
        remove.setVisibility(INVISIBLE);
    }

    public void hideRight(){
        Button remove = (Button) this.findViewById(R.id.buttonActionBarRight);
        remove.setVisibility(INVISIBLE);
    }

    public void hideTitle(){
        TextView remove = (TextView) this.findViewById(R.id.textAxtionBarTitle);
        remove.setVisibility(INVISIBLE);
    }


}
