package com.yw.testrecyclerview.viewindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.testrecyclerview.R;

import java.util.ArrayList;
import java.util.Collections;

public class IndexableListViewActivity extends AppCompatActivity {

    ArrayList<String> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexable_list);
        /**
         * 1.初始化Items
         * 2.根据section获取position
         */
        mItems = new ArrayList<>();
        mItems.add("123456");
        mItems.add("a sodijd");
        mItems.add("b essodijd");
        mItems.add("q essodijd");
        mItems.add("c hssodijd");
        mItems.add("d hssodijd");
        mItems.add("p hssodijd");
        mItems.add("e vfssodijd");
        mItems.add("f phssodijd");
        mItems.add("h njssodijd");
        mItems.add("x njssodijd");
        mItems.add("y njssodijd");
        mItems.add("i hssodijd");
        mItems.add("q dssodijd");
        mItems.add("r zssodijd");
        mItems.add("t mssodijd");
        mItems.add("w rssodijd");
        mItems.add("x issodijd");
        mItems.add("z lssodijd");
        //排序
        Collections.sort(mItems);

    }
}
