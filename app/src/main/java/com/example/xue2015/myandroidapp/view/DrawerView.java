package com.example.xue2015.myandroidapp.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.xue2015.myandroidapp.ChangeInfoActivity;
import com.example.xue2015.myandroidapp.ChangePswActivity;
import com.example.xue2015.myandroidapp.MyBindingActivity;
import com.example.xue2015.myandroidapp.MyPointsActivity;
import com.example.xue2015.myandroidapp.QuestionFeedbackActivity;
import com.example.xue2015.myandroidapp.R;
import com.example.xue2015.myandroidapp.ReceiveAddressActivity;
import com.example.xue2015.myandroidapp.RegisterActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
//import com.topnews.ChangePswActivity;
//import com.topnews.R;

/**
 * �Զ���SlidingMenu �����˵���
 * */
public class DrawerView implements OnClickListener{
	private final Activity activity;
	SlidingMenu localSlidingMenu;
	private RelativeLayout chang_psw,myInfo,myPoint,myBind,address,feedback;
	private Button setting,exit;
	public DrawerView(Activity activity) {
		this.activity = activity;
	}

	public SlidingMenu initSlidingMenu() {
		localSlidingMenu = new SlidingMenu(activity);
		localSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);//�������һ��˵�
		localSlidingMenu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);//����Ҫʹ�˵�������������Ļ�ķ�Χ
//		localSlidingMenu.setTouchModeBehind(SlidingMenu.RIGHT);
		localSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);//������ӰͼƬ�Ŀ��
		localSlidingMenu.setShadowDrawable(R.drawable.shadow);//������ӰͼƬ
		localSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//SlidingMenu����ʱ��ҳ����ʾ��ʣ����
		localSlidingMenu.setFadeDegree(0.35F);//SlidingMenu����ʱ�Ľ���̶�
		localSlidingMenu.attachToActivity(activity, SlidingMenu.RIGHT);//ʹSlidingMenu������Activity�ұ�
//		localSlidingMenu.setBehindWidthRes(R.dimen.left_drawer_avatar_size);//����SlidingMenu�˵��Ŀ��
		localSlidingMenu.setMenu(R.layout.left_drawer_fragment);//����menu�Ĳ����ļ�
//		localSlidingMenu.toggle();//��̬�ж��Զ��رջ���SlidingMenu
		localSlidingMenu.setSecondaryMenu(R.layout.profile_drawer_right);
		localSlidingMenu.setSecondaryShadowDrawable(R.drawable.shadowright);
		localSlidingMenu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
					public void onOpened() {
						
					}
				});
		
		initView();
		return localSlidingMenu;
	}

	private void initView() {		
		chang_psw =(RelativeLayout)localSlidingMenu.findViewById(R.id.change_psw);
		chang_psw.setOnClickListener(this);
		
		myInfo =(RelativeLayout)localSlidingMenu.findViewById(R.id.my_info);
		myInfo.setOnClickListener(this);
		
		myPoint =(RelativeLayout)localSlidingMenu.findViewById(R.id.my_point);
		myPoint.setOnClickListener(this);
		
		myBind =(RelativeLayout)localSlidingMenu.findViewById(R.id.my_bind);
		myBind.setOnClickListener(this);
		
		address =(RelativeLayout)localSlidingMenu.findViewById(R.id.address);
		address.setOnClickListener(this);
		
		feedback =(RelativeLayout)localSlidingMenu.findViewById(R.id.feedback);
		feedback.setOnClickListener(this);
		
		setting =(Button)localSlidingMenu.findViewById(R.id.buttonSetting);
		setting.setOnClickListener(this);
		
		exit =(Button)localSlidingMenu.findViewById(R.id.buttonExit);
		exit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.change_psw:
			activity.startActivity(new Intent(activity, ChangePswActivity.class));
			activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.my_info:
            activity.startActivity(new Intent(activity, ChangeInfoActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.my_point:
            activity.startActivity(new Intent(activity,MyPointsActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.my_bind:
            activity.startActivity(new Intent(activity,MyBindingActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.address:
                activity.startActivity(new Intent(activity,ReceiveAddressActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.feedback:
            activity.startActivity(new Intent(activity,QuestionFeedbackActivity.class));
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			break;
		case R.id.buttonSetting:
			break;
		case R.id.buttonExit:
			break;
		default:
			break;
		}
	}

}
