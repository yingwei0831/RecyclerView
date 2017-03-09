package com.yw.testrecyclerview.mvppattern.model.biz;

/**
 * Created by jiahe008_lvlanlan on 2017/3/9.
 */
public interface ILoginBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
