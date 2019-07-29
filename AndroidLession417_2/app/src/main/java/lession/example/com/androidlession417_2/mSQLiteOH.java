package lession.example.com.androidlession417_2;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mSQLiteOH extends SQLiteOpenHelper {
    mSQLiteOH(Context ct, String name, SQLiteDatabase.CursorFactory cf,int vs){
        super(ct,name,cf,vs);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStr = "Create table Student(id integer,name text,pwd text)";
        db.execSQL(sqlStr);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
