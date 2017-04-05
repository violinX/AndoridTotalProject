package com.example.wangalei.myapplication.Utils;

/**
 * Created by JD on 2017/4/5.
 */

public class UtilsPublicStaticValues {
    //应用公共变量定义，***注意务必添加备注说明
    public static Boolean isExit = false;//用于点击两次返回退出页面，默认为false；若默认为true则此功能作废。
    public static final String TAG = "App Project Log";//log工具类输出时默认TAG
    public static boolean isDebug = true;//log工具类输出时默认允许输出，如果为false则不输出
    public static boolean isShow = true;//Toast工具类输出控制，当为false是将关闭所有调用工具类的Toast提示
    public static final String FILE_NAME = "share_data";//SharedPreferences写入本地文件默认文件名

}
