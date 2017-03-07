package com.yw.testrecyclerview.retrofitutils;

import com.yw.testrecyclerview.retrofitutils.model.PhoneResult;
import com.yw.testrecyclerview.retrofitutils.model.response.LineDetailResponse;

import retrofit2.Call;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jiahe008_lvlanlan on 2017/3/6.
 */
public interface ILineDetail<T> {

//    //自己的请求接口
//    @FormUrlEncoded
//    @POST
//    Call<LineDetailResponse> lineDetail();

    //直接请求类型：
    //1.直接请求
    @GET("/record")
    Call<PhoneResult> getResult();

    //2.组合后直接请求
    @GET("/result/{id}")
    Call<PhoneResult> getResult(@Path("id") String id);

    //3.带参数查询：
    @GET("/otn/lcxxcx/query")
    Call<Result> query(@Query("purpose_codes") String codes, @Query("queryDate") String date,
                       @Query("from_station") String from, @Query("to_station") String to);
    //4.带Header型
    @POST("/info")
    Call<Object> updateInfo(@Header("device") String device, @Header("version") int version,
                            @Field("id") String id);

    // Demo中的请求接口
    @GET("/apistore/mobilenumber/mobilenumber")
    Call<PhoneResult> getResult(@Header("apikey") String apikey, @Query("phone") String phone);

    //Demo中的请求接口，添加泛型返回类数据类型
    @GET("/threads/counts.json")
    Call<T> getCommit(@Query("short_name") String shortName, @Query("threads") String threads);

}
