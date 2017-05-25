package com.yw.testrecyclerview.audiochat;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yw.testrecyclerview.R;

/**
 * Created by jiahe008_lvlanlan on 2017/5/24.
 * 管理Dialog，依赖Context，必须是Activity级别的Context，static 对象内部引用Dialog无法释放，
 * 切换Activity后或Dialog重建，产生内存泄漏
 */
public class DialogManager {

    private Dialog mDialog;

    private ImageView mIcon;
    private ImageView mVoice;
    private TextView mLable;

    private Context mContext;

    public DialogManager(Context mContext) {
        this.mContext = mContext;
    }

    public void showRecorderDialog(){
        mDialog = new Dialog(mContext, R.style.Theme_AudioDialog);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_recorder, null, false);
        mDialog.setContentView(view);

        mIcon = (ImageView) mDialog.findViewById(R.id.iv_recorder_dialog_icon);
        mVoice = (ImageView) mDialog.findViewById(R.id.iv_recorder_dialog_voice);
        mLable = (TextView) mDialog.findViewById(R.id.tv_recorder_dialog_notice);

        mDialog.show();
    }

    public void recording(){
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.VISIBLE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.recorder);
            mLable.setText("手指上划 取消发送");
        }
    }

    public void wantToCancel(){
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.cancel);
            mLable.setText("松开手指 取消发送");
        }
    }

    public void tooShort(){
        if (mDialog != null && mDialog.isShowing()) {
            mIcon.setVisibility(View.VISIBLE);
            mVoice.setVisibility(View.GONE);
            mLable.setVisibility(View.VISIBLE);

            mIcon.setImageResource(R.mipmap.voice_to_short);
            mLable.setText("录音时间过短");
        }
    }

    public void dismissDialog(){
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    /**
     * 通过level跟新voice的图片 v1-v7
     * @param level
     */
    public void updateVoiceLevel(int level){
        if (mDialog != null && mDialog.isShowing()) {
//            mIcon.setVisibility(View.VISIBLE);
//            mVoice.setVisibility(View.VISIBLE);
//            mLable.setVisibility(View.VISIBLE);

            int id = mContext.getResources().getIdentifier("v"+level, "mipmap", mContext.getPackageName());
            mVoice.setImageResource(id);
        }
    }
}
