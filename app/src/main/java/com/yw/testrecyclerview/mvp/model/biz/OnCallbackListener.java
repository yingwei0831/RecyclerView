package com.yw.testrecyclerview.mvp.model.biz;

import com.yw.testrecyclerview.mvp.model.bean.UserBean;

/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public interface OnCallbackListener {
    public void loginSuccess(UserBean user);
    public void loginFailed();
}
