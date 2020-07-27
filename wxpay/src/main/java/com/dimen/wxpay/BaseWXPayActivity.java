package com.dimen.wxpay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telecom.Call;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 文件名：com.dimen.wxpay
 * 描    述：这个类是用来处理微信支付的一些业务逻辑的，微信回调的Activity
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
public class BaseWXPayActivity extends WXPayActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //再次进入这个页面直接消失
        finish();
        //无动画效果
        overridePendingTransition(0, 0);
    }

    //微信请求第三方应用回调
    @Override
    public void onReq(BaseReq baseReq) {


    }

    //微信响应第三方应用回调
    @Override
    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode == BaseResp.ErrCode.ERR_OK) {
            getAccessToken(((SendAuth.Resp) baseResp).code);
        } else {
            Toast.makeText(this, "微信授权登录失败", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //获取到token
    private void getAccessToken(String code) {
        /*OkHttpUtils.get("https://api.weixin.qq.com/sns/oauth2/access_token?APPID=" + Config.APP_ID +
                "&secret=" + Config.APP_SECRET +
                "&code=" + code +
                "&grant_type=authorization_code").tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        try {
                            JSONObject object = new JSONObject(s);
                            String acceeeToken = object.getString("access_token");
                            String open_id = object.getString("openid");
                            getInfo(acceeeToken, open_id);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WeChatSignTemple.this, "微信授权登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        Toast.makeText(WeChatSignTemple.this, "微信授权登录失败", Toast.LENGTH_SHORT).show();
                    }
                });*/
    }

    //获取用户数据
    private void getInfo(String at, String open_id) {
       /* OkHttpUtils.get("https://api.weixin.qq.com/sns/userinfo?access_token="
                + at + "&openid=" + open_id).tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        WeChatAPI.getInstance().getWeChatSignInCallBack().signSuccess(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Toast.makeText(WeChatSignTemple.this, "微信授权登录失败", Toast.LENGTH_SHORT).show();
                    }
                });*/
    }

}
