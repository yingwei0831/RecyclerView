package com.yw.testrecyclerview.retrofitutils;

import com.yw.testrecyclerview.retrofitutils.impl.Weather;

import java.util.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jiahe008_lvlanlan on 2017/3/3.
 */
public interface IWeather {
    @GET("/weather_mini")
    Observable getWeather(@Query("city")String city);

}
