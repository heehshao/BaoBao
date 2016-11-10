package com.example.a1.baobao.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.a1.baobao.R;
import com.example.a1.baobao.view.BBDialog;
import com.example.a1.baobao.view.SwipeBackLayout;

import org.xutils.x;

/**
 * Created by syc 2016/4/26.3.
 * 抽象类，基类，所有的Activity必须继承此类，便于集中添加友盟统计
 */
public abstract class BaseActivity extends FragmentActivity {

    protected View mView;
    // 标题内容
    protected LinearLayout mGroup;
    protected FrameLayout mRootView;
    protected Context mContext;
    protected BBDialog mDialog;
    int mMain = 0;
    //边缘退出view
    private SwipeBackLayout mSwipeBackLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);

       // mSwipeBackLayout = new SwipeBackLayout(this);
        // 设置视图
        mView = LayoutInflater.from(this).inflate(R.layout.activity_base, null);
        mGroup = (LinearLayout) mView.findViewById(R.id.base_group);
        mRootView = (FrameLayout) mView.findViewById(R.id.content);
//        // 设置TitleBar
//        mTitleBar = new CustomTitleBar(this, null);
//        // 左侧Button
//        mTitleBar.setBackButtonSize(30F);
//        mTitleBar.setBackButtonColor(getResources().getColor(R.color.white));
//        // 右侧Button
//        mTitleBar.setSettingButtonSize(30F);
//        mTitleBar.setSettingButtonColor(getResources().getColor(R.color.white));
//        // 设置标题
//        mTitleBar.setTitleContent(setTitleContent());
//        mTitleBar.setTitleSize(18F);
//        mTitleBar.setTitleColor(getResources().getColor(R.color.white));
//
//        mTitleBar.setBackgroundColor(getResources().getColor(R.color.yk_gray_dark));
        // 添加View
       // LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setContentView(mView);
        mContext = this;
      //  ((ViewGroup) mView).addView(mTitleBar, 0, params);
        x.view().inject(this);
       // UIManagerUtils.getAppManager().addActivity(this);

        String title = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
       // mTitleBar.setVisibility(View.GONE);
        initListener();
        initData();
    }

    /**
     * 设置标题内容
     *
     * @return
     */
    protected abstract String setTitleContent();



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        if (mMain == 0) {
//            mSwipeBackLayout.attachToActivity(this);
//        }
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v != null)
            return v;
        return mSwipeBackLayout.findViewById(id);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }

    public void setSwipeBackEnable(boolean enable) {
        mSwipeBackLayout.setEnableGesture(enable);
    }

    /**
     * slide from left
     */
    public void setEdgeFromLeft() {
        final int edgeFlag = SwipeBackLayout.EDGE_LEFT;
        mSwipeBackLayout.setEdgeTrackingEnabled(edgeFlag);
    }

    /**
     * 设置布局View
     */

    /**
     * Scroll out contentView and finish the activity
     */
    public void scrollToFinishActivity() {
        mSwipeBackLayout.scrollToFinishActivity();
    }

    /**
     * 设置背景色
     *
     * @param color
     */
    public void setWindowBackground(String color) {
        mGroup.setBackgroundColor(Color.parseColor(color));
    }

    /**
     * 初始化widget组件
     *
     * @param id
     * @return
     */
    protected View findViewbyId(int id) {
        if (mView != null) {
            return mView.findViewById(id);
        }
        return null;
    }

    /**
     * 初始化widget组件事件
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 提示
     */
    protected void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 使用沉浸式状态栏
     */
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

//    public void setTitle(CharSequence title) {
//        mTitleBar.setTitleContent(title.toString());
//    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, mRootView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().getDecorView().invalidate();
        // JPushInterface.onResume(this);
//          MobclickAgent.onResume(this);
//         MobclickAgent.onPageStart(setTitleContent());
//          MobclickAgent.onResume(this);
//        JPushInterface.onResume(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // JPushInterface.onPause(this);
//        MobclickAgent.onPause(this);
//        MobclickAgent.onPageEnd(setTitleContent());
//        MobclickAgent.onPause(this);
        // JPushInterface.onPause(this);

    }

    /**
     * 快速 Intent
     *
     * @param cla 目标class
     */
    public void goIntent(Class cla) {
        Intent intent = new Intent(mContext, cla);
        startActivity(intent);
    }

    /**
     * 快速 Intent
     *
     * @param cla    目标class
     * @param bundle 传递参数
     */
    public void goIntent(Class cla, Bundle bundle) {
        Intent intent = new Intent(mContext, cla);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 快速 Intent
     *
     * @param cla 目标class
     */
    public void goIntent(Class cla, String title) {
        Intent intent = new Intent(mContext, cla);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.gc();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    /**
     * 显示提示框 有文字
     */
    public void showLoding(String title, boolean flag) {
        mDialog = new BBDialog(mContext);
        mDialog.setCancelable(flag);
        mDialog.setContentTv(title);
        mDialog.show();
    }

    /**
     * 显示提示框 默认文字
     */
    public void showLoding(boolean flag) {
        showLoding("加载中", flag);
    }

    /**
     * 取消加载框
     */
    public void stopLoding() {
        if (mDialog != null) {
            if (mDialog.isShowing()) {
                mDialog.dismiss();
                mDialog = null;
            }
        }
    }

    public void SubmitEvent(String key) {
        //  MobclickAgent.onEvent(this, key);
    }


}
