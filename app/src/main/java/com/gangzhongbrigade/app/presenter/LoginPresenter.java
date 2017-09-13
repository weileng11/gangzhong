package com.gangzhongbrigade.app.presenter;

import com.gangzhongbrigade.app.model.callback.HttpTaskCallback;
import com.gangzhongbrigade.app.model.impl.LoginModel;
import com.gangzhongbrigade.app.model.response.LoginResponse;
import com.gangzhongbrigade.app.ui.view.ILoginView;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public class LoginPresenter {
    private ILoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mLoginModel = new LoginModel(mLoginView.getContext());
    }

    public void login(String account, final String password) {
        mLoginView.showLoading("登录中...");
        mLoginModel.login(account, password, new HttpTaskCallback<LoginResponse>() {

            @Override
            public void onTaskFailed(String errorInfo) {
                mLoginView.hideLoading();
                mLoginView.showMsg(errorInfo);
            }

            @Override
            public void onTaskSuccess(LoginResponse data) {
                mLoginView.hideLoading();
                //进入主页
                mLoginView. startActMain();
            }
        });
    }
}
