package com.yw.testrecyclerview.mvp.model.biz.impl;

import com.yw.testrecyclerview.mvp.model.bean.UserBean;
import com.yw.testrecyclerview.mvp.model.biz.ILoginBiz;
import com.yw.testrecyclerview.mvp.model.biz.OnCallbackListener;

/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public class LoginBiz implements ILoginBiz {

    @Override
    public void login(final String username, final String password, final OnCallbackListener loginListener) {
        //模拟网络请求
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("admin".equals(username) && "123456".equals(password)){
                    UserBean user = new UserBean();
                    user.setName(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
