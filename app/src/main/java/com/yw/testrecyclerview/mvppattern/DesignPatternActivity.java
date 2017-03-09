package com.yw.testrecyclerview.mvppattern;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.mvppattern.model.bean.UserBean;
import com.yw.testrecyclerview.mvppattern.presenter.UserLoginPresenter;
import com.yw.testrecyclerview.mvppattern.view.IUserLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVP设计模式
 * ButterKnife注解
 */
public class DesignPatternActivity extends AppCompatActivity implements IUserLoginView{


    @BindView(R.id.acet_name)
    TextInputEditText acetName;
    @BindView(R.id.acet_password)
    TextInputEditText acetPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_pattern);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_clear:
                clear();
                break;
        }
    }

    private void clear() {
        presenter.clear();
    }

    private void login() {
        presenter.login();
    }

    @Override
    public String getUserName() {
        return acetName.getText().toString();
    }

    @Override
    public String getPassword() {
        return acetPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean user) {
        Toast.makeText(getApplicationContext(), user.getName() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        acetName.setText("");
    }

    @Override
    public void clearPassword() {
        acetPassword.setText("");
    }
}
