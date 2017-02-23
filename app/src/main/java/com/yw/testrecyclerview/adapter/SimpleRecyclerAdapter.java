package com.yw.testrecyclerview.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.yw.testrecyclerview.R;

import java.util.List;

/**
 * Created by jiahe008_lvlanlan on 2017/2/22.
 * 第二种实现下拉刷新用SwipeRefreshLayout 自带的进度条， 上拉刷新用类似ListView的刷新 提示“加载中”等信息
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List mList;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public SimpleRecyclerAdapter(Context context, List mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_ITEM:
                View viewItem = LayoutInflater.from(mContext).inflate(R.layout.item_simple_textview, null);
                return new MyViewHolder(viewItem);
            case TYPE_FOOTER:
                View viewFooter = LayoutInflater.from(mContext).inflate(R.layout.footer_recycler, null);
                return new FooterViewHolder(viewFooter);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    //RecyclerView的count设置为数据总条数+ 1（footerView）
    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size() + 1 == position){
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
//        return super.getItemViewType(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.id_text_view);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
