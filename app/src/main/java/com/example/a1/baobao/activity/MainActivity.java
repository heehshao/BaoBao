package com.example.a1.baobao.activity;


import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a1.baobao.R;
import com.example.a1.baobao.activity.BaseActivity;
import com.example.a1.baobao.adapter.FragmentAdapter;
import com.example.a1.baobao.fragment.CollectFragment;
import com.example.a1.baobao.fragment.IndexFragment;
import com.example.a1.baobao.fragment.ShopCarFragment;
import com.example.a1.baobao.fragment.UserFragment;
import com.example.a1.baobao.view.NoScrollViewPager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {
    public static MainActivity mainActivity = null;
    public UserFragment userFragment;
    @ViewInject(R.id.main_content_viewpager)
    private NoScrollViewPager mViewPager;
    @ViewInject(R.id.main_tab_fragment01_group)
    private LinearLayout mTabGroupA;
    @ViewInject(R.id.main_tab_fragment01_image)
    private ImageView mTabImageA;
    @ViewInject(R.id.main_tab_fragment01_text)
    private TextView mTabTextA;
    @ViewInject(R.id.main_tab_fragment02_group)
    private LinearLayout mTabGroupB;
    @ViewInject(R.id.main_tab_fragment02_image)
    private ImageView mTabImageB;
    @ViewInject(R.id.main_tab_fragment02_text)
    private TextView mTabTextB;
    @ViewInject(R.id.main_tab_fragment03_group)
    private LinearLayout mTabGroupC;
    @ViewInject(R.id.main_tab_fragment03_image)
    private ImageView mTabImageC;
    @ViewInject(R.id.main_tab_fragment03_text)
    private TextView mTabTextC;
    @ViewInject(R.id.main_tab_fragment04_group)
    private LinearLayout mTabGroupD;
    @ViewInject(R.id.main_tab_fragment04_image)
    private ImageView mTabImageD;
    @ViewInject(R.id.main_tab_fragment04_text)
    private TextView mTabTextD;
    private long mExitTime = 0;

    @Override
    protected String setTitleContent() {
        return null;
    }

    @Override
    protected void initListener() {
        mViewPager.addOnPageChangeListener(this);
        mTabGroupA.setOnClickListener(this);
        mTabGroupB.setOnClickListener(this);
        mTabGroupC.setOnClickListener(this);
        mTabGroupD.setOnClickListener(this);
    }
    @Override
    protected void initData() {
        mainActivity = this;
        mMain = 1;
        mViewPager.setOffscreenPageLimit(4);
        IndexFragment indexFragment = new IndexFragment();
        CollectFragment collectFragment = new CollectFragment();
        ShopCarFragment shopCarFragment =new ShopCarFragment();
        Log.d("updateHeadImg==","1");
        userFragment = new UserFragment();
        Log.d("updateHeadImg==","2");
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(indexFragment);
        fragmentList.add(collectFragment);
        fragmentList.add(userFragment);
        fragmentList.add(shopCarFragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentAdapter adapter = new FragmentAdapter(manager, fragmentList);

        mViewPager.setAdapter(adapter);
        Log.d("updateHeadImg==","3");
        mViewPager.setCurrentItem(0);
        mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home_select));
        mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan));
        mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car));
        mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine));
    }

    public void backHome() {
        SubmitEvent("Tabbar_Activity");
        mViewPager.setCurrentItem(0);
        mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home_select));
        mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan));
        mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car));
        mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine));
        mTabTextA.setTextColor(getResources().getColor(R.color.themes_color));
        mTabTextB.setTextColor(getResources().getColor(R.color.all_bg_color));
        mTabTextC.setTextColor(getResources().getColor(R.color.all_bg_color));
        mTabTextD.setTextColor(getResources().getColor(R.color.all_bg_color));
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            setTitle("首页");
        } else if (position == 1) {
            setTitle("收藏夹");
        } else if (position == 2) {
            setTitle("进货车");
        }else if (position == 3) {
            setTitle("我的");

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_tab_fragment01_group:
                SubmitEvent("Tabbar_Activity");
                mViewPager.setCurrentItem(0);
                mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home_select));
                mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan));
                mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car));
                mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine));
                mTabTextA.setTextColor(getResources().getColor(R.color.themes_color));
                mTabTextB.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextC.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextD.setTextColor(getResources().getColor(R.color.all_bg_color));
                break;
            case R.id.main_tab_fragment02_group:
                SubmitEvent("Tabbar_Activity");
                mViewPager.setCurrentItem(1);
                mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home));
                mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan_select));
                mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car));
                mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine));
                mTabTextA.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextB.setTextColor(getResources().getColor(R.color.themes_color));
                mTabTextC.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextD.setTextColor(getResources().getColor(R.color.all_bg_color));
                break;
            case R.id.main_tab_fragment03_group:
                SubmitEvent("Tabbar_Activity");
                mViewPager.setCurrentItem(2);
                mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home));
                mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan));
                mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car_select));
                mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine));
                mTabTextA.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextB.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextC.setTextColor(getResources().getColor(R.color.themes_color));
                mTabTextD.setTextColor(getResources().getColor(R.color.all_bg_color));

                break;
            case R.id.main_tab_fragment04_group:
                SubmitEvent("Tabbar_Activity");
                mViewPager.setCurrentItem(3);
                mTabImageA.setImageDrawable(getResources().getDrawable(R.mipmap.icon_home));
                mTabImageB.setImageDrawable(getResources().getDrawable(R.mipmap.icon_dingdan));
                mTabImageC.setImageDrawable(getResources().getDrawable(R.mipmap.icon_car));
                mTabImageD.setImageDrawable(getResources().getDrawable(R.mipmap.icon_mine_select));
                mTabTextA.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextB.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextC.setTextColor(getResources().getColor(R.color.all_bg_color));
                mTabTextD.setTextColor(getResources().getColor(R.color.themes_color));
                break;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                showToast("再按一次退出");
                mExitTime = System.currentTimeMillis();
                return true;
            } else {
               //  MobclickAgent.onKillProcess(mContext);
               // UIManagerUtils.getAppManager().AppExit(mContext);
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
