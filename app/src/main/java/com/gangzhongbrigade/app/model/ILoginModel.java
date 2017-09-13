package com.gangzhongbrigade.app.model;

import com.gangzhongbrigade.app.model.callback.HttpTaskCallback;
import com.gangzhongbrigade.app.model.response.LoginResponse;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public interface ILoginModel {
    void login(String account, String password, HttpTaskCallback<LoginResponse> callback);
}
