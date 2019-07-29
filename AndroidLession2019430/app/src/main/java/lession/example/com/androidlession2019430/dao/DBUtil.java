package lession.example.com.androidlession2019430.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {
    public static final String NAME = "school.db";
    public DBUtil( Context context) {
        super(context, NAME, null, 1);
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table school(id Integer primary key,name text,password text)");
    }
    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
