package com.yw.testrecyclerview.observer;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jiahe008_lvlanlan on 2017/3/13.
 *
 * 模拟使用者
 */
public class Observer1 implements Observer {

    private static final String TAG = "Observer1";

    public void registerSubject(Observable observable){
        //

    }

    @Override
    public void update(Observable observable, Object o) {

//        Log.e(TAG, "observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }


}
