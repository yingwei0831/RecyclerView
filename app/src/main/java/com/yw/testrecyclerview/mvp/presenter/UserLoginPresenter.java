package com.yw.testrecyclerview.mvp.presenter;

import android.os.Handler;

import com.yw.testrecyclerview.mvp.model.bean.UserBean;
import com.yw.testrecyclerview.mvp.model.biz.ILoginBiz;
import com.yw.testrecyclerview.mvp.model.biz.OnLoginListener;
import com.yw.testrecyclerview.mvp.model.biz.impl.LoginBiz;
import com.yw.testrecyclerview.mvp.view.IUserLoginView;


/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public class UserLoginPresenter implements OnLoginListener {

//    presenter完成二者的交互，那么肯定需要二者的实现类。
// 大致就是从View中获取需要的参数，交给Model去执行业务方法，执行的过程中需要的反馈，以及结果，再让View进行做对应的显示

    private ILoginBiz userBiz;
    private IUserLoginView userLoginView;

    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new LoginBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), this);
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

    @Override
    public void loginSuccess(final UserBean user) {
        //需要在UI线程执行
        handler.post(new Runnable() {
            @Override
            public void run() {
                userLoginView.toMainActivity(user);
                userLoginView.hideLoading();
            }
        });

    }

    @Override
    public void loginFailed() {
        //需要在UI线程执行
        handler.post(new Runnable() {
            @Override
            public void run() {
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });

    }
}
