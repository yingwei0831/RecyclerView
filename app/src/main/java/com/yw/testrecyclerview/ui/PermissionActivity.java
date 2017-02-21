package com.yw.testrecyclerview.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yw.testrecyclerview.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * @RuntimePermissions 标记需要运行时判断的类
 * @NeedsPermission 标记需要检查权限的方法
 * @OnShowRationale 授权提示回调
 * @OnPermissionDenied 授权被拒绝回调
 * @OnNeverAskAgain 授权不再拒绝不再显示回调
 * 一次性申请一个权限
 * 4.—— Android Studio 安装插件：PermissionsDispatcher
 * 5.—— 写好了需要权限的方法之后需要编译一次才会出现相关的方法
 */
@RuntimePermissions
public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PermissionActivity";

    private static final int CALL_CAMERA_REQUEST_CODE = 1;

    private String tel = "10086";

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
    }

    private void initView() {
        findViewById(R.id.button_camera).setOnClickListener(this);
        findViewById(R.id.button_sd_card).setOnClickListener(this);
        findViewById(R.id.button_contact).setOnClickListener(this);
        findViewById(R.id.button_call_phone).setOnClickListener(this);
        ivLogo = (ImageView) findViewById(R.id.image);
        ivLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.image:
                selectImage();
                break;
            case R.id.button_camera:
                PermissionActivityPermissionsDispatcher.callPhoneWithCheck(this);//发起权限申请
//                requestCamera();
                break;
            case R.id.button_sd_card:
//                requestSDCard();
                break;
            case R.id.button_contact:
//                requestUserContact();
                break;
            case R.id.button_call_phone:
//                requestCallPhone(); //自己手动实现，但是点击了不再显示后，无响应了

                break;
        }

    }

    /**
     * 方法前面不能带有private修饰符
     */
    @NeedsPermission(Manifest.permission.CAMERA)//权限申请成功
    void callPhone() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(openCameraIntent, CALL_CAMERA_REQUEST_CODE);
    }

    @OnShowRationale(Manifest.permission.CAMERA)//申请前告知用户为什么需要该权限
    void showRationaleForCamera(PermissionRequest request) {
        showRationaleDialog("使用此功能需要打开照相机的权限", request);
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)//被拒绝
    void onCameraDenied() {
        Toast.makeText(getApplicationContext(), "你拒绝了权限，该功能不可用", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)//被拒绝并且勾选了不再提醒
    void onCameraNeverAskAgain() {
        AskForPermission();
    }

    /**
     * 告知用户具体需要权限的原因
     * @param messageResId
     * @param request
     */
    private void showRationaleDialog(String messageResId, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();//请求权限
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageResId)
                .show();
    }

    /**
     * 被拒绝并且不再提醒,提示用户去设置界面重新打开权限
     */
    private void AskForPermission() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("当前应用缺少拍照权限,请去设置界面打开\n打开之后按两次返回键可回到该应用哦");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName())); // 根据包名打开对应的设置界面
                startActivity(intent);
            }
        });
        builder.create().show();
    }

    /**
     * 选择图片
     */
    private void selectImage() {

    }

//    /**
//     * 打电话
//     */
//    private void requestCallPhone() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//            //同意
//            Log.e(TAG, "用户已经同意了打电话请求");
//            callPhone(tel);
//        } else {
//            //未同意
//            Log.e(TAG, "需要授权：打电话请求");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 4);
//        }
//    }

//    private void callPhone(String tel) {
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri uri = Uri.parse("tel:" + tel);
//        intent.setData(uri);
//        startActivity(intent);
//    }

//    /**
//     * 用户联系人列表
//     */
//    private void requestUserContact() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
//            //同意
//            Log.e(TAG, "用户已经同意了访问联系人请求");
//        } else {
//            //未同意
//            Log.e(TAG, "需要授权：访问联系人请求");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 3);
//        }
//    }
//
//    /**
//     * 申请SD卡读、写权限
//     */
//    private void requestSDCard() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//            //同意
//            Log.e(TAG, "用户已经同意了SD卡写请求");
//        } else {
//            //未同意
//            Log.e(TAG, "需要授权：SD卡写权限");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
//        }
//    }
//
//    /**
//     * 申请调用相机权限
//     */
//    private void requestCamera() {
//        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//            //同意
//            Log.e(TAG, "用户已经同意了使用相机请求");
//        } else {
//            //未同意,申请授权
//            Log.e(TAG, "需要授权：相机使用权限");
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);//将回调交给代理类处理

//        if (requestCode == 1) { //Camera
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //同意
//                Log.e(TAG, "用户同意了使用相机请求");
//            } else {
//                Log.e(TAG, "用户拒绝了使用相机请求");
//            }
//        } else if (requestCode == 2) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //同意
//                Log.e(TAG, "用户同意了SD卡写权限");
//            } else {
//                Log.e(TAG, "用户拒绝了SD卡写权限");
//            }
//        } else if (requestCode == 3) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //同意
//                Log.e(TAG, "用户同意了访问联系人请求");
//            } else {
//                Log.e(TAG, "用户拒绝了访问联系人请求");
//            }
//        } else if (requestCode == 4) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //同意
//                Log.e(TAG, "用户同意了打电话请求");
//                callPhone(tel);
//            } else {
//                Log.e(TAG, "用户拒绝了打电话请求");
//                Toast.makeText(getApplicationContext(), "用户拒绝了打电话权限", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CALL_CAMERA_REQUEST_CODE:
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap bmap = data.getParcelableExtra("data");
                    ivLogo.setImageBitmap(bmap);
                    Toast.makeText(getApplicationContext(), "头像保存成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
