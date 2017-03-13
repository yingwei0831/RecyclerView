package com.yw.testrecyclerview.observer;

import android.util.Log;

/**
 * Created by jiahe008_lvlanlan on 2017/3/13.
 */
public class Observer2 implements Observer {

    private static final String TAG = "Observer2";

    private Subject subject;

    public Observer2(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        Log.e(TAG, "observer2 得到 3D 号码 -->" + msg + "，我要告诉舍友们。");
    }

}
