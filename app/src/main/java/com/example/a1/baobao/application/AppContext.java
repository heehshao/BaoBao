package com.example.a1.baobao.application;

import android.app.Application;
import android.graphics.Typeface;

import com.example.a1.baobao.dao.ConstantValue;
import com.orhanobut.logger.Logger;
import com.umeng.socialize.PlatformConfig;

import java.io.File;

/**
 * Created by syc on 2016/11/10.
 */
public class AppContext extends Application {

   public static AppContext mApp;
   private static final String TAG = "AppContext";
//    /**
//     * 引导箭头
//     */
//    public static Typeface getGuideData() {
//     //   return Typeface.createFromAsset(mApp.getAssets(), "guide_icon.ttf");
//        return Typeface.createFromAsset(mApp.getAssets(), "guide_icon.ttf");
//
//
//    }

   public static Typeface getMovieIcon() {
      return Typeface.createFromAsset(mApp.getAssets(), "movie_select_icon.ttf");
   }
   @Override
   public void onCreate() {
      super.onCreate();
      mApp = this;
      Logger.init(TAG);
   }
//      MultiDex.install(this);
//      SysUtil.setApplication(this);
////      YWAPI.setEnableCrashHandler(true);
//      if (SysUtil.isTCMSServiceProcess(this)) {
//         return;
//      }
////第一个参数是Application Context
////这里的APP_KEY即应用创建时申请的APP_KEY，同时初始化必须是在主进程中
//      if (SysUtil.isMainProcess(this)) {
//         YWAPI.init(this,IMHelper.APP_KEY);
//      }
//      initUmeng();
//   }

    private void initUmeng() {
      //  MobclickAgent.openActivityDurationTrack(false);
        PlatformConfig.setWeixin(ConstantValue.WX_ID, ConstantValue.WX_SECRET);

        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone(ConstantValue.QQ_ID, ConstantValue.QQ_KEY);
        PlatformConfig.setSinaWeibo(ConstantValue.XL_ID,ConstantValue.XL_SECRET);
    }


}
