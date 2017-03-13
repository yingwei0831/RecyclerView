package com.yw.testrecyclerview.observer;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jiahe008_lvlanlan on 2017/3/13.
 *
 * 观察者
 */
public class Observer2 implements Observer {

    private static final String TAG = "Observer2";

    /**
     * 注册被观察者
     * @param observable
     */
    private void registerSubject(Observable observable){
        observable.addObserver(this);
    }


    @Override
    public void update(Observable observable, Object o) {
        Log.e(TAG, "update");
        if (observable instanceof SubjectFor3D){
            SubjectFor3D subjectFor3D = (SubjectFor3D) observable;
            Log.e(TAG, "subjectFor3D's msg -- >" + subjectFor3D.getMsg());
        }else if (observable instanceof SubjectForSSQ){
            SubjectForSSQ subjectForSSQ = (SubjectForSSQ) observable;
            Log.e(TAG, "subjectForSSQ's msg -- >" + subjectForSSQ.getMsg());
        }
    }

}
