package com.example.wangalei.myapplication.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.wangalei.myapplication.Fragment.ShowDemoTakePhotoforFragment;
import com.example.wangalei.myapplication.R;

public class ShowDemoTakePhotoforFragemntActivity extends FragmentActivity {
    ShowDemoTakePhotoforFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_demo_take_photofor_fragemnt);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment1,fragment=new ShowDemoTakePhotoforFragment(),"test");
        transaction.commit();
    }
    public void onClick(View v){
        fragment.onClick(v);
    }
}