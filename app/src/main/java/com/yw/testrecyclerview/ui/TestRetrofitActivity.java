package com.yw.testrecyclerview.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.retrofitutils.RetrofitUtil;

import butterknife.BindView;
import butterknife.OnClick;


public class TestRetrofitActivity extends BaseActivity {

    private static final String TAG = "TestRetrofitActivity";

    @BindView(R.id.button_send_request)
    Button buttonSendRequest;

    @OnClick({R.id.button_send_request})
    public void clickEvent(View view){
        switch (view.getId()){
            case R.id.button_send_request:
                retrofitMethod();
                break;

        }
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
