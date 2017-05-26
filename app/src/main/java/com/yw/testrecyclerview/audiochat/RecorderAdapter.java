package com.yw.testrecyclerview.audiochat;

import android.app.Service;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.yw.testrecyclerview.R;

import java.util.List;


/**
 * Created by jiahe008_lvlanlan on 2017/5/25.
 */
public class RecorderAdapter extends RecyclerView.Adapter<RecorderAdapter.ViewHolder> {

    private List<Recorder> data;
    private OnItemClickListener mListener;
    //根据屏幕宽度，定义最小宽度，最大宽度
    private int mMinItemWidth;
    private int mMaxItemWidth;

    public RecorderAdapter(Context context, List<Recorder> data, OnItemClickListener listener) {
        this.data = data;
        mListener = listener;
        WindowManager wm = (WindowManager) context.getSystemService(Service.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);

        mMinItemWidth = (int) (outMetrics.widthPixels * 0.15f);
        mMaxItemWidth = (int) (outMetrics.widthPixels * 0.7f);
    }

    @Override
    public RecorderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recorder, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecorderAdapter.ViewHolder holder, final int position) {
        Recorder recorder = data.get(position);
        holder.tvSeconds.setText(Math.round(recorder.getTime()) + "\""); //四舍五入:+0.5,向下取整
        ViewGroup.LayoutParams params = holder.length.getLayoutParams();

        params.width = (int) (mMinItemWidth + (mMaxItemWidth / 60f * recorder.time));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onItemClick(v, position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        View length;
        TextView tvSeconds;

        public ViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvSeconds = (TextView) itemView.findViewById(R.id.tv_recorder_time);
            length = itemView.findViewById(R.id.layout_recorder_length);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
