package com.yw.testrecyclerview.observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by jiahe008_lvlanlan on 2017/3/14.
 */
public class MyPerson extends Observable {

    private String name;
    private int age;
    private String gender;

    /**
     * setChanged();告知数据改变，
     * 通过notifyObservers();发送信号通知观察者。
     */
    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public void setGender(String gender) {
        this.gender = gender;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
