package com.example.wangalei.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.wangalei.myapplication.R;
import com.example.wangalei.myapplication.TakePhotoUtils.TakePhotoCustomHelper;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;

public class ShowDemoTakePhotoforActivity extends TakePhotoActivity {
    private TakePhotoCustomHelper customHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView= LayoutInflater.from(this).inflate(R.layout.activity_takephoto_common_layout,null);
        setContentView(contentView);
        customHelper=TakePhotoCustomHelper.of(contentView);
    }

    public void onClick(View view) {
        customHelper.onClick(view,getTakePhoto());
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());
    }

    private void showImg(ArrayList<TImage> images) {
        Intent intent=new Intent(this,ShowDemoTakePhotoResultActivity.class);
        intent.putExtra("images",images);
        startActivity(intent);
    }
}