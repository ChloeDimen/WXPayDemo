package com.dimen.wxpay;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/**
 * 文件名：com.dimen.wxpay
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
public interface IWXSignCallBack {
    void onReq(BaseReq var1); //微信发送请求到APP后的回调
    void onResp(BaseResp var1); //APP发送请求到微信后的回调
}
