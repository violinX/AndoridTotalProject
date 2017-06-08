package com.example.wangalei.myapplication.Utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by wangalei on 2017/4/5.
 * SD卡相关辅助类
 */

public class UtilsSDCard {
    private UtilsSDCard()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断SDCard是否可用
     *
     * @return
     */
    public static boolean isSDCardEnable()
    {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);

    }

    /**
     * 获取SD卡路径
     *
     * @return
     */
    public static String getSDCardPath()
    {
        return Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator;
    }

    /**
     * 获取SD卡的剩余容量 单位byte
     *
     * @return
     */
    public static long getSDCardAllSize()
    {
        if (isSDCardEnable())
        {
            StatFs stat = new StatFs(getSDCardPath());
            // 获取空闲的数据块的数量
            long availableBlocks = (long) stat.getAvailableBlocks() - 4;
            // 获取单个数据块的大小（byte）
            long freeBlocks = stat.getAvailableBlocks();
            return freeBlocks * availableBlocks;
        }
        return 0;
    }

    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte
     *
     * @param filePath
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    public static long getFreeBytes(String filePath)
    {
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        if (filePath.startsWith(getSDCardPath()))
        {
            filePath = getSDCardPath();
        } else
        {// 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath();
        }
        StatFs stat = new StatFs(filePath);
        long availableBlocks = (long) stat.getAvailableBlocks() - 4;
        return stat.getBlockSize() * availableBlocks;
    }

    /**
     * 获取系统存储路径
     *
     * @return
     */
    public static String getRootDirectoryPath()
    {
        return Environment.getRootDirectory().getAbsolutePath();
    }
    /**
     * 在SD卡的根目录建立对应文件夹
     * @return
     */
    public static String getExternalStorageDirectory()
    {
        File sdCard = Environment.getExternalStorageDirectory();
        File directory_pictures = new File(sdCard, "Alei_Application");
        return directory_pictures.getAbsolutePath();
    }
    /**
     * App专属文件，卸载时会一起删除
     * 手机自带的存储空间，空间可能存在比较小的问题，主要存放必须的文件更合适
     * 注意，需要传递上下文为参数使用
     * @return
     */
    public static String getFilesDir(Context context)
    {
        File filesDir = context.getFilesDir();
        return filesDir.getAbsolutePath();
    }
    /**
     * App专属文件，卸载时会一起删除
     * 手机SD的存储空间，SD卡可能会存在不存等问题，使用时注意先搬段是否存在SD卡,目录下文件夹名称可以自己指定
     * 注意，需要传递上下文为参数使用，也可以传递新建的目录下文件夹名称
     * @return
     */
    public static String getExternalFilesDir(Context context,String filename)
    {
        File externalFilesDir = context.getExternalFilesDir(filename);
        return externalFilesDir.getAbsolutePath();
    }
    public static String getExternalFilesDir(Context context)
    {
        File externalFilesDir = context.getExternalFilesDir(null);
        return externalFilesDir.getAbsolutePath();
    }




}
