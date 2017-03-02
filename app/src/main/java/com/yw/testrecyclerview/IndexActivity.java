package com.yw.testrecyclerview;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yw.testrecyclerview.ui.MultiplePermissionActivity;
import com.yw.testrecyclerview.ui.PermissionActivity;
import com.yw.testrecyclerview.ui.TestAnimationViewActivity;
import com.yw.testrecyclerview.ui.TestMDActivity;
import com.yw.testrecyclerview.ui.TestNavigationDrawerActivity;
import com.yw.testrecyclerview.ui.TestRetrofitActivity;
import com.yw.testrecyclerview.ui.TestScrollingActivity;
import com.yw.testrecyclerview.ui.TestSnackActivity;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShareElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        initView();
    }

    private void initView() {
        findViewById(R.id.tv_Scrolling).setOnClickListener(this);
        findViewById(R.id.tv_tool_bar).setOnClickListener(this);
        findViewById(R.id.tv_permission_request).setOnClickListener(this);
        findViewById(R.id.tv_multiply_permission_request).setOnClickListener(this);
        findViewById(R.id.tv_navigation_drawer_request).setOnClickListener(this);
        findViewById(R.id.tv_recycler_footer).setOnClickListener(this);
        findViewById(R.id.tv_retrofit_testing).setOnClickListener(this);
        tvShareElement = (TextView) findViewById(R.id.tv_animation_view); //共享View
        tvShareElement.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_Scrolling:
                startActivity(new Intent(getApplicationContext(), TestScrollingActivity.class)); //Scrolling
                break;
            case R.id.tv_tool_bar:
                startActivity(new Intent(getApplicationContext(), TestMDActivity.class)); //TooBar
                break;
            case R.id.tv_permission_request:
                startActivity(new Intent(getApplicationContext(), PermissionActivity.class)); //
                break;
            case R.id.tv_multiply_permission_request:
                startActivity(new Intent(getApplicationContext(), MultiplePermissionActivity.class)); //
                break;
            case R.id.tv_navigation_drawer_request:
                startActivity(new Intent(getApplicationContext(), TestNavigationDrawerActivity.class)); //
                break;
            case R.id.tv_recycler_footer:
                startActivity(new Intent(getApplicationContext(), TestSnackActivity.class)); //
                break;
            case R.id.tv_retrofit_testing:
                startActivity(new Intent(getApplicationContext(), TestRetrofitActivity.class)); //
                break;
            case R.id.tv_animation_view:
                animToActivity();
                break;

        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void animToActivity() {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, tvShareElement, "share");
        startActivity(new Intent(getApplicationContext(), TestAnimationViewActivity.class), options.toBundle()); //
    }
}
