package com.yw.testrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> mDatas;

    private StaggeredAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        mAdapter = new StaggeredAdapter(getApplicationContext(), mDatas);
        recyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置RecyclerView的item间分隔线
//        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST, getResources().getDrawable(R.drawable.divider_hori)));
        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mAdapter.deleteData(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.deleteData(position);
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for(int i = 'A'; i <= 'z'; i++){
            mDatas.add( (char)i + "");
        }
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.id_recycler_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
