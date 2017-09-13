package com.gangzhongbrigade.app.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.gangzhongbrigade.app.R;
import com.gangzhongbrigade.app.base.BaseActivity;
import com.gangzhongbrigade.app.presenter.LoginPresenter;
import com.gangzhongbrigade.app.ui.view.ILoginView;
import com.gangzhongbrigade.app.widget.TopBarLayout;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public class ActLogin extends BaseActivity implements ILoginView, TextWatcher {

    @InjectView(R.id.login_top_bar)
    TopBarLayout loginTopBar;
    @InjectView(R.id.ed_username)
    EditText edUsername;
    @InjectView(R.id.ed_userpwd)
    EditText edUserpwd;
    @InjectView(R.id.iv_wx_login)
    ImageView ivWxLogin;
    @InjectView(R.id.iv_QQ_login)
    ImageView ivQQLogin;
    @InjectView(R.id.iv_wb_login)
    ImageView ivWbLogin;
    @InjectView(R.id.ll_content)
    AutoLinearLayout llContent;
    @InjectView(R.id.sl_view)
    ScrollView slView;
    @InjectView(R.id.btn_for_pwd)
    Button btnForPwd;
    @InjectView(R.id.btn_rsg)
    Button btnRsg;
    @InjectView(R.id.btn_gangzhong_login)
    Button btnGangzhongLogin;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void initView() {
        setContentView(R.layout.act_login);
    }

    @Override
    protected void initData() {
        mLoginPresenter = new LoginPresenter(ActLogin.this);
        canNext();
        edUsername.addTextChangedListener(this);
        edUserpwd.addTextChangedListener(this);
    }

    private void canNext() {
        //如果帐号程度不是11位数字,密码长度小于6,则登录按钮不可用
        if (edUsername.length() != 11 || edUserpwd.length() <6) {
            btnGangzhongLogin.setEnabled(false);
        } else {
            btnGangzhongLogin.setEnabled(true);
        }
    }

    @OnClick({R.id.btn_gangzhong_login, R.id.iv_wx_login, R.id.iv_QQ_login, R.id.iv_wb_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_gangzhong_login:
                //登录
                mLoginPresenter.login(edUsername.getText().toString(),edUserpwd.getText().toString());
                break;
            case R.id.iv_wx_login:
                break;
            case R.id.iv_QQ_login:
                break;
            case R.id.iv_wb_login:
                break;
        }
    }

    @Override
    public boolean isRememberPassword() {
        return false;
    }

    @Override
    public void startActMain() {
        showActivity(this, ActMain.class);
    }

    @Override
    public void setAccount(String account) {
        edUsername.setText(account);
    }

    @Override
    public void setPassword(String password) {
        edUserpwd.setText(password);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //输入变化时检查登录按钮是否可用
        canNext();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
