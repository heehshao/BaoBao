package com.example.a1.baobao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者 by Gavin on 2016/1/5 0005.
 * 描述：用来添加Fragment
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);
        this.fragments = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

}
