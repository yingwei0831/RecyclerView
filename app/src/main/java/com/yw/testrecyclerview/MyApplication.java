package com.yw.testrecyclerview;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

import butterknife.ButterKnife;

/**
 * Created by jiahe008_lvlanlan on 2017/3/1.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize().init(this);
        ButterKnife.setDebug(true);
    }
}
