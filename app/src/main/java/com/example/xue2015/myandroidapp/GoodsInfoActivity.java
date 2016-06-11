package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class GoodsInfoActivity extends Activity implements ViewPager.OnPageChangeListener{

    //    处理转播页
    public ViewPager vp;
    public ImageView[] images;
    public ImageView img;
    public LinearLayout ll;
    public ViewGroup vg;
    public MyPagerHandler_GoodsInfo handler = new MyPagerHandler_GoodsInfo(
            new WeakReference<GoodsInfoActivity>(this)
    );
    MyPagerAdapter pa;

    //购买数量=兑换数量
    public int exchangeNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_goods_info);

        //        处理转播页
        final ArrayList<View> aViews = new ArrayList<View>();
        LayoutInflater If = LayoutInflater.from(this);

        vg = (ViewGroup) If.inflate(R.layout.activity_goods_info, null);
        View v1 = If.inflate(R.layout.img_eg_show, null);
        View v2 = If.inflate(R.layout.img_eg_show, null);
        View v3 = If.inflate(R.layout.img_eg_show, null);
        aViews.add(v1);
        aViews.add(v2);
        aViews.add(v3);
        try{
            vp = (ViewPager) vg.findViewById(R.id.goodsInfoViewPager);
            ll = (LinearLayout) vg.findViewById(R.id.goodsInfoGroup);

            images = new ImageView[aViews.size()];
            for(int i = 0; i < images.length; i++){
                img = new ImageView(this);
                img.setLayoutParams(new ViewGroup.LayoutParams(20,20));
                img.setPadding(20,0,20,0);
                if(i == 0){
                    img.setBackgroundResource(R.drawable.u10);
                }else{
                    img.setBackgroundResource(R.drawable.u8);
                }
                images[i] = img;
                ll.addView(images[i]);
            }

            pa = new MyPagerAdapter(aViews);

            setContentView(vg);
            vp.setAdapter(pa);
            vp.setOnPageChangeListener(this);
//          vp.setCurrentItem(Integer.MAX_VALUE/2);
            handler.sendEmptyMessageDelayed(MyPagerHandler.MSG_UPDATE_IMAGE, MyPagerHandler.MSG_DELAY);

        }catch(Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        Titlebar tb = (Titlebar) findViewById(R.id.goodsInfoActionBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        title.setText("积分商城");
        tb.hideRight();

//      处理TabHost
        TabHost th = (TabHost) findViewById(R.id.tabhost);
        th.setup();

//        LayoutInflater If = LayoutInflater.from(this);
        If.inflate(R.layout.tab_content1, th.getTabContentView());
        If.inflate(R.layout.tab_content2, th.getTabContentView());

        th.addTab(th.newTabSpec("tab1").setIndicator("商品描述").setContent(R.id.tabLinearLayout1));
        th.addTab(th.newTabSpec("tab2").setIndicator("规格参数").setContent(R.id.tabLinearLayout2));

        final Button exchange = (Button) findViewById(R.id.goodsInfoWantExchange);
        exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加“我要兑换”的事件
                if(exchange.getText().equals("我要兑换")){
                    final AlertDialog alertDialog = new AlertDialog.Builder(GoodsInfoActivity.this).create();//Builder直接create成AlertDialog
                    alertDialog.show();//AlertDialog先得show出来，才能得到其Window
                    final Window window = alertDialog.getWindow();//得到AlertDialog的Window
                    window.setContentView(R.layout.exchange_num);//给Window设置自定义布局
//                    View layout = LayoutInflater.from(MainActivity.this).inflate(R.layout.cash_out, null);
                    View layout = LayoutInflater.from(GoodsInfoActivity.this).inflate(R.layout.exchange_num, null);//从xml中inflate过来
                    exchange.setText("立即兑换");

                    Button reduce = (Button) window.findViewById(R.id.reduceExchangeNum);
                    Button increase = (Button) window.findViewById(R.id.increaseExchangeNum);
                    final TextView showExchangeNum = (TextView) window.findViewById(R.id.exchangeNum);
                    showExchangeNum.setText("1");


                    reduce.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            exchangeNum--;
                            String exchangeNum_s = String.valueOf(exchangeNum);
                            showExchangeNum.setText(exchangeNum_s);
                        }
                    });

                    increase.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            exchangeNum++;
                            String exchangeNum_s = String.valueOf(exchangeNum);
                            showExchangeNum.setText(exchangeNum_s);
                        }
                    });

                }else{
                    final AlertDialog alertDialog = new AlertDialog.Builder(GoodsInfoActivity.this).create();//Builder直接create成AlertDialog
                    alertDialog.show();//AlertDialog先得show出来，才能得到其Window
                    final Window window = alertDialog.getWindow();//得到AlertDialog的Window
                    window.setContentView(R.layout.exchange_info);//给Window设置自定义布局
                    View layout = LayoutInflater.from(GoodsInfoActivity.this).inflate(R.layout.exchange_info, null);//从xml中inflate过来
                    exchange.setText("我要兑换");

                    Button success = (Button) window.findViewById(R.id.exchangeSuccess);
                    success.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.cancel();
                        }
                    });

                }



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_goods_info, menu);
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


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        handler.sendMessage(Message.obtain(handler,
                MyPagerHandler.MSG_PAGE_CHANGED, position, 0));
        for (int i = 0; i < images.length; i++)
            if (i == position % images.length)
                images[i].setBackgroundResource(R.drawable.u10);
            else
                images[i].setBackgroundResource(R.drawable.u8);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
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
}
