package com.yw.testrecyclerview.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yw.testrecyclerview.BaseActivity;
import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.retrofitutils.RetrofitUtil;
import com.yw.testrecyclerview.retrofitutils.RetrofitWrapper;
import com.yw.testrecyclerview.retrofitutils.intf.IApiService;
import com.yw.testrecyclerview.retrofitutils.model.BaseFetch;
import com.yw.testrecyclerview.retrofitutils.model.BaseResponse;
import com.yw.testrecyclerview.retrofitutils.model.fetch.LineDetailFetch;
import com.yw.testrecyclerview.retrofitutils.model.response.LineDetailResponse;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TestRetrofitActivity extends BaseActivity {

    private static final String TAG = "TestRetrofitActivity";

    @BindView(R.id.button_send_request)
    Button buttonSendRequest;

    @OnClick({R.id.button_send_request})
    public void clickEvent(View view){
        switch (view.getId()){
            case R.id.button_send_request:
                retrofitMethod();
                break;

        }
    }


    private void retrofitMethod() {
        Log.e(TAG, "----retrofitMethod----");
        BaseFetch<LineDetailFetch> fetchModel = new BaseFetch<>(
                new BaseFetch.HeadBean("Publics_show"),
                new LineDetailFetch("589", "73"));

        IApiService service = RetrofitWrapper.getInstance().create(IApiService.class);
        Call<BaseResponse<LineDetailResponse>> result = service.lineDetail(fetchModel);
        result.enqueue(new Callback<BaseResponse<LineDetailResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<LineDetailResponse>> call, Response<BaseResponse<LineDetailResponse>> response) {
                Log.e(TAG, "code = " + response.code());
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
                    BaseResponse<LineDetailResponse> body = response.body();
                    Log.e(TAG, "result = " + body.toString());
                }else{
                    Toast.makeText(getApplicationContext(), "失败", Toast.LENGTH_SHORT).show();
                    try {
                        Log.e(TAG, "response error = " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<LineDetailResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Toast.makeText(getApplicationContext(), "出错", Toast.LENGTH_SHORT).show();
            }
        });

//        IApiService apiService = RetrofitUtil.getInstance().create(IApiService.class);
//        apiService.lineDetail(fetchModel).enqueue(new Callback<BaseResponse<LineDetailResponse>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<LineDetailResponse>> call, Response<BaseResponse<LineDetailResponse>> response) {
//                Log.e(TAG, "code = " + response.code());
//                if (response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
//                    BaseResponse<LineDetailResponse> body = response.body();
//                    Log.e(TAG, "result = " + body.toString());
//                }else{
//                    Toast.makeText(getApplicationContext(), "失败", Toast.LENGTH_SHORT).show();
//                    try {
//                        Log.e(TAG, "response error = " + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<LineDetailResponse>> call, Throwable t) {
//                Log.e(TAG, "onFailure");
//                Toast.makeText(getApplicationContext(), "出错", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_retrofit;
    }

    @Override
    public Object newP() {
        return null;
    }


}
