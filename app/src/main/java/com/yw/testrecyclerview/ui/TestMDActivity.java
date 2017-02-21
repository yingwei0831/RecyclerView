package com.yw.testrecyclerview.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.yw.testrecyclerview.R;
import com.yw.testrecyclerview.adapter.TabLayoutFragmentPagerAdapter;
import com.yw.testrecyclerview.fragment.RecyclerFragment;

public class TestMDActivity extends AppCompatActivity {

    private static final String TAG = "TestMDActivity";
    private ViewPager viewPager;
    private TabLayoutFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_md);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new TabLayoutFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(RecyclerFragment.newInstance(), "TabOne");
        mAdapter.addFragment(RecyclerFragment.newInstance(), "TabTwo");
        mAdapter.addFragment(RecyclerFragment.newInstance(), "TabThree");
        viewPager.setAdapter(mAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.addTab(tabLayout.newTab().setText("TabOne"));
//        tabLayout.addTab(tabLayout.newTab().setText("TabTwo"));
//        tabLayout.addTab(tabLayout.newTab().setText("TabThree"));
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "onPageSelected: "+"position = " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
