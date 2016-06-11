package com.example.xue2015.myandroidapp.util;

import com.example.xue2015.myandroidapp.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.title, this);
		if (!isInEditMode()) {
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
					Toast.makeText(getContext(), "You clicked Edit button",
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

	public void hideLeftButtun() {
		Button remove = (Button) this.findViewById(R.id.buttonActionBarLeft);
		remove.setVisibility(INVISIBLE);
	}

	public void hideRightButton() {
		Button remove = (Button) this.findViewById(R.id.buttonActionBarRight);
		remove.setVisibility(INVISIBLE);
	}

	public void hideTitle() {
		TextView remove = (TextView) this.findViewById(R.id.textActionBarTitle);
		remove.setVisibility(INVISIBLE);
	}

}
