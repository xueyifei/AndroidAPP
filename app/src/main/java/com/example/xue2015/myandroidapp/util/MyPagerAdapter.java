package com.example.xue2015.myandroidapp.util;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.*;

public class MyPagerAdapter extends PagerAdapter {

	private ArrayList<View> viewlist;

	public MyPagerAdapter(ArrayList<View> viewlist) {
		this.viewlist = viewlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;	//never reach to the boundary
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		
	}

	@Override
	public Object instantiateItem(ViewGroup container,int position){
		position%=viewlist.size();
		if(position<0)
			position=viewlist.size();
		View view=viewlist.get(position);
		ViewParent vp=view.getParent();
		if(vp!=null){
			ViewGroup parent=(ViewGroup)vp;
			parent.removeView(view);
		}
		container.addView(view);
		return view;
	}
	
}
