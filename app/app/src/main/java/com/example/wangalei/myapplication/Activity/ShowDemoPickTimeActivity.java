package com.example.wangalei.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.wangalei.myapplication.R;
import com.example.wangalei.myapplication.Widgets.PickTime.DatePickDialog;
import com.example.wangalei.myapplication.Widgets.PickTime.DateType;
import com.example.wangalei.myapplication.Widgets.PickTime.OnChangeLisener;
import com.example.wangalei.myapplication.Widgets.PickTime.OnSureLisener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.wangalei.myapplication.Utils.T.showShort;

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
        showdemo_picktime_1.setText("年-月-日-时-分(TYPE_ALL)");
        showdemo_picktime_1.setOnClickListener(this);
        showdemo_picktime_2.setText("年-月-日-时-分(TYPE_YMDHM)");
        showdemo_picktime_2.setOnClickListener(this);
        showdemo_picktime_3.setText("年-月-日-时(TYPE_YMDH)");
        showdemo_picktime_3.setOnClickListener(this);
        showdemo_picktime_4.setText("年-月-日(TYPE_YMD)");
        showdemo_picktime_4.setOnClickListener(this);
        showdemo_picktime_5.setText("时-分(TYPE_HM)");
        showdemo_picktime_5.setOnClickListener(this);
    }
    private void showDatePickDialog(DateType type) {
        DatePickDialog dialog = new DatePickDialog(this);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择时间");
        //设置类型
        dialog.setType(type);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(new OnChangeLisener() {
            @Override
            public void onChanged(Date date) {

            }
        });
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
                DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                showShort(getApplicationContext(),"点击确定"+dateformat.format(date));
            }
        });
        dialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showdemo_picktime_1:
                showDatePickDialog(DateType.TYPE_ALL);
                break;
            case R.id.showdemo_picktime_2:
                showDatePickDialog(DateType.TYPE_YMDHM);
                break;
            case R.id.showdemo_picktime_3:
                showDatePickDialog(DateType.TYPE_YMDH);
                break;
            case R.id.showdemo_picktime_4:
                showDatePickDialog(DateType.TYPE_YMD);
                break;
            case R.id.showdemo_picktime_5:
                showDatePickDialog(DateType.TYPE_HM);
                break;
        }
    }

}
