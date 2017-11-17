package com.xkeshi.yunplugin;

import android.content.Context;

import java.io.File;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

/**
 * 加载dex文件工具类
 * Created by dell on 2017/11/16.
 */

public class DexUtil {

    /**
     * 加载dex文件并替换ClassLoader
     *
     * @param file
     * @param context
     */
    public static void loadDex(File file, Context context) {
        String optimizeDir = context.getDir("odex", Context.MODE_PRIVATE).getAbsolutePath() + File.separator + "opt_dex";
        File fopt = new File(optimizeDir);
        String targetFile = context.getDir("odex", Context.MODE_PRIVATE).getAbsolutePath() + File.separator
                + "temp.dex";
        FileUtil.copyFile(file.getPath(), targetFile);
        boolean isMake = false;
        if (!fopt.exists()) {
            isMake = fopt.mkdir();
        }
        DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(), fopt.getAbsolutePath(), null,
                context.getClassLoader().getParent());
        doDexInject(classLoader, context);
    }

    /**
     * 加载apk
     *
     * @param file
     * @param context
     */
    public static void loadApk(File file, Context context) {
        String optimizeDir = context.getDir("odex", Context.MODE_PRIVATE).getAbsolutePath() + File.separator + "opt_dex";
        File fopt = new File(optimizeDir);
        String targetFile = context.getDir("odex", Context.MODE_PRIVATE).getAbsolutePath() + File.separator
                + "temp.apk";
        FileUtil.copyFile(file.getPath(), targetFile);
        boolean isMake = false;
        if (!fopt.exists()) {
            isMake = fopt.mkdir();
        }
        DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(), fopt.getAbsolutePath(), null,
                context.getClassLoader().getParent());
        doDexInject(classLoader, context);
    }

    /**
     * 替换classLoader
     *
     * @param classLoader
     * @param context
     */
    private static void doDexInject(ClassLoader classLoader, Context context) {
        ClassLoader systemClassLoad = context.getClassLoader();
        try {
            setField(systemClassLoad, ClassLoader.class, "parent", classLoader);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过反射改变对象属性值
     *
     * @param obj
     * @param cl
     * @param field
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setField(Object obj, Class<?> cl, String field, Object value)
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        Field localField = cl.getDeclaredField(field);
        localField.setAccessible(true);
        localField.set(obj, value);
    }


}
