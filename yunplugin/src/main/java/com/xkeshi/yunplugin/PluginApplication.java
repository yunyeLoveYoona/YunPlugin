package com.xkeshi.yunplugin;

import android.app.Application;

import java.io.File;

/**
 * 插件化application
 * Created by dell on 2017/11/16.
 */

public abstract class PluginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        File file = getDexFile();
        if (file != null) {
            DexUtil.loadDex(file, this);
        }

    }

    /**
     * 获取dex文件
     *
     * @return
     */
    public abstract File getDexFile();
}
