package com.gangzhongbrigade.app;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;

import java.util.ArrayList;

/**
 * Author:Bruce
 * time:2017/8/29.
 * contact：weileng143@163.com
 *
 * @description
 */

public class GangzhongApplication extends Application {
    //数据库
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static GangzhongApplication applicationContext = null;
    // 存储打开的activity，用于重新启动activity时候用
    public static ArrayList<Activity> activityList = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        setDatabase();
    }

    public static GangzhongApplication getInstance() {
        return (GangzhongApplication) applicationContext;
    }

    /**
     * 销毁全部界面
     */
    public void finishAllActivity() {
        if (activityList != null) {
            for (Activity activity : activityList) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            activityList.clear();
        }
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
    //http://www.jianshu.com/p/4986100eff90
}
