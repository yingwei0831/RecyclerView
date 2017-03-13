package com.yw.testrecyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.observer.SubjectFor3D;
import com.yw.testrecyclerview.observer.Observer1;
import com.yw.testrecyclerview.observer.Observer2;
import com.yw.testrecyclerview.observer.SubjectForSSQ;

/**
 * launchMode = singleTask
 * 系统已经存在一个实例，系统就会将请求发送到这个实例上，但这个时候----------系统就不会再调用onCreate方法，而是调用onNewIntent方法
 */
public class ObserverActivity extends BaseActivity {

    public void testObserver(View view){
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();

        Observer1 observer1 = new Observer1();
        observer1.registerSubject(subjectFor3D);
        observer1.registerSubject(subjectForSSQ);

        subjectFor3D.setMsg("hello 3d'nums : 110");
        subjectForSSQ.setMsg("ssq'nums : 12,13,31,5,4,3 15");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_observer;
    }

    @Override
    public Object newP() {
        return null;
    }
}
