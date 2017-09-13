package com.gangzhongbrigade.app.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.gangzhongbrigade.app.GangzhongApplication;
import com.gangzhongbrigade.app.utils.T;

import butterknife.ButterKnife;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ButterKnife.inject(this);
        initData();
        ((GangzhongApplication)getApplication()).activityList.add(this);
    }

    /**
     * 初始化界面布局
     */
    protected abstract void initView();

    /**
     * 初始化界面数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        ((GangzhongApplication)getApplication()).activityList.remove(this);
        super.onDestroy();
    }

    /**
     * 返回键
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Class<?> cls) {
        showActivity(aty, cls);
        aty.finish();
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Intent it) {
        showActivity(aty, it);
        aty.finish();
    }

    /**
     * 跳转后，当前界面自销毁
     */
    public void skipActivity(Activity aty, Class<?> cls, Bundle extras) {
        showActivity(aty, cls, extras);
        aty.finish();
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Intent it) {
        aty.startActivity(it);
    }

    /**
     * Activity跳转
     */
    public void showActivity(Activity aty, Class<?> cls, Bundle extras) {
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.setClass(aty, cls);
        aty.startActivity(intent);
    }

    ProgressDialog dialog;

    public void showLoading() {
        showLoading("正在加载,请稍后...");
    }

    public void showLoading(String message) {
        // loadingMsg.setText(message);
        // loadingView.setVisibility(View.VISIBLE);
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
        }
        dialog.setMessage(message);
        dialog.show();
    }

    public void hideLoading() {
        // loadingView.setVisibility(View.GONE);
        dialog.dismiss();
    }

    public Context getContext() {
        return getApplicationContext();
    }
    public void showMsg(String msg) {
        T.showShort(this, msg);
    }
}
