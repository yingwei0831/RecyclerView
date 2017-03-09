package com.yw.testrecyclerview.mvp.view;

import com.yw.testrecyclerview.mvp.model.bean.UserBean;

/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public interface IUserLoginView {

//    对于View的接口，去观察功能上的操作，然后考虑：
//    该操作需要什么？（getUserName, getPassword）
//    该操作的结果，对应的反馈？(toMainActivity, showFailedError)
//    该操作过程中对应的友好的交互？(showLoading, hideLoading)

    public String getUserName();
    public String getPassword();

    public void showLoading();
    public void hideLoading();

    public void toMainActivity(UserBean user);
    public void showFailedError();



    public void clearUserName();
    public void clearPassword();

}
