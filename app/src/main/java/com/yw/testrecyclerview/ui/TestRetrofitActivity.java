package com.yw.testrecyclerview.ui;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;

import butterknife.BindView;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

public class TestRetrofitActivity extends BaseActivity {

    private static final String TAG = "TestRetrofitActivity";

//    @BindView(R.id.button_send_request)
//    Button btnRequest;

    @OnClick({R.id.button_send_request})
    public void clickEvent(){
        retrofitMethod();
    }

    private void retrofitMethod() {
        Log.e(TAG, "----retrofitMethod----");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_retrofit;
    }

    @Override
    public Object newP() {
        return null;
    }

}
