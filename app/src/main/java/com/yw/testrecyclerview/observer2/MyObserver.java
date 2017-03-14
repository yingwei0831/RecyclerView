package com.yw.testrecyclerview.observer2;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jiahe008_lvlanlan on 2017/3/14.
 *
 * 观察者
 * 单一任务：观察者接受到通知后，调用update方法进行更新操作
 */
public class MyObserver implements Observer {

    private static final String TAG = "MyObserver";

    private int id;
    private MyPerson myPerson;

    public MyObserver(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyPerson getMyPerson() {
        return myPerson;
    }

    public void setMyPerson(MyPerson myPerson) {
        this.myPerson = myPerson;
    }

    @Override
    public void update(Observable observable, Object o) {
        this.myPerson = (MyPerson) observable;
        Log.e(TAG, myPerson.toString());
    }

    @Override
    public String toString() {
        return "MyObserver{" +
                "id=" + id +
                ", myPerson=" + myPerson +
                '}';
    }
}
