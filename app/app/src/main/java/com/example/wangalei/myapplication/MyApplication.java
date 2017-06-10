package com.example.wangalei.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.wangalei.myapplication.GreenDao.GreenDaoManager;

import org.xutils.x;

/**
 * Created by wangalei on 2017/4/5.
 */
public class MyApplication extends Application {
    private static Context mContext;



    @Override
    public void onCreate() {
        super.onCreate();
        //初始化XUtils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        mContext = getApplicationContext();
        GreenDaoManager.getInstance();
    }
    public static Context getContext() {
        return mContext;
    }
}
