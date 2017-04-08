package com.example.wangalei.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wangalei.myapplication.R;

public class ShowDemoTakePhotoActivity extends AppCompatActivity,TakePhotoActivity,TakePhotoFragmentActivity,TakePhotoFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_demo_take_photo);
    }
}
