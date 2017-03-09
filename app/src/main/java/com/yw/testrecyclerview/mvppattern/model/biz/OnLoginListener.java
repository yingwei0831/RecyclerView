package com.yw.testrecyclerview.mvppattern.model.biz;

import com.yw.testrecyclerview.mvppattern.model.bean.UserBean;

/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public interface OnLoginListener {
    public void loginSuccess(UserBean user);
    public void loginFailed();
}
