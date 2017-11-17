package com.xkeshi.yunplugintest;

import android.app.Application;
import android.os.Environment;

import com.xkeshi.yunplugin.DexUtil;
import com.xkeshi.yunplugin.PluginApplication;

import java.io.File;

/**
 * Created by dell on 2017/11/16.
 */

public class MyApplication extends PluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public File getDexFile() {
        return new File(Environment.getExternalStorageDirectory() + "/classes.dex");
    }
}
