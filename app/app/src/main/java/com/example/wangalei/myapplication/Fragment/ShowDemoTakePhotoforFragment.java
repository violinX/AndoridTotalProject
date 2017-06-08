package com.example.wangalei.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangalei.myapplication.Activity.ShowDemoTakePhotoResultActivity;
import com.example.wangalei.myapplication.R;
import com.example.wangalei.myapplication.TakePhotoUtils.TakePhotoCustomHelper;
import com.jph.takephoto.app.TakePhotoFragment;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;


public class ShowDemoTakePhotoforFragment extends TakePhotoFragment {
    private TakePhotoCustomHelper customHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_takephoto_common_layout, null);
        customHelper = TakePhotoCustomHelper.of(view);
        return view;
    }

    public void onClick(View view) {
        customHelper.onClick(view, getTakePhoto());
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
        Intent intent = new Intent(getContext(), ShowDemoTakePhotoResultActivity.class);
        intent.putExtra("images", images);
        startActivity(intent);
    }
}