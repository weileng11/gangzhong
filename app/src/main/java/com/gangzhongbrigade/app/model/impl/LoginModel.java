package com.gangzhongbrigade.app.model.impl;

import android.content.Context;

import com.gangzhongbrigade.app.model.ILoginModel;
import com.gangzhongbrigade.app.model.callback.HttpTaskCallback;
import com.gangzhongbrigade.app.model.response.LoginResponse;
import com.gangzhongbrigade.app.net.BaseNetEntity;
import com.gangzhongbrigade.app.net.OkHttpResponseCallback;
import com.gangzhongbrigade.app.net.RequestUrl;
import com.gangzhongbrigade.app.utils.EncodeUtil;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public class LoginModel implements ILoginModel{
    private Context mContext;
    public LoginModel(Context context) {
        mContext = context;
    }
    @Override
    public void login(String account, String password, final HttpTaskCallback<LoginResponse> callback) {
        BaseNetEntity baseNetEntity=new BaseNetEntity();
        String loginUrl= RequestUrl.getRequestPath(RequestUrl.SubPaths.Login_Tooth)+ account +
                "&Pwd=" + EncodeUtil.encode_MD5(password) + "&password" +
                "=" + EncodeUtil.encode_MD5(password);
        baseNetEntity.get2("正在登录中", false,loginUrl, new OkHttpResponseCallback<LoginResponse>(LoginResponse.class) {
            @Override
            public void onSuccess(LoginResponse bean) {
              callback.onTaskSuccess(bean);
            }

            @Override
            public void onFailError(String e) {
                callback.onTaskFailed(e);
            }
        });
    }


}
