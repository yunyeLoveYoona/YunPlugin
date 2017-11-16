package com.xkeshi.yunplugintest;

import android.app.Application;
import android.os.Environment;

import com.xkeshi.yunplugin.DexUtil;

import java.io.File;

/**
 * Created by dell on 2017/11/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DexUtil.loadDex(new File(Environment.getExternalStorageDirectory() + "/classes.dex"), this);
        ClassLoader classLoader = getClassLoader();
        try {
            Class c = classLoader.loadClass("com.xkeshi.yunplugintest.A");
            Object o = c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
