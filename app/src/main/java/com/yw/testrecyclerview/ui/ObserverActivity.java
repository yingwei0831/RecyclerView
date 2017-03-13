package com.yw.testrecyclerview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.observer.ObjectFor3D;
import com.yw.testrecyclerview.observer.Observer1;
import com.yw.testrecyclerview.observer.Observer2;

public class ObserverActivity extends BaseActivity {

    public void testObserver(View view){
        ObjectFor3D objectFor3D = new ObjectFor3D();
        Observer1 observer1 = new Observer1(objectFor3D);
        Observer2 observer2 = new Observer2(objectFor3D);
        objectFor3D.setMsg("20170313的3D号码是：150");
        objectFor3D.setMsg("20170314的3D号码是：507");
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
