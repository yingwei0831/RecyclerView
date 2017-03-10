package com.yw.testrecyclerview.xdroidmvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.IView;

/**
 *
 */
public class TestXdroidMVPActivity extends BaseActivity {



    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_xdroid_mvp;
    }

    @Override
    public Object newP() {
        return null;
    }

    @OnClick({R.id.btn_request1, R.id.btn_clear1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request1:
                request();
                break;
            case R.id.btn_clear1:
                clear();
                break;
        }
    }

    @Override
    public boolean useEventBus() {
        return super.useEventBus();
    }


    private void request() {

    }

    private void clear() {

    }
}
