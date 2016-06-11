package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QDoneActivity extends Activity {

    public ListView listView_done;
    public List<Map<String, Object>> dataList_done;
    public SimpleAdapter simp_adapter_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qdone);



        listView_done = (ListView) findViewById(R.id.qCenter_done_listView);
        dataList_done = new ArrayList<Map<String, Object>>();
        simp_adapter_done = new SimpleAdapter(this, getDataDone(), R.layout.list_question_done,
                new String[]{"qCenter_done_qImage","qCenter_done_qName", "qCenter_done_qtype","qCenter_done_points","qCenter_done_money", "qCenter_done_state"},
                new int[]{R.id.qCenter_done_qImage,R.id.qCenter_done_qName, R.id.qCenter_done_qtype,R.id.qCenter_done_points, R.id.qCenter_done_money, R.id.qCenter_done_state});

        listView_done.setAdapter(simp_adapter_done);


    }

    public List<Map<String, Object>> getDataDone(){
        for(int i =0; i < 20; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("qCenter_done_qImage",R.drawable.u112);
            map.put("qCenter_done_qName","问卷名称");
            map.put("qCenter_done_qtype","问卷类型");
            map.put("qCenter_done_points","500");
            map.put("qCenter_done_money","50");
            map.put("qCenter_done_state","完成");
            dataList_done.add(map);
        }


        return dataList_done;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qdone, menu);
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
