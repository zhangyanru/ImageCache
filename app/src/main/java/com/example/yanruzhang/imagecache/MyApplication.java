package com.example.yanruzhang.imagecache;

import android.app.Application;

/**
 * Created by yanru.zhang on 16/8/18.
 * Email:yanru.zhang@renren-inc.com
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getContext(){
        return myApplication;
    }
}
