package com.yw.testrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


/**
 * Created by jiahe008 on 2016/5/26.
 */
public class StaggeredAdapter extends RecyclerViewSimpleAdapter {

    //动态控制item的高度
    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> datas){
       super(context, datas);
        mHeights = new ArrayList<>();
        for(int i = 0; i < mDates.size(); i++){
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.textView.getLayoutParams();
        params.height = mHeights.get(position);
        holder.textView.setLayoutParams(params);
        holder.textView.setText(mDates.get(position));

        setUpEvent(holder);
    }

}

