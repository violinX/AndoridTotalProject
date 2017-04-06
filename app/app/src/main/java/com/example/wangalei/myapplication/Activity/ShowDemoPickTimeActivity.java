package com.example.wangalei.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.wangalei.myapplication.R;

public class ShowDemoPickTimeActivity extends AppCompatActivity implements OnClickListener {
    private Button showdemo_picktime_1;
    private Button showdemo_picktime_2;
    private Button showdemo_picktime_3;
    private Button showdemo_picktime_4;
    private Button showdemo_picktime_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_demo_pick_time);
        showdemo_picktime_1 = (Button) findViewById(R.id.showdemo_picktime_1);
        showdemo_picktime_2 = (Button) findViewById(R.id.showdemo_picktime_2);
        showdemo_picktime_3 = (Button) findViewById(R.id.showdemo_picktime_3);
        showdemo_picktime_4 = (Button) findViewById(R.id.showdemo_picktime_4);
        showdemo_picktime_5 = (Button) findViewById(R.id.showdemo_picktime_5);
        showdemo_picktime_1.setText("普通的dialog，取消关闭dialog,确定关闭当前界面。");
        showdemo_picktime_1.setOnClickListener(this);
        showdemo_picktime_2.setText("Dialog中有一个列表，点击列表返回参数。");
        showdemo_picktime_2.setOnClickListener(this);
        showdemo_picktime_3.setText("Dialog中单选列表，默认选中第三项。");
        showdemo_picktime_3.setOnClickListener(this);
        showdemo_picktime_4.setText("Dialog中多选列表，list记录多选值。");
        showdemo_picktime_4.setOnClickListener(this);
        showdemo_picktime_5.setText("这是一个阻止了屏幕点击的等待事件。");
        showdemo_picktime_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showdemo_picktime_1:

                break;
            case R.id.showdemo_picktime_2:

                break;
            case R.id.showdemo_picktime_3:

                break;
            case R.id.showdemo_picktime_4:

                break;
            case R.id.showdemo_picktime_5:

                break;

        }
    }

}
