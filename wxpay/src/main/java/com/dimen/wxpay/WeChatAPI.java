package com.dimen.wxpay;

import android.content.Context;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 文件名：com.dimen.wxpay
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
public class WeChatAPI {
    private IWXAPI iwxapi;
    //微信登录回调接口
    private IWXSignCallBack weChatSignInCallBack;
    private Context mContext;

    private static final class Holder {
        private static final WeChatAPI WECHAT_API = new WeChatAPI();
    }

    public static WeChatAPI getInstance() {
        return Holder.WECHAT_API;
    }

    private WeChatAPI() {
        //实例化IWXAPI
        iwxapi = WXAPIFactory.createWXAPI(mContext, Config.APP_ID, true);
        iwxapi.registerApp(Config.APP_ID);
    }

    // 获取到 IWXAPI
    public final IWXAPI getWXAPI() {
        return iwxapi;
    }

    //设置微信登录回调接口
    public WeChatAPI setSingInCallBack(IWXSignCallBack weChatSignInCallBack) {
        this.weChatSignInCallBack = weChatSignInCallBack;
        return this;
    }

    //获取到微信登录回调接口
    public IWXSignCallBack getWeChatSignInCallBack() {
        return weChatSignInCallBack;
    }


    /**
     * 发起登录
     */
    public void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        iwxapi.sendReq(req);
    }


}
