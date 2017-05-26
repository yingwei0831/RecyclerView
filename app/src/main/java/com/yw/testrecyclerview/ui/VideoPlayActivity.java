package com.yw.testrecyclerview.ui;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.yw.testrecyclerview.R;

public class VideoPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "VideoPlayActivity";

    String path = "http://mv.eastday.com/vgaoxiao/20170523/20170523114620156311391_1_06400360.mp4";
    VideoView mVideoView; //视频播放
    ImageView mImageView; //预览图片

    boolean canStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        final SpinKitView spinKitView = (SpinKitView) findViewById(R.id.spin_kit);
//        spinKitView

        mVideoView = (VideoView) findViewById(R.id.video_view);
        mImageView = (ImageView) findViewById(R.id.video_preview);

        try {
            mVideoView.setVideoURI(Uri.parse(path));
            mVideoView.setMediaController(new MediaController(this));

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
//                    spinKitView.startAnimation(getResources().getAnimation());
                    spinKitView.setVisibility(View.GONE);
                    canStart = true;
                }
            });

//            Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(path, MediaStore.Video.Thumbnails.MICRO_KIND);
            MediaMetadataRetriever media = new MediaMetadataRetriever();
            media.setDataSource(getApplicationContext(), Uri.parse(path));
            Bitmap bitmap = media.getFrameAtTime();
            Log.e(TAG, "bitmap = " + bitmap);
            mImageView.setImageBitmap(bitmap);

//            mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//                @Override
//                public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                    return false;
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        findViewById(R.id.btn_play).setOnClickListener(this);
        findViewById(R.id.btn_pause).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                mVideoView.start();
                break;
            case R.id.btn_pause:
                mVideoView.pause(); //暂停
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //恢复之前输入框的内容
        if (savedInstanceState != null) {

        }
    }

    private void resizeView() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        Log.e("tag", "phone: width = " + outMetrics.widthPixels +", height = " + outMetrics.heightPixels);

        String wh = path.substring(path.lastIndexOf("_") + 1, path.lastIndexOf("."));
        String w = wh.substring(0, wh.length()/2);
        String h = wh.substring(wh.length()/2, wh.length());
        //服务器视图大小
        int videoW = Integer.parseInt(w);
        int videoH = Integer.parseInt(h);
        Log.e("tag", "video: w = " + w +", h = " + h);

        //缩放比率
        float wPercent = videoW * 1f / outMetrics.widthPixels ;
        Log.e("tag", "percent = " + wPercent);
        //实际手机视图大小
        int viewH = (int) (outMetrics.heightPixels * wPercent);
        Log.e("tag", "viewH = " + viewH);

        ViewGroup.LayoutParams params = mVideoView.getLayoutParams();
        params.height = viewH;
        Log.e("tag", "viewW = " + outMetrics.widthPixels +", viewH = " + viewH);
        //ImageView 大小设置
    }
}
