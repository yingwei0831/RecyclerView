package com.yw.testrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yw.testrecyclerview.ui.MultiplePermissionActivity;
import com.yw.testrecyclerview.ui.PermissionActivity;
import com.yw.testrecyclerview.ui.TestMDActivity;
import com.yw.testrecyclerview.ui.TestScrollingActivity;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

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
                startActivity(new Intent(getApplicationContext(), PermissionActivity.class)); //TooBar
                break;
            case R.id.tv_multiply_permission_request:
                startActivity(new Intent(getApplicationContext(), MultiplePermissionActivity.class)); //TooBar
                break;
        }
    }
}