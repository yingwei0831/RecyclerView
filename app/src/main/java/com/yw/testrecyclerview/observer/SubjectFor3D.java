package com.yw.testrecyclerview.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by jiahe008_lvlanlan on 2017/3/13.
 *
 * 3D彩票服务号主题
 */
public class SubjectFor3D extends Observable {

    /**
     * 3D彩票的号码
     */
    private String msg;

    /**
     * 主题更新消息
     * @param msg
     */
    public void setMsg(String msg){
        this.msg = msg;
        setChanged();
        notifyObservers();
    }

    public String getMsg() {
        return msg;
    }
}
