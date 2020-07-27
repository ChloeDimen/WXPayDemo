package com.dimen.wxpaydemo;

import android.app.Application;

import com.dimen.wxpay.BaseWXPayActivity;
import com.dimen.wxpay_annoations.WXPayEntry;

/**
 * 文件名：com.dimen.wxpaydemo
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
@WXPayEntry(packageName = "com.dimen.wxpaydemo",entryClass = BaseWXPayActivity.class)
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
