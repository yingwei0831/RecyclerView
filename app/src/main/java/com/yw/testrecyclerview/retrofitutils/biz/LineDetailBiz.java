package com.yw.testrecyclerview.retrofitutils.biz;

import android.util.Log;

import com.yw.testrecyclerview.retrofitutils.intf.IApiService;
import com.yw.testrecyclerview.retrofitutils.model.PhoneResult;
import com.yw.testrecyclerview.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jiahe008_lvlanlan on 2017/3/7.
 */
public class LineDetailBiz {

    private static final String TAG = "LineDetailBiz";

    public void query(String phone){
        // 1.创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()) //解析方法
                .baseUrl(Constant.BASE_URL_DEMO) //主机地址
                .build();
        // 2.创建访问API的请求
        IApiService service = retrofit.create(IApiService.class);
        Call<PhoneResult> call = service.getResult(Constant.API_KEY_DEMO, phone);
        // 3.发送请求
        call.enqueue(new Callback<PhoneResult>() {
            @Override
            public void onResponse(Call<PhoneResult> call, Response<PhoneResult> response) {
                // 4.处理结果
                if (response.isSuccessful()){
                    PhoneResult body = response.body();
                    if (body != null){
                        PhoneResult.RetDataEntity entity = body.getRetData();
                        Log.e(TAG, "result = " + entity.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<PhoneResult> call, Throwable t) {

            }
        });
    }
}
