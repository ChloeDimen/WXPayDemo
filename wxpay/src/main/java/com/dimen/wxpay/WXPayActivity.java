package com.dimen.wxpay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * 文件名：com.dimen.wxpay
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
public abstract class WXPayActivity extends AppCompatActivity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeChatAPI.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }
}
