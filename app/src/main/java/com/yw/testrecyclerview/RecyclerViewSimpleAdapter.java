package com.yw.testrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by jiahe008 on 2016/5/26.
 * 第一种，下拉刷新和上拉刷新都用SwipeRefreshLayout 自带的进度条
 */
public class RecyclerViewSimpleAdapter extends RecyclerView.Adapter<RecyclerViewSimpleAdapter.MyViewHolder> {

    private Context mContext;
    protected List<String> mDates;
    private LayoutInflater mInflater;

    public RecyclerViewSimpleAdapter(Context context, List<String> dates){
        this.mContext = context;
        this.mDates = dates;
        this.mInflater = LayoutInflater.from(context);
    }

    public interface onItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    private onItemClickListener mOnItemClickListener;
    //供外部调用接口，回调方法
    public void setOnItemClickListener(onItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_simple_textview, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(mDates.get(position));

        setUpEvent(holder);

    }

    protected void setUpEvent(final MyViewHolder holder) {
        if(mOnItemClickListener != null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.textView, pos);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.textView, pos);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    public void addData(int position){
        mDates.add(position, "Insert one");
        notifyItemInserted(position);
    }

    public void deleteData(int position){
        mDates.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.id_text_view);
        }
    }

}

