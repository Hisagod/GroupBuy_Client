package com.example.cniaotuan;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.blankj.utilcode.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.yolanda.nohttp.NoHttp;

/**
 * Created by hongkl on 16/8/1.
 */
public class MyApplication extends Application {
    private boolean flag = true;

    @Override
    public void onCreate() {

        super.onCreate();
        //NoHttp初始化配置
        NoHttp.initialize(this);

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        //Fresco图片加载框架初始化
        Fresco.initialize(this);

        //bmob的初始化
//        Bmob.initialize(this, "555b31ec65459cd361ea36884fb733f7");

        if (flag == true) {
            flag = false;
//            BmobUpdateAgent.initAppVersion();
        }

        initUtils();
    }

    private void initUtils() {
        Utils.init(this);
    }
}
