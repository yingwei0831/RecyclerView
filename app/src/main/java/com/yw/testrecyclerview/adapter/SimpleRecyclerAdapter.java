package com.yw.testrecyclerview.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yw.testrecyclerview.R;

import java.util.List;

/**
 * Created by jiahe008_lvlanlan on 2017/2/22.
 * 第二种实现下拉刷新用SwipeRefreshLayout 自带的进度条， 上拉刷新用类似ListView的刷新 提示“加载中”等信息
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "SimpleRecyclerAdapter";

    private Context mContext;
    private List mList;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private onItemClickListener mListener;

    public SimpleRecyclerAdapter(Context context, List mList, onItemClickListener listener) {
        this.mContext = context;
        this.mList = mList;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_ITEM:
                View viewItem = LayoutInflater.from(mContext).inflate(R.layout.item_simple_textview, null);
                viewItem.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return new MyViewHolder(viewItem);
            case TYPE_FOOTER:
                View viewFooter = LayoutInflater.from(mContext).inflate(R.layout.footer_recycler, null);
                viewFooter.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return new FooterViewHolder(viewFooter);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof FooterViewHolder){
            ((FooterViewHolder) holder).tvLoadMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(view, position);
                }
            });
        }else if (holder instanceof MyViewHolder){
            ((MyViewHolder) holder).textView.setText((CharSequence) mList.get(position));
            ((MyViewHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(view, position);
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    //RecyclerView的count设置为数据总条数+ 1（footerView）
    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() == position){
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.id_text_view);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        TextView tvLoadMore;

        public FooterViewHolder(View itemView) {
            super(itemView);
            tvLoadMore = (TextView) itemView.findViewById(R.id.tv_load_more);
        }
    }
}
