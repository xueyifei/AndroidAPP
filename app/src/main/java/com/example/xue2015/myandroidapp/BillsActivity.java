package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillsActivity extends Activity {

    private ListView listView;
    private SimpleAdapter simp_adapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bills);

        Titlebar tb = (Titlebar) findViewById(R.id.billsTitleBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        title.setText("账单明细");
        tb.hideRight();

        listView = (ListView) findViewById(R.id.listView);
        dataList = new ArrayList<Map<String, Object>>();

        // simpleAdapter
        simp_adapter = new SimpleAdapter(this, getData(), R.layout.list_bills, new String[]{"goodsImage","goodsName", "goodsPoints"}, new int[]{R.id.goodsImage,R.id.goodsName, R.id.goodsPoints });
        listView.setAdapter(simp_adapter);
    }

    public List<Map<String, Object>> getData(){

        for(int i = 0; i < 20; i++){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("goodsImage",R.drawable.u112);
            map.put("goodsName", "商品名称");
            map.put("goodsPoints","-5000积分");
            dataList.add(map);
        }

        return dataList;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bills, menu);
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
