package com.yw.testrecyclerview.ui;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.audiochat.AudioRecorderButton;
import com.yw.testrecyclerview.audiochat.MediaManager;
import com.yw.testrecyclerview.audiochat.Recorder;
import com.yw.testrecyclerview.audiochat.RecorderAdapter;

import java.util.ArrayList;
import java.util.List;

public class AudioChatActivity extends AppCompatActivity implements RecorderAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private RecorderAdapter mAdapter;
    private List<Recorder> mDatas = new ArrayList<>();

    private AudioRecorderButton mAudioRecorderButton;

    private View mAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_chat);

        mRecyclerView = (RecyclerView) findViewById(R.id.list_recorder);
        mAudioRecorderButton = (AudioRecorderButton) findViewById(R.id.audio_recorder_button);
        mAudioRecorderButton.setAudioFinishListener(new AudioRecorderButton.AudioFinishListener() {
            @Override
            public void onFinish(float seconds, String filePath) {
                Recorder recorder = new Recorder(seconds, filePath);
                mDatas.add(recorder);
                mAdapter.notifyItemChanged(mDatas.size() - 1);
                mRecyclerView.smoothScrollToPosition(mDatas.size() - 1);
            }
        });
        mAdapter =  new RecorderAdapter(getApplicationContext(), mDatas, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onItemClick(View view, int position) {
        if (mAnimView != null){
            mAnimView.setBackgroundResource(R.mipmap.adj);
            mAnimView = null;
        }
        //播放动画
        mAnimView = view.findViewById(R.id.view_recorder_anim);
        mAnimView.setBackgroundResource(R.drawable.play_anim);
        AnimationDrawable anim = (AnimationDrawable) mAnimView.getBackground();
        anim.start();
        //播放音频
        MediaManager.playSound(mDatas.get(position).getFilePath(), new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //动画停止
                mAnimView.setBackgroundResource(R.mipmap.adj);

            }
        });
    }
}
