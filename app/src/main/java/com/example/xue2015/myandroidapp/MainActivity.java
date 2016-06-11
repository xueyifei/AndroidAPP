package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xue2015.myandroidapp.util.ActivityCollector;
import com.example.xue2015.myandroidapp.util.ListItemQuestions;
import com.example.xue2015.myandroidapp.util.ListItemRewards;
import com.example.xue2015.myandroidapp.util.MyMainPagerHandler;
import com.example.xue2015.myandroidapp.util.QuestionItemAdapter;
import com.example.xue2015.myandroidapp.util.RewardItemAdapter;
import com.example.xue2015.myandroidapp.view.DrawerView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements
        ViewPager.OnPageChangeListener, View.OnClickListener {

    private long mExitTime;
    public ViewPager vp;
    public MyMainPagerHandler handler = new MyMainPagerHandler(
            new WeakReference<MainActivity>(this));
    MyPagerAdapter pa;

    protected SlidingMenu side_drawer;

    /** head 头部 的左侧菜单 按钮 */
    private ImageView top_head;
    /** head 头部 的右侧菜单 按钮 */
    private ImageView top_more;

    private RelativeLayout mainpage, questionnairecenter, pointshop, push;
    private List<ListItemQuestions> questionList01 = new ArrayList<ListItemQuestions>();
    private List<ListItemQuestions> questionList02 = new ArrayList<ListItemQuestions>();
    private List<ListItemQuestions> questionList03 = new ArrayList<ListItemQuestions>();
    private List<ListItemRewards> questionList04 = new ArrayList<ListItemRewards>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        try {
            setContentView(R.layout.main);
            LayoutInflater If = LayoutInflater.from(this);
            final ArrayList<View> aViews = new ArrayList<View>();
            View v1 = If.inflate(R.layout.img4, null);
            View v2 = If.inflate(R.layout.img5, null);
            View v3 = If.inflate(R.layout.img6, null);
            aViews.add(v1);
            aViews.add(v2);
            aViews.add(v3);
            vp = (ViewPager) findViewById(R.id.viewpager);
            pa = new MyPagerAdapter(aViews);
            vp.setAdapter(pa);
            vp.setOnPageChangeListener(this);
            // vp.setCurrentItem(Integer.MAX_VALUE/2);//默认在中间，使用户看不到边界，现在还有些问题
            handler.sendEmptyMessageDelayed(MyPagerHandler.MSG_UPDATE_IMAGE,
                    MyPagerHandler.MSG_DELAY);
            TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
            tabhost.setup();
            tabhost.addTab(tabhost.newTabSpec("tab01").setIndicator("限时抢单")
                    .setContent(R.id.tab01));
            tabhost.addTab(tabhost.newTabSpec("tab02").setIndicator("今日热单")
                    .setContent(R.id.tab02));
            tabhost.addTab(tabhost.newTabSpec("tab03").setIndicator("高收益")
                    .setContent(R.id.tab03));
            tabhost.addTab(tabhost.newTabSpec("tab04").setIndicator("滚单有奖")
                    .setContent(R.id.tab04));
            tabhost.addTab(tabhost.newTabSpec("tab05").setIndicator("我的钱包")
                    .setContent(R.id.tab05));
            for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {
                TextView textView = (TextView) tabhost.getTabWidget()
                        .getChildAt(i).findViewById(android.R.id.title);
                textView.setTextSize(10);
                textView.setGravity(Gravity.CENTER);
                textView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                textView.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            }
            initView();
            initSlidingMenu();
            tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    // TODO Auto-generated method stub
                    if (tabId == "tab05")
                        vp.setVisibility(View.GONE);
                    else
                        vp.setVisibility(View.VISIBLE);
                }
            });

            mainpage = (RelativeLayout) findViewById(R.id.main_page_bottom_button_mainpage);
            mainpage.setOnClickListener(this);

            questionnairecenter = (RelativeLayout) findViewById(R.id.main_page_bottom_button_questionnairecenter);
            questionnairecenter.setOnClickListener(this);

            pointshop = (RelativeLayout) findViewById(R.id.main_page_bottom_button_pointshop);
            pointshop.setOnClickListener(this);

            push = (RelativeLayout) findViewById(R.id.main_page_bottom_button_push);
            push.setOnClickListener(this);



            initQuestionList();
            QuestionItemAdapter adapter01 = new QuestionItemAdapter(
                    MainActivity.this, R.layout.question_item, questionList01,
                    true);
            ListView listView01 = (ListView) findViewById(R.id.list_view_tab01);
            listView01.setAdapter(adapter01);
            listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("恭喜抢单成功！")
                            .setMessage(
                                    "请按照以下要求完成问卷调查\n1、请在规定时间内完成问卷\n2、请按照问卷内容进行回答\n3、符合问卷题目数量")
                            .setPositiveButton("开始",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {// 确定按钮的响应事件
                                            // TODO Auto-generated method stub
                                            // 跳转到问卷页
//                                            ListItemQuestions question = questionList01
//                                                    .get(position);
//                                            Toast.makeText(MainActivity.this,
//                                                    question.getName(),
//                                                    Toast.LENGTH_SHORT).show();
                                            Intent it = new Intent(MainActivity.this, QAnswerActivity.class);
                                            MainActivity.this.startActivity(it);
                                        }
                                    })
                            .setNegativeButton("返回",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            // TODO Auto-generated method stub
                                            // 返回
                                        }

                                    }).show();
                }

            });

            QuestionItemAdapter adapter02 = new QuestionItemAdapter(
                    MainActivity.this, R.layout.question_item, questionList02,
                    false);
            ListView listView02 = (ListView) findViewById(R.id.list_view_tab02);
            listView02.setAdapter(adapter02);
            listView02.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("恭喜抢单成功！")
                            .setMessage(
                                    "请按照以下要求完成问卷调查\n1、请在规定时间内完成问卷\n2、请按照问卷内容进行回答\n3、符合问卷题目数量")
                            .setPositiveButton("开始",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {// 确定按钮的响应事件
                                            // TODO Auto-generated method stub
                                            // 跳转到问卷页
//                                            ListItemQuestions question = questionList02
//                                                    .get(position);
//                                            Toast.makeText(MainActivity.this,
//                                                    question.getName(),
//                                                    Toast.LENGTH_SHORT).show();
                                            Intent it = new Intent(MainActivity.this, QAnswerActivity.class);
                                            MainActivity.this.startActivity(it);
                                        }
                                    })
                            .setNegativeButton("返回",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            // TODO Auto-generated method stub
                                            // 返回
                                        }

                                    }).show();
                }

            });

            QuestionItemAdapter adapter03 = new QuestionItemAdapter(
                    MainActivity.this, R.layout.question_item, questionList03,
                    false);
            ListView listView03 = (ListView) findViewById(R.id.list_view_tab03);
            listView03.setAdapter(adapter03);
            listView03.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("恭喜抢单成功！")
                            .setMessage(
                                    "请按照以下要求完成问卷调查\n1、请在规定时间内完成问卷\n2、请按照问卷内容进行回答\n3、符合问卷题目数量")
                            .setPositiveButton("开始",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {// 确定按钮的响应事件
                                            // TODO Auto-generated method stub
                                            // 跳转到问卷页
//                                            ListItemQuestions question = questionList03
//                                                    .get(position);
//                                            Toast.makeText(MainActivity.this,
//                                                    question.getName(),
//                                                    Toast.LENGTH_SHORT).show();
                                            Intent it = new Intent(MainActivity.this, QAnswerActivity.class);
                                            MainActivity.this.startActivity(it);
                                        }
                                    })
                            .setNegativeButton("返回",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            // TODO Auto-generated method stub
                                            // 返回
                                        }

                                    }).show();
                }

            });

            RewardItemAdapter adapter04 = new RewardItemAdapter(
                    MainActivity.this, R.layout.reward_item, questionList04);
            ListView listView04 = (ListView) findViewById(R.id.list_view_tab04);
            listView04.setAdapter(adapter04);
            listView04.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {
                    // TODO Auto-generated method stub
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("恭喜抢单成功！")
                            .setMessage(
                                    "请按照以下要求完成问卷调查\n1、请在规定时间内完成问卷\n2、请按照问卷内容进行回答\n3、符合问卷题目数量")
                            .setPositiveButton("开始",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {// 确定按钮的响应事件
                                            // TODO Auto-generated method stub
                                            // 跳转到问卷页
//                                            ListItemRewards question = questionList04
//                                                    .get(position);
//                                            Toast.makeText(MainActivity.this,
//                                                    question.getQuestionName(),
//                                                    Toast.LENGTH_SHORT).show();
                                            Intent it = new Intent(MainActivity.this, QAnswerActivity.class);
                                            MainActivity.this.startActivity(it);
                                        }
                                    })
                            .setNegativeButton("返回",
                                    new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            // TODO Auto-generated method stub
                                            // 返回
                                        }

                                    }).show();
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initQuestionList() {
        ListItemQuestions q11 = new ListItemQuestions("问卷1", 200, 100, 500,
                R.drawable.u112);
        questionList01.add(q11);
        ListItemQuestions q12 = new ListItemQuestions("问卷2", 300, 150, 300,
                R.drawable.u112);
        questionList01.add(q12);
        ListItemQuestions q13 = new ListItemQuestions("问卷3", 250, 150, 700,
                R.drawable.u112);
        questionList01.add(q13);
        ListItemQuestions q14 = new ListItemQuestions("问卷4", 50, 10, 1000,
                R.drawable.u112);
        questionList01.add(q14);
        ListItemQuestions q15 = new ListItemQuestions("问卷5", 1500, 1000, 100,
                R.drawable.u112);
        questionList01.add(q15);
        ListItemQuestions q16 = new ListItemQuestions("问卷6", 200, 9, 500,
                R.drawable.u112);
        questionList01.add(q16);
        ListItemQuestions q17 = new ListItemQuestions("问卷7", 200, 123, 500,
                R.drawable.u112);
        questionList01.add(q17);
        ListItemQuestions q18 = new ListItemQuestions("问卷8", 234, 123, 500,
                R.drawable.u112);
        questionList01.add(q18);

        ListItemQuestions q21 = new ListItemQuestions("问卷1", 200, 100, 500,
                R.drawable.u112);
        questionList02.add(q21);
        ListItemQuestions q22 = new ListItemQuestions("问卷2", 300, 150, 300,
                R.drawable.u112);
        questionList02.add(q22);
        ListItemQuestions q23 = new ListItemQuestions("问卷3", 250, 150, 700,
                R.drawable.u112);
        questionList02.add(q23);
        ListItemQuestions q24 = new ListItemQuestions("问卷4", 50, 10, 1000,
                R.drawable.u112);
        questionList02.add(q24);
        ListItemQuestions q25 = new ListItemQuestions("问卷5", 1500, 1000, 100,
                R.drawable.u112);
        questionList02.add(q25);
        ListItemQuestions q26 = new ListItemQuestions("问卷6", 200, 9, 500,
                R.drawable.u112);
        questionList02.add(q26);
        ListItemQuestions q27 = new ListItemQuestions("问卷7", 200, 123, 500,
                R.drawable.u112);
        questionList02.add(q27);
        ListItemQuestions q28 = new ListItemQuestions("问卷8", 234, 123, 500,
                R.drawable.u112);
        questionList02.add(q28);

        ListItemQuestions q31 = new ListItemQuestions("问卷1", 200, 100, 500,
                R.drawable.u112);
        questionList03.add(q31);
        ListItemQuestions q32 = new ListItemQuestions("问卷2", 300, 150, 300,
                R.drawable.u112);
        questionList03.add(q32);
        ListItemQuestions q33 = new ListItemQuestions("问卷3", 250, 150, 700,
                R.drawable.u112);
        questionList03.add(q33);
        ListItemQuestions q34 = new ListItemQuestions("问卷4", 50, 10, 1000,
                R.drawable.u112);
        questionList03.add(q34);
        ListItemQuestions q35 = new ListItemQuestions("问卷5", 1500, 1000, 100,
                R.drawable.u112);
        questionList03.add(q35);
        ListItemQuestions q36 = new ListItemQuestions("问卷6", 200, 9, 500,
                R.drawable.u112);
        questionList03.add(q36);
        ListItemQuestions q37 = new ListItemQuestions("问卷7", 200, 123, 500,
                R.drawable.u112);
        questionList03.add(q37);
        ListItemQuestions q38 = new ListItemQuestions("问卷8", 234, 123, 500,
                R.drawable.u112);
        questionList03.add(q38);

        ListItemRewards q41 = new ListItemRewards("问卷1", 200, 100, 500,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q41);
        ListItemRewards q42 = new ListItemRewards("问卷2", 300, 150, 300,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q42);
        ListItemRewards q43 = new ListItemRewards("问卷3", 250, 150, 700,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q43);
        ListItemRewards q44 = new ListItemRewards("问卷4", 50, 10, 1000,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q44);
        ListItemRewards q45 = new ListItemRewards("问卷5", 1500, 1000, 100,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q45);
        ListItemRewards q46 = new ListItemRewards("问卷6", 200, 9, 500,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q46);
        ListItemRewards q47 = new ListItemRewards("问卷7", 200, 123, 500,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q47);
        ListItemRewards q48 = new ListItemRewards("问卷8", 234, 123, 500,
                R.drawable.u112, "XXXX礼物", R.drawable.u75);
        questionList04.add(q48);
    }

    /** 初始化layout控件 */
    private void initView() {
        top_head = (ImageView) findViewById(R.id.top_head);
        top_more = (ImageView) findViewById(R.id.top_more);
        top_head.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (side_drawer.isMenuShowing()) {
                    side_drawer.showContent();
                } else {
                    side_drawer.showMenu();
                }
            }
        });
        top_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                if (side_drawer.isSecondaryMenuShowing()) {
//                    side_drawer.showContent();
//                } else {
//                    side_drawer.showSecondaryMenu();
//                }
                Intent it = new Intent(MainActivity.this, MyQuestionFriendsActivity.class);
                MainActivity.this.startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void initSlidingMenu() {
        side_drawer = new DrawerView(this).initSlidingMenu();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (side_drawer.isMenuShowing()
                    || side_drawer.isSecondaryMenuShowing()) {
                side_drawer.showContent();
            } else {
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            }
            return true;
        }
        // 拦截MENU按钮点击事件，让他无任何操作
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                handler.sendEmptyMessage(MyPagerHandler.MSG_KEEP_SILENT);
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                handler.sendEmptyMessageDelayed(MyPagerHandler.MSG_UPDATE_IMAGE,
                        MyPagerHandler.MSG_DELAY);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        Intent it=new Intent();
        switch (v.getId()) {
            case R.id.main_page_bottom_button_questionnairecenter:
                it.setClass(this, QuestionnaireCenterActivity.class);
                startActivity(it);
                break;
            case R.id.main_page_bottom_button_pointshop:
                it.setClass(this, PointshopActivity.class);
                startActivity(it);
                break;
            case R.id.main_page_bottom_button_push:
                it.setClass(this, OthersActivity.class);
                startActivity(it);
                break;
            default:
                break;
        }
    }

    public void onClickExchange(View v) {
//        Toast.makeText(MainActivity.this, "Exchange", Toast.LENGTH_SHORT)
//                .show();
        Intent it = new Intent(MainActivity.this, PointshopActivity.class);
        MainActivity.this.startActivity(it);
    }

    public void onClickCashIn(View v) {
//        Toast.makeText(MainActivity.this, "Cash in", Toast.LENGTH_SHORT)
//                .show();
        //这里的事件，我还没有写，要不你写？
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();//Builder直接create成AlertDialog
        alertDialog.show();//AlertDialog先得show出来，才能得到其Window
        final Window window = alertDialog.getWindow();//得到AlertDialog的Window
        window.setContentView(R.layout.cash_out);//给Window设置自定义布局
        View layout = LayoutInflater.from(MainActivity.this).inflate(R.layout.cash_out, null);//从xml中inflate过来
//              TextView dialogMsg = (TextView) window.findViewById(R.id.alert_dialog_message);//从Window中findView
        Button yes = (Button) window.findViewById(R.id.cash_out_done);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击确定事件的触发
                alertDialog.cancel();



            }
        });


    }

    public void onClickCheckDetail(View v) {
//        Toast.makeText(MainActivity.this, "Check detail", Toast.LENGTH_SHORT)
//                .show();
        Intent it = new Intent(MainActivity.this, MyPointsActivity.class);
        MainActivity.this.startActivity(it);

    }

}
