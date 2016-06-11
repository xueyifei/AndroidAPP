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

public class MyPointsSpendingActivity extends Activity {

    public ListView listView_spending;
    public List<Map<String, Object>> dataList;
    public SimpleAdapter simp_adapter_spending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_points_spending);

        listView_spending = (ListView) findViewById(R.id.mypointsSpendingListView);
        dataList = new ArrayList<Map<String, Object>>();
        simp_adapter_spending = new SimpleAdapter(this, getDataProfit(), R.layout.item_mypoint_spending,
                new String[]{"mypointsSpendingDate","mypointsSpendingUse","mypointsSpendingProfit"},
                new int[]{R.id.mypointsSpendingDate, R.id.mypointsSpendingUse, R.id.mypointsSpendingProfit});

        listView_spending.setAdapter(simp_adapter_spending);
    }

    public List<Map<String, Object>> getDataProfit(){

        for(int i = 0; i < 8; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("mypointsSpendingDate","2015-06-01");
            map.put("mypointsSpendingUse","积分兑换");
            map.put("mypointsSpendingProfit","-200积分");
            dataList.add(map);
        }

        return dataList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_points_spending, menu);
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
