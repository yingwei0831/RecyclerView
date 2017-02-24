package com.yw.testrecyclerview.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.adapter.SimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestSnackActivity extends AppCompatActivity implements SimpleRecyclerAdapter.onItemClickListener {

    private static final String TAG = "TestSnackActivity";

    private List mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_snack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        mList = new ArrayList();
        for (int i = 0; i < 12; i++){
            mList.add("i = " + i);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.snack_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(
                new com.yw.testrecyclerview.DividerItemDecoration(
                        getApplicationContext(),
                        com.yw.testrecyclerview.DividerItemDecoration.VERTICAL_LIST,
                        getResources().getDrawable(R.drawable.divider_hori)));
        SimpleRecyclerAdapter mAdapter = new SimpleRecyclerAdapter(getApplicationContext(), mList, this);
        recyclerView.setAdapter(mAdapter);



    }

    @Override
    public void onItemClick(View view, int position) {
        if (position == mList.size()){
            Log.e(TAG, "onItemClick: loadMore");
        }else{
            Log.e(TAG, "onItemClick: item");
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
