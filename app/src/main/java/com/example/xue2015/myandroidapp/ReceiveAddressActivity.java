package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiveAddressActivity extends Activity {

    public ListView listview_address;
    public List<Map<String, Object>> dataList;
    public SimpleAdapter simp_adapter_address;
    public Button addNewAddress;
    public Button editAddress;
    public Button deleteAddress;
    public RadioButton defaultAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_receive_address);

        Titlebar tb = (Titlebar) findViewById(R.id.receiveAddressActionBar);
        TextView title = (TextView) findViewById(R.id.textAxtionBarTitle);
        title.setText("收货地址");
        tb.hideRight();

        listview_address = (ListView) findViewById(R.id.receiveAddressListView);
        dataList = new ArrayList<Map<String, Object>>();
        simp_adapter_address = new SimpleAdapter(this, getData(), R.layout.item_receive_address,
                new String[]{"receiveAddressName","receiveAddressPhoneNum","receiveAddressAddress","receiveAddressEditButtom","receiveAddressDeleteButtom","receiveAddressDefaultAddress"},
                new int[]{R.id.receiveAddressName,R.id.receiveAddressPhoneNum,R.id.receiveAddressAddress,R.id.receiveAddressEditButtom,R.id.receiveAddressDeleteButtom,R.id.receiveAddressDefaultAddress}
        ){
            //在这个重写的函数里设置 每个 item 中按钮的响应事件
            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                final int p=position;
                final View view=super.getView(position, convertView, parent);
                editAddress = (Button) view.findViewById(R.id.receiveAddressEditButtom);
                editAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        “编辑”事件触发，但是需求中没有指明
                    }
                });

                deleteAddress = (Button) view.findViewById(R.id.receiveAddressDeleteButtom);
                deleteAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        “删除”事件的触发
                    }
                });

                defaultAddress = (RadioButton) view.findViewById(R.id.receiveAddressDefaultAddress);
                defaultAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        “默认地址”事件的触发
                    }
                });


                return view;
            }
        };
        listview_address.setAdapter(simp_adapter_address);

        addNewAddress = (Button) findViewById(R.id.receiveAddressAddNewAddress);
        addNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                实现“添加新地址"事件的触发
                final AlertDialog alertDialog = new AlertDialog.Builder(ReceiveAddressActivity.this).create();//Builder直接create成AlertDialog
                alertDialog.show();//AlertDialog先得show出来，才能得到其Window
                final Window window = alertDialog.getWindow();//得到AlertDialog的Window
                window.setContentView(R.layout.alert_dialog_add_new_address);//给Window设置自定义布局
                View layout = LayoutInflater.from(ReceiveAddressActivity.this).inflate(R.layout.alert_dialog_add_new_address, null);//从xml中inflate过来
//              TextView dialogMsg = (TextView) window.findViewById(R.id.alert_dialog_message);//从Window中findView
                Button yes = (Button) window.findViewById(R.id.alertDialogAddAddressButtonYes);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击确定事件的触发
                        alertDialog.cancel();



                    }
                });

                Button no = (Button) window.findViewById(R.id.alertDialogAddAddressButtonNo);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击取消的事件
                        alertDialog.cancel();

                    }
                });
            }
        });


    }


    public List<Map<String, Object>> getData(){

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("receiveAddressName","王颀");
        map1.put("receiveAddressPhoneNum","18700000001");
        map1.put("receiveAddressAddress","北京市朝阳区望京悠乐汇d座31");
        map1.put("receiveAddressEditButtom","编辑");
        map1.put("receiveAddressDeleteButtom","删除");
        map1.put("receiveAddressDefaultAddress","默认地址");
        dataList.add(map1);

        for(int i = 0; i < 5; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("receiveAddressName","王颀");
            map.put("receiveAddressPhoneNum","18700000001");
            map.put("receiveAddressAddress","北京市朝阳区望京悠乐汇d座31");
            map.put("receiveAddressEditButtom","编辑");
            map.put("receiveAddressDeleteButtom","删除");
            map.put("receiveAddressDefaultAddress","");
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_receive_address, menu);
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
