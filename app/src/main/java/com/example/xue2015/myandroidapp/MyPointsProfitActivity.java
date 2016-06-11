package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPointsProfitActivity extends Activity {

    public ListView listView_profit;
    public List<Map<String, Object>> dataList;
    public SimpleAdapter simp_adapter_profit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_poing_profit);

        listView_profit = (ListView) findViewById(R.id.mypointsProfitListView);
        dataList = new ArrayList<Map<String, Object>>();
        simp_adapter_profit = new SimpleAdapter(this, getDataProfit(), R.layout.item_mypoint_profit,
                new String[]{"mypointsProfitDate","mypointsProfitComefrom","mypointsProfitProfit"},
                new int[]{R.id.mypointsProfitDate, R.id.mypointsProfitComefrom, R.id.mypointsProfitProfit});

        listView_profit.setAdapter(simp_adapter_profit);

    }

    public List<Map<String, Object>> getDataProfit(){

        for(int i = 0; i < 8; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("mypointsProfitDate","2015-06-01");
            map.put("mypointsProfitComefrom","问卷");
            map.put("mypointsProfitProfit","+200积分");
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_poing_profit, menu);
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
