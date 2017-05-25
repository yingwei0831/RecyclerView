package com.yw.testrecyclerview.audiochat;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


/**
 * Created by jiahe008_lvlanlan on 2017/5/24.
 */
public class AudioRecorderButton extends Button implements AudioManager.AudioStateListener {

    private static final int DISTANCE_Y_CANCEL = 50; //单位dp  转px后使用，进行判断
    private static final int STATE_NORMAL = 1;
    private static final int STATE_RECORDING = 2;
    private static final int STATE_WANT_TO_CANCEL = 3;
    private int mCurState = STATE_NORMAL; //默认状态

    private boolean isRecording = false; //已经开始录音
    private DialogManager mDialogManager;

    private AudioManager mAudioManager;

    /**
     * 获取音量大小的Runnable
     * 开始录音计时
     */
    private Runnable mGetVoiceLevelRunnable = new Runnable() {
        @Override
        public void run() {
            while (isRecording){
                try {
                    Thread.sleep(100);
                    mTime += 0.1f;
                    mHandler.sendEmptyMessage(MSG_VOICE_CHANGED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static final int MSG_AUDIO_PREPARED = 0X110;
    private static final int MSG_VOICE_CHANGED = 0X111;
    private static final int MSG_DIALOG_DISMISS = 0X112;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_AUDIO_PREPARED:
                    // 真正显示应该在 audio end prepared 以后
                    mDialogManager.showRecorderDialog();
                    isRecording = true;

                    //dialog显示以后，需要获取音量，不能连续获取，需要单独开启线程
                    new Thread(mGetVoiceLevelRunnable).start();
                    break;
                case MSG_VOICE_CHANGED:
                    mDialogManager.updateVoiceLevel(mAudioManager.getVoiceLevel(7));
                    break;
                case MSG_DIALOG_DISMISS:
                    mDialogManager.dismissDialog();
                    break;
            }
        }
    };

    private float mTime;

    //是否触发longClick:如果触发了 longClick,理论上 AudioManager 去 prepared 了，up后是需要释放资源的，所以要有这个标志位
    private boolean mReady;

    public AudioRecorderButton(Context context) {
        this(context, null);
    }

    public AudioRecorderButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDialogManager = new DialogManager(getContext());

        String dir = Environment.getExternalStorageDirectory() + "/audio_recorder";
        mAudioManager = AudioManager.getInstance(dir);
        mAudioManager.setOnAudioStateListener(this);

        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mReady = true;
                mAudioManager.prepareAudio();
                return false;
            }
        });
    }

    /**
     * 录音完成后的回调
     */
    public interface AudioFinishListener{
        void onFinish(float seconds, String filePath);
    }
    private AudioFinishListener mListener;
    public void setAudioFinishListener(AudioFinishListener listener){
        mListener = listener;
    }

    @Override
    public void wellPrepared() {
        mHandler.sendEmptyMessage(MSG_AUDIO_PREPARED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                changeState(STATE_RECORDING);
                break;
            case MotionEvent.ACTION_UP:
                //1.up时间发生在onLongClick之前 mReady
                //2.prepared未完成就up了
                //3.录音时间很短 up了
                if (!mReady){
                    reset();
                    return super.onTouchEvent(event);
                }
                if (!isRecording ||mTime < 0.9f){ //显示时间太短，录音取消，Dialog显示1300ms消失
                    mDialogManager.tooShort();
                    mAudioManager.cancel();
                    mHandler.sendEmptyMessageDelayed(MSG_DIALOG_DISMISS, 1300);
                }else  if (mCurState == STATE_RECORDING){ //正常结束录音
                    mDialogManager.dismissDialog();
                    mAudioManager.release();
                    if (mListener != null){
                        mListener.onFinish(mTime, mAudioManager.getCurrentFilePath());
                    }
                    //release
                    //callbackToAct
                }else if (mCurState == STATE_WANT_TO_CANCEL){ //取消录音
                    //cancel
                    mDialogManager.dismissDialog();
                    mAudioManager.cancel();
                }
                reset();
                break;
            case MotionEvent.ACTION_MOVE:
                if (isRecording){ //如果已经开始录音
                    //根据x,y坐标，判断是否想要取消
                    if (wantToCancel((int)event.getX(), (int)event.getY())){
                        changeState(STATE_WANT_TO_CANCEL);
                    }else{
                        changeState(STATE_RECORDING);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 恢复状态及标志位
     */
    private void reset() {
        isRecording = false;
        mReady = false;
        mTime = 0;
        changeState(STATE_NORMAL);
    }

    private boolean wantToCancel(int x, int y) {
        if (x < 0 || x > getWidth()){ //判断手指的横坐标是否超出按钮范围
            return true;
        }
        if (y < -DISTANCE_Y_CANCEL || y > getHeight() + DISTANCE_Y_CANCEL){ //
            return true;
        }
        return false;
    }

    private void changeState(int state) {
        if (mCurState != state) {
            mCurState = state;
            switch (state){
                case STATE_NORMAL: //正常背景色，正常文字
//                    setBackgroundResource(R.drawable.recorder.normal);
                    setText("按住 说话"); //str_recorder_normal
                    break;
                case STATE_RECORDING: //正在录音背景颜色，正在录音文字
//                    setBackgroundResource(R.drawable.recorder.recording);
                    setText("松开 结束"); //str_recorder_recording
                    if (isRecording){
                        mDialogManager.recording();
                    }
                    break;
                case  STATE_WANT_TO_CANCEL: //正在录音背景色，松开取消文字
//                    setBackgroundResource(R.drawable.recorder.recording);
                    setText("松开手指 取消发送"); //str_recorder_want_cancel
                    mDialogManager.wantToCancel();
                    break;
            }
        }
    }

}
