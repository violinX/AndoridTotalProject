package com.example.wangalei.myapplication.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangalei.myapplication.R;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private RelativeLayout login_layout;
    private ImageView login_logo;
    private TextView tv_GoDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        login_layout = (RelativeLayout) findViewById(R.id.login_layout);
        login_logo = (ImageView) findViewById(R.id.login_logo);
        tv_GoDemo = (TextView) findViewById(R.id.tv_GoDemo);
        tv_GoDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_GoDemo:
                Intent intent=new Intent(LoginActivity.this, NavigationCarouselActivity.class);
                startActivity(intent);
                break;
        }
    }
}
