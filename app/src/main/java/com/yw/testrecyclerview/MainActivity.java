package com.yw.testrecyclerview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> mDates;

    private RecyclerViewSimpleAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        mAdapter = new RecyclerViewSimpleAdapter(getApplicationContext(), mDates);
        recyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置RecyclerView的item间分隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL_LIST, getResources().getDrawable(R.drawable.divider_hori)));
        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.onItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "click " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "longClick " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas() {
        mDates = new ArrayList<>();
        for(int i = 'A'; i <= 'z'; i++){
            mDates.add( (char)i + "");
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
        int id = item.getItemId();
        switch (id){
            case R.id.action_setting:
                break;
            case R.id.action_gridview:
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                break;
            case R.id.action_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                break;
            case R.id.action_hor_girdview:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(6, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_stagger:
                Intent intent = new Intent(getApplicationContext(), StaggeredGridLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_delete:
                mAdapter.deleteData(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
