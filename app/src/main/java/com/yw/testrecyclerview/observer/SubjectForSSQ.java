package com.yw.testrecyclerview.observer;

import java.util.Observable;

/**
 * Created by jiahe008_lvlanlan on 2017/3/13.
 */
public class SubjectForSSQ extends Observable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    /**
     * 主题更新消息
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
