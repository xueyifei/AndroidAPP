package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QDoingActivity extends Activity {
    public ListView listView_doing;
    public List<Map<String, Object>> dataList_doing;
    public SimpleAdapter simp_adapter_doing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_qdoing);

        listView_doing = (ListView) findViewById(R.id.qCenter_doing_listView);
        dataList_doing = new ArrayList<Map<String, Object>>();
        simp_adapter_doing = new SimpleAdapter(this, getDataDoing(), R.layout.list_question_doing,
                new String[]{"qCenter_doing_qImage","qCenter_doing_qName", "qCenter_doing_qtype","qCenter_doing_points","qCenter_doing_qState", "qCenter_doing_goOn"},
                new int[]{R.id.qCenter_doing_qImage,R.id.qCenter_doing_qName, R.id.qCenter_doing_qtype,R.id.qCenter_doing_points, R.id.qCenter_doing_qState, R.id.qCenter_doing_goOn}){
            //在这个重写的函数里设置 每个 item 中按钮的响应事件
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                Button button=(Button)view.findViewById(R.id.qCenter_doing_goOn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent it = new Intent(QDoingActivity.this, QAnswerActivity.class);
                        QDoingActivity.this.startActivity(it);
                    }
                });
                return view;
            }
        };

        listView_doing.setAdapter(simp_adapter_doing);
    }


    public List<Map<String, Object>> getDataDoing(){

        for(int i =0; i < 20; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("qCenter_doing_qImage",R.drawable.u112);
            map.put("qCenter_doing_qName","问卷名称");
            map.put("qCenter_doing_qtype","问卷类型");
            map.put("qCenter_doing_points","500");
            map.put("qCenter_doing_qState","0/100");
            map.put("qCenter_doing_goOn","继续");
            dataList_doing.add(map);
        }

        return dataList_doing;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_qdoing, menu);
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
