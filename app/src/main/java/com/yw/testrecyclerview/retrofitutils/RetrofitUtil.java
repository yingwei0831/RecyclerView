package com.yw.testrecyclerview.retrofitutils;

import com.yw.testrecyclerview.retrofitutils.model.BaseFetch;
import com.yw.testrecyclerview.retrofitutils.model.BaseResponse;
import com.yw.testrecyclerview.retrofitutils.model.fetch.LineDetailFetch;
import com.yw.testrecyclerview.retrofitutils.model.response.LineDetailResponse;

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

    public interface LineAPIService {

        @POST
        void getDetail(@Body BaseFetch<LineDetailFetch> fetch, Callback<BaseResponse<LineDetailResponse>> callback);

        @POST
        Call<BaseResponse<LineDetailResponse>> getDetail();

    }

    public void getLineDetail(){

    }


    private static Retrofit getRetrofit(String url) {

        return new Retrofit.Builder().baseUrl(url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
}
