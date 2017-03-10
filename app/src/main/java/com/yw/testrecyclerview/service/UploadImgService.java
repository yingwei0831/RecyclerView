package com.yw.testrecyclerview.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.yw.testrecyclerview.ui.IntentServiceActivity;

/**
 * Created by jiahe008_lvlanlan on 2017/3/10.
 * IntentService:
 * 1. 基于Service的一个类，用来处理异步的请求。
 * 2. 通过startService(Intent)来提交请求，该Service会在需要的时候创建，当完成所有的任务以后自己关闭，且请求是在工作线程处理的。
 */
public class UploadImgService extends IntentService {

    private static final String TAG = "UploadImgService";

    private static final String ACTION_UPLOAD_IMG = "com.zhy.blogcodes.intentservice.action.UPLOAD_IMAGE";
    public static final String EXTRA_IMG_PATH = "com.zhy.blogcodes.intentservice.extra.IMG_PATH";

    public static void startUpLoadImg(Context context, String path){
        Intent intent = new Intent(context, UploadImgService.class);
        intent.setAction(ACTION_UPLOAD_IMG);
        intent.putExtra(EXTRA_IMG_PATH, path);
        context.startService(intent);
    }

    public UploadImgService() {
        super("UploadImgService");
    }

    public UploadImgService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null){
            String action = intent.getAction();
            if (ACTION_UPLOAD_IMG.equals(action)){
                String path = intent.getStringExtra(EXTRA_IMG_PATH);
                handleUploadImg(path);
            }
        }
    }

    private void handleUploadImg(String path) {
        //模拟上传耗时,完成后发广播
        try {
            Thread.sleep(3000);
            Log.e(TAG, "thread name = " + Thread.currentThread().getName() + ", id = " + Thread.currentThread().getId());

            Intent intent = new Intent(IntentServiceActivity.ACTION_UPLOAD_RESULT);
            intent.putExtra(EXTRA_IMG_PATH, path);
            sendBroadcast(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}
