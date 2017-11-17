package com.xkeshi.yunplugin.activity;

/**
 * Created by dell on 2016/8/1.
 */
public class Remote {

    public static Object get(String className) {
        try {
            Class objClass = Class.forName(className);
            return objClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
