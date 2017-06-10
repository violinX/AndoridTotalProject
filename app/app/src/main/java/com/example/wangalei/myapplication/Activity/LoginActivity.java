package com.example.wangalei.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wangalei.myapplication.R;
import com.example.wangalei.myapplication.Utils.UtilsPublicStaticValues;
import com.example.wangalei.myapplication.Utils.UtilsScreen;

import static com.example.wangalei.myapplication.Utils.UtilsSharedPreferences.get;
import static com.example.wangalei.myapplication.Utils.L.v;
import static com.example.wangalei.myapplication.Utils.T.showShort;
import static com.example.wangalei.myapplication.Utils.UtilsSharedPreferences.put;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private RelativeLayout login_layout;
    private ImageView login_logo;
    private TextView tv_GoDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        showShort(this, UtilsScreen.getScreenHeight(this)+"");
        put(this,"start","一次简单的数据写入测试");
        v(get(this,"start","")+"");
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
                Intent intent=new Intent(LoginActivity.this, ShowDemoGreenDaoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//关掉所要到的界面中间的activity
                startActivity(intent);
                break;
        }
    }

    //region 点击两次返回退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!UtilsPublicStaticValues.isExit) {
            UtilsPublicStaticValues.isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            UtilsPublicStaticValues.isExit = false;
        }
    };
    //endregion
}
