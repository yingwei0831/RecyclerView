package com.yw.testrecyclerview.retrofitutils;

import com.yw.testrecyclerview.retrofitutils.model.BaseFetch;
import com.yw.testrecyclerview.retrofitutils.model.BaseResponse;
import com.yw.testrecyclerview.retrofitutils.model.fetch.LineDetailFetch;
import com.yw.testrecyclerview.retrofitutils.model.response.LineDetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
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
}
