package com.example.xue2015.myandroidapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyQuestionFriendsActivity extends Activity {

    public ListView listview_friends;
    public SimpleAdapter simp_adapter_friends;
    public List<Map<String, Object>> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_question_friends);

        Titlebar tb = (Titlebar) findViewById(R.id.myQuestionFriendsActionBar);
        TextView title = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        title.setText("我的问友");

        //感觉这里需要对“返回”的点击事件进行重写，但是我暂时没写

        Button right = (Button) tb.findViewById(R.id.buttonActionBarRight);
        right.setText("二维码");
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到“二维码邀请”
                Intent toQRCode = new Intent(MyQuestionFriendsActivity.this, QRCodeActivity.class);
                MyQuestionFriendsActivity.this.startActivity(toQRCode);
            }
        });

        listview_friends =(ListView) findViewById(R.id.myQuestionFriendsListView);
        dataList = new ArrayList<Map<String, Object>>();
        simp_adapter_friends = new SimpleAdapter(this, getDataList(), R.layout.item_question_friends,
                new String[]{"myQuestionFriendsImage","myQuestionFriendsName","myQuestionFriendsCity","myQuestionFriendsSex","myQuestionFriendsSendPoints"},
                new int[]{R.id.myQuestionFriendsImage, R.id.myQuestionFriendsName,R.id.myQuestionFriendsCity, R.id.myQuestionFriendsSex, R.id.myQuestionFriendsSendPoints}){
            //在这个重写的函数里设置 每个 item 中按钮的响应事件
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                final Button button=(Button)view.findViewById(R.id.myQuestionFriendsSendPoints);
                button.setOnClickListener(new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v) {
                        button.setBackground(getResources().getDrawable(R.drawable.round_corner_gray));
                        button.setText("已赠送");
                        Toast.makeText(getApplicationContext(), "感谢您赠送了好友1点积分\n\t\t您今天还可以赠送\n\t\t\t\t(1/30)", Toast.LENGTH_LONG).show();
                    }
                });
                return view;
            }


        };

        listview_friends.setAdapter(simp_adapter_friends);

    }

    public List<Map<String, Object>> getDataList(){
        for(int i = 0; i < 20; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("myQuestionFriendsImage",R.drawable.u112);
            map.put("myQuestionFriendsName","Name");
            map.put("myQuestionFriendsCity","北京");
            map.put("myQuestionFriendsSex","男");
            map.put("myQuestionFriendsSendPoints","赠送积分");
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_question_friends, menu);
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
