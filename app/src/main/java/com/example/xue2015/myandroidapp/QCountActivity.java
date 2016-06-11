package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
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


public class QCountActivity extends Activity {
    public ListView listView_count;
    public List<Map<String, Object>> dataList_count;
    public SimpleAdapter simp_adapter_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qcount);

        listView_count = (ListView) findViewById(R.id.qCenter_count_listView);
        dataList_count = new ArrayList<Map<String, Object>>();
        simp_adapter_count = new SimpleAdapter(this, getDataCount(), R.layout.list_question_count,
                new String[]{"qCenter_count_image","qCenter_count_state", "qCenter_count_points",},
                new int[]{R.id.qCenter_count_image,R.id.qCenter_count_state, R.id.qCenter_count_points});

        listView_count.setAdapter(simp_adapter_count);
    }

    public List<Map<String, Object>> getDataCount(){
        for(int i =0; i < 3; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("qCenter_count_image",R.drawable.u543);
            map.put("qCenter_count_state","已完成的问卷");
            map.put("qCenter_count_points","88888");
            dataList_count.add(map);
        }

        return dataList_count;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qcount, menu);
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
