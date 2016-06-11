package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xue2015.myandroidapp.view.DrawerView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PointshopActivity extends Activity implements ViewPager.OnPageChangeListener {

    protected SlidingMenu side_drawer;

    /** head 头部 的左侧菜单 按钮 */
    private ImageView top_head;
    /** head 头部 的右侧菜单 按钮 */
    private TextView top_more;

//    处理转播页
    public ViewPager vp;
    public ImageView[] images;
    public ImageView img;
    public LinearLayout ll;
    public ViewGroup vg;
    public MyPagerHandler handler = new MyPagerHandler(
            new WeakReference<PointshopActivity>(this)
    );
    MyPagerAdapter pa;


//    处理ListView
    private ListView listView;
    private SimpleAdapter simp_apater;
    private List<Map<String, Object>> dataList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pointshop);



//        处理转播页
        final ArrayList<View> aViews = new ArrayList<View>();
        LayoutInflater If = LayoutInflater.from(this);

        vg = (ViewGroup) If.inflate(R.layout.activity_pointshop, null);
        View v1 = If.inflate(R.layout.txt_img_show1, null);
        View v2 = If.inflate(R.layout.txt_img_show2, null);
        View v3 = If.inflate(R.layout.txt_img_show3, null);
        aViews.add(v1);
        aViews.add(v2);
        aViews.add(v3);
        try{
            vp = (ViewPager) vg.findViewById(R.id.pointsShopViewPager);
            ll = (LinearLayout) vg.findViewById(R.id.pointsShopGroup);

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


        listView = (ListView) findViewById(R.id.pointsShopListView);
        dataList = new ArrayList<Map<String, Object>>();
        simp_apater = new SimpleAdapter(this, getData(), R.layout.list_pointshop,
                new String[]{"pointsShopImage","pointsShopGoodsName","pointsShopGoodsPoint","pointsShopGoodsInfo","pointsShopGoodsButton"},
                new int[]{R.id.pointsShopImage,R.id.pointsShopGoodsName, R.id.pointsShopGoodsPoint, R.id.pointsShopGoodsInfo, R.id.pointsShopGoodsButton}){
            //在这个重写的函数里设置 每个 item 中按钮的响应事件
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                Button button=(Button)view.findViewById(R.id.pointsShopGoodsButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //警告框的写法
                        Intent it = new Intent(PointshopActivity.this, GoodsInfoActivity.class);
                        PointshopActivity.this.startActivity(it);
                    }
                });
                return view;
            }
        };

        listView.setAdapter(simp_apater);

        //must be careful the location
        initTitleBar();
        initSlidingMenu();
        initBottomBar();
    }

    public void initTitleBar(){
        top_head = (ImageView) findViewById(R.id.top_head_point_shop);
        top_more = (TextView) findViewById(R.id.top_more_point_shop);
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
                Intent it = new Intent(PointshopActivity.this, BillsActivity.class);
                PointshopActivity.this.startActivity(it);
            }
        });
    }

    protected void initSlidingMenu() {
        side_drawer = new DrawerView(this).initSlidingMenu();
    }


    public List<Map<String, Object>> getData(){
        for(int i = 0; i < 20l; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pointsShopImage",R.drawable.u112);
            map.put("pointsShopGoodsName","商品名称");
            map.put("pointsShopGoodsPoint","5000积分");
            map.put("pointsShopGoodsInfo","市场参考价：50￥");
            map.put("pointsShopGoodsButton","兑换");
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pointshop, menu);
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

    public void initBottomBar(){
        RelativeLayout toMain = (RelativeLayout) findViewById(R.id.points_shop_bottom_button_mainpage);
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PointshopActivity.this, MainActivity.class);
                PointshopActivity.this.startActivity(it);
            }
        });

        RelativeLayout toPush = (RelativeLayout) findViewById(R.id.points_shop_bottom_button_push);
        toPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PointshopActivity.this, OthersActivity.class);
                PointshopActivity.this.startActivity(it);
            }
        });

        RelativeLayout toQueationCenter = (RelativeLayout) findViewById(R.id.points_shop_bottom_button_questionnairecenter);
        toQueationCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(PointshopActivity.this, QuestionnaireCenterActivity.class);
                PointshopActivity.this.startActivity(it);
            }
        });
    }
}
