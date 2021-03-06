package com.example.wangalei.myapplication.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.wangalei.myapplication.R;
import com.example.wangalei.myapplication.Utils.UtilsSDCard;
import com.jph.takephoto.app.TakePhotoActivity;

import java.io.File;

/**
 * - 支持通过相机拍照获取图片
 * - 支持从相册选择图片
 * - 支持从文件选择图片
 * - 支持多图选择
 * - 支持批量图片裁切
 * - 支持批量图片压缩
 * - 支持对图片进行压缩
 * - 支持对图片进行裁剪
 * - 支持对裁剪及压缩参数自定义
 * - 提供自带裁剪工具(可选)
 * - 支持智能选取及裁剪异常处理
 * - 支持因拍照Activity被回收后的自动恢复
 * Author: crazycodeboy
 * Date: 2016/9/21 0007 20:10
 * Version:4.0.0
 * 技术博文：http://www.cboy.me
 * GitHub:https://github.com/crazycodeboy
 * Eamil:crazycodeboy@gmail.com
 */
public class ShowDemoTakePhotoActivity extends TakePhotoActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_demo_take_photo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnTakePhotoActivity:
                startActivity(new Intent(this,ShowDemoTakePhotoforActivity.class));
                break;
            case R.id.btnTakePhotoFragment:
                startActivity(new Intent(this,ShowDemoTakePhotoforFragemntActivity.class));
                break;
            case R.id.btnTakePhoto:
                File file=new File(UtilsSDCard.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
                if (!file.getParentFile().exists())file.getParentFile().mkdirs();
                Uri imageUri = Uri.fromFile(file);
                getTakePhoto().onPickFromCapture(imageUri);
                break;
            default:
        }
    }
}