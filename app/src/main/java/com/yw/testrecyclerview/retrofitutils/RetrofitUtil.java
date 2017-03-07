package com.yw.testrecyclerview.retrofitutils;

import com.yw.testrecyclerview.retrofitutils.model.BaseFetch;
import com.yw.testrecyclerview.retrofitutils.model.BaseResponse;
import com.yw.testrecyclerview.retrofitutils.model.fetch.LineDetailFetch;
import com.yw.testrecyclerview.retrofitutils.model.response.LineDetailResponse;
import com.yw.testrecyclerview.utils.Constant;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jiahe008_lvlanlan on 2017/2/24.
 */
public class RetrofitUtil {

    /**
     * 1. 创建数据对象，创建请求接口
     * 2. 创建Retrofit对象
     * 3. 创建访问API的请求
     * 4. 发送请求，处理结果
     */
//    public interface LineAPIService {
//
//        @POST
//        void getDetail(@Body BaseFetch<LineDetailFetch> fetch, Callback<BaseResponse<LineDetailResponse>> callback);
//
//        @POST
//        Call<BaseResponse<LineDetailResponse>> getDetail();
//
//    }


    public static Retrofit getRetrofit() {

        return new Retrofit.Builder().baseUrl("http://api.duoshuo.com") //   Constant.BASE_URL
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
}
