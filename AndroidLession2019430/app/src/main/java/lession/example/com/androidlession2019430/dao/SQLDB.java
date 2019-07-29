package lession.example.com.androidlession2019430.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SQLDB {
    private DBUtil util;
    public SQLDB(Context context) {
        //初始化数据库和表的建立过程
        util = new DBUtil(context);
    }
    public int insert(Student student){
        SQLiteDatabase db = util.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",student.id);
        values.put("name",student.name);
        values.put("password",student.passWord);
        long start=db.insert("school", null, values);
        db.close();
        return (int) start;
    }
    public List<Student> query(String name){
        Student student=null;
        SQLiteDatabase db = util.getReadableDatabase();
        List<Student> list = new ArrayList<>();
        Cursor cursor=db.query("school", new String[]{"id", "name", "password"}, "name=?", new String[]{name}, null, null, null);
        //cursor.moveToNext() 判断下一个值有没有 有的话返回true 没有返回false
        while (cursor.moveToNext()){
            student = new Student();
            student.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.passWord = cursor.getString(cursor.getColumnIndex("password"));
            list.add(student);
        }
        return list;
    }
    public int delete(int id){
        SQLiteDatabase db = util.getWritableDatabase();
        //第一个参数数据库表名，where 条件  条件赋值
        int start = db.delete("school","id=?",new String[]{String.valueOf(id)});
        return start;
    }
    public int update(Student student){
        SQLiteDatabase db = util.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",student.id);
        values.put("name",student.name);
        values.put("password",student.passWord);
        int start = db.update("school",values,"id=?",new String[]{student.id+""+student.name+""+student.passWord});
        return start;
    }
}
