package com.gangzhongbrigade.app.ui;

import android.util.Log;
import android.widget.Toast;

import com.anye.greendao.gen.UserDao;
import com.gangzhongbrigade.app.GangzhongApplication;
import com.gangzhongbrigade.app.R;
import com.gangzhongbrigade.app.base.BaseActivity;
import com.gangzhongbrigade.app.dao.bean.User;

import java.util.List;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public class ActMain extends BaseActivity{
    @Override
    protected void initView() {
           setContentView(R.layout.act_main);
    }

    @Override
    protected void initData() {
        UserDao mUserDao = GangzhongApplication.getInstance().getDaoSession().getUserDao();
//        User mUser = new User(null,"anye7",111);
//        mUserDao.insert(mUser);//添加一个

        User findUser = mUserDao.queryBuilder().where(UserDao.Properties.Name.eq("anye3")).build().unique();
        if(findUser != null) {
            findUser.setName("没有意思");
            mUserDao.update(findUser);
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "用户不存在", Toast.LENGTH_SHORT).show();
        }
        List<User> users = mUserDao.loadAll();
        String userName = "";
        String id="";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName()+",";
            id+=users.get(i).getId()+",";
        }
        Log.i("INFO","username"+userName+"id"+id);
        User findUser2 =  mUserDao.queryBuilder().where(UserDao.Properties.Id.eq(4)).build().unique();
        if(findUser2 != null){
            mUserDao.deleteByKey(findUser2.getId());
        }else{
            Log.i("INFO","没有数据");
        }

        List<User> users4 = mUserDao.loadAll();
        String userName3 = "";
        String id2="";
        for (int i = 0; i < users4.size(); i++) {
            userName3 += users4.get(i).getName()+",";
            id2+=users.get(i).getId()+",";
        }
        Log.i("INFO","username3删除成功"+userName3+"id2"+id2);
    }
}
