package com.example.wangalei.myapplication.Utils;

import android.util.Log;

/**
 * Created by Wangalei on 2017/4/5.
 * log输出工具类
 * 颜色备注：
 * i：绿色
 * d:蓝色
 * e:红色
 * v:黑色
 * w:黄色
 */

public class L {
    private L()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static boolean isDebug = UtilsPublicStaticValues.isDebug ;
    private static final String TAG = UtilsPublicStaticValues.TAG;

    // 下面五个是默认tag的函数
    public static void i(String msg)
    {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg)
    {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg)
    {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg)
    {
        if (isDebug)
            Log.v(TAG, msg);
    }
    public static void w(String msg)
    {
        if (isDebug)
            Log.w(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            Log.v(tag, msg);
    }
    public static void w(String tag, String msg)
    {
        if (isDebug)
            Log.w(tag, msg);
    }
}
