package com.xkeshi.yunplugintest;

import android.os.Environment;

import com.xkeshi.yunplugin.PluginApplication;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dell on 2017/11/16.
 */

public class MyApplication extends PluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public ArrayList<File> getDexFiles() {
        ArrayList<File> files = new ArrayList<File>();
        //  files.add(new File(Environment.getExternalStorageDirectory() + "/classes.dex"));
        return files;
    }

    @Override
    public ArrayList<File> getApkFiles() {
        ArrayList<File> files = new ArrayList<File>();
        files.add(new File(Environment.getExternalStorageDirectory() + "/app-debug.apk"));
        return files;
    }


}
