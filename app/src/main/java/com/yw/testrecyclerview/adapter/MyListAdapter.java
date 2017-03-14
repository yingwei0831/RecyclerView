package com.yw.testrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.observer2.MyObserver;
import com.yw.testrecyclerview.observer2.MyPerson;

import java.util.List;

import cn.droidlover.xdroidmvp.base.SimpleListAdapter;

/**
 * Created by jiahe008_lvlanlan on 2017/3/14.
 */
public class MyListAdapter extends BaseAdapter {

    private Context context;

    private List data;

    public MyListAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_simple_textview, null, false);
            holder = new ViewHolder();
            holder.textView = (TextView) view.findViewById(R.id.id_text_view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        MyObserver observer = (MyObserver) data.get(i);
        if (observer != null) {
            holder.textView.setText("" + i + observer);
        }else{
            holder.textView.setText("" + i);
        }
        return view;
    }

    class ViewHolder{
        TextView textView;
    }
}
