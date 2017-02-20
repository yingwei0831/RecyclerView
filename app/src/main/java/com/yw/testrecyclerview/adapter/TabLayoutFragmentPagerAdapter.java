package com.yw.testrecyclerview.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahe008_lvlanlan on 2017/2/13.
 */
public class TabLayoutFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();                      //fragment列表
    private List<String> mFragmentsTitles = new ArrayList<>();                  //tab名的列表

    public TabLayoutFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    /**
     * @param fragment      添加Fragment
     * @param fragmentTitle Fragment的标题，即TabLayout中对应Tab的标题
     */
    public void addFragment(Fragment fragment, String fragmentTitle) {
        mFragments.add(fragment);
        mFragmentsTitles.add(fragmentTitle);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return mFragmentsTitles.get(position);
    }

//    private List<Fragment> listFragment;                      //fragment列表
//    private List<String> titles;                              //tab名的列表
//    private Context context;

//    public TabLayoutFragmentPagerAdapter(FragmentManager fm, Context context) {
//        super(fm);
//        this.context = context;
//    }
//
//    public TabLayoutFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragment, Context context) {
//        super(fm);
//        this.listFragment = listFragment;
//        this.context = context;
//    }
//
//    public TabLayoutFragmentPagerAdapter(Context context, FragmentManager fm, List<Fragment> fragments, List<String> titles) {
//        super(fm);
//        this.context = context;
//        this.listFragment = fragments;
//        this.titles = titles;
//    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles.get(position % titles.size());
//    }

//    public View getTabView(int position) {
//        View v = LayoutInflater.from(context).inflate(R.layout.item_tab_layout_indicator, null);
//        TextView tv = (TextView) v.findViewById(R.id.tv_custom_tab_text);
//        tv.setText(titles.get(position));
//        return v;
//    }
}
