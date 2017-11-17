package com.xkeshi.yunplugin;

import android.app.Application;

import java.io.File;
import java.util.ArrayList;

/**
 * 插件化application
 * Created by dell on 2017/11/16.
 */

public abstract class PluginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ArrayList<File> files = getDexFiles();
        if (files != null) {
            for (File file : files)
                DexUtil.loadDex(file, this);
        }
        ArrayList<File> apks = getApkFiles();
        if (apks != null) {
            for (File file : apks)
                DexUtil.loadApk(file, this);
        }

    }

    /**
     * 获取dex文件
     *
     * @return
     */
    public abstract ArrayList<File> getDexFiles();

    /**
     * 获取apk文件
     *
     * @return
     */
    public abstract ArrayList<File> getApkFiles();
}
