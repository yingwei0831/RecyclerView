package com.yw.testrecyclerview.retrofitutils.impl;

import com.yw.testrecyclerview.retrofitutils.IWeather;

import java.util.Observable;

import retrofit2.http.Query;

/**
 * Created by jiahe008_lvlanlan on 2017/3/3.
 */
public class Weather implements IWeather {
    @Override
    public Observable getWeather(@Query("city") String city) {
        return null;
    }
}
