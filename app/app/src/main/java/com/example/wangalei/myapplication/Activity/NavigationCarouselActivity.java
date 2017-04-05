package com.example.wangalei.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.wangalei.myapplication.R;

public class NavigationCarouselActivity extends AppCompatActivity implements OnClickListener {
    private Button showdemo_welcome_1;
    private Button showdemo_welcome_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_carousel);
        showdemo_welcome_1 = (Button) findViewById(R.id.showdemo_welcome_1);
        showdemo_welcome_2 = (Button) findViewById(R.id.showdemo_welcome_2);
        showdemo_welcome_1.setText("普通的dialog，取消关闭dialog,确定关闭当前界面。");
        showdemo_welcome_1.setOnClickListener(this);
        showdemo_welcome_2.setText("Dialog中有一个列表，点击列表返回参数。");
        showdemo_welcome_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showdemo_dialog_1:
                welcome_1();
                break;
            case R.id.showdemo_dialog_2:
                welcome_2();
                break;
        }
    }

    protected void welcome_1() {
        Intent intent = new Intent(this,WelCome1Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//关掉所要到的界面中间的activity
        startActivity(intent);
    }

    protected void welcome_2() {
    }
}
