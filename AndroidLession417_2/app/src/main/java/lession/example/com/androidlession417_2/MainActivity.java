package lession.example.com.androidlession417_2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btoh_wt = (Button) findViewById(R.id.button);
        Button btoh_rd = (Button) findViewById(R.id.button2);
        Button btdb_wt = (Button) findViewById(R.id.button3);
        Button btdb_rd = (Button) findViewById(R.id.button4);
        final ListView lv = (ListView) findViewById(R.id.listView);
        final mSQLiteOH mdbh = new mSQLiteOH(this,"stu.db",null,1);
        final SQLiteDatabase mSqldb = openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        btoh_wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mdbh.getWritableDatabase();
                db.execSQL("insert into student values(1,'zhao','123')");
                db.execSQL("insert into student(name,pwd) values('qian','456')");
                db.execSQL("insert into student values(?,?,?)",new Object[]{3,"sun","789"});
                db.execSQL("insert into student values(4,'li','000')");
            }
        });
        btoh_rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mdbh.getReadableDatabase();
                Cursor mCs = db.rawQuery("select * from student",null);
                String dbStr[] = new String[mCs.getCount()];
                mCs.moveToFirst();
                for (int i=0;i<mCs.getCount();i++){
                    dbStr[i] = "记录"+i+"："+mCs.getInt(0)+" "+mCs.getString(1)+" "+mCs.getString(2);
                    mCs.moveToNext();
                }
                ArrayAdapter<String> mAd = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,dbStr);
                lv.setAdapter(mAd);
            }
        });
        btdb_wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSqldb != null){
                    mSqldb.execSQL("drop table if exists person");
                    mSqldb.execSQL("create table person(id integer,name text,pwd text)");
                }
                mSqldb.execSQL("insert into person values(101,'zhangsan','123')");
                mSqldb.execSQL("insert into person values(?,?,?)",new Object[]{102,"lisi","456"});
                mSqldb.execSQL("insert into person values(103,'wangwu','789')");
                ContentValues cv = new ContentValues();
                cv.put("id",104);
                cv.put("name","zhaoliu");
                cv.put("pwd","000");
                mSqldb.insert("person",null,cv);
            }
        });
        btdb_rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor mCs = mSqldb.rawQuery("select * from person",null);
                String[] dataSt = new String[mCs.getCount()];
                mCs.moveToFirst();
                for (int i=0;i<mCs.getCount();i++){
                    int id = mCs.getInt(0);
                    String name = mCs.getString(1);
                    String pwd = mCs.getString(mCs.getColumnIndex("pwd"));
                    dataSt[i] = "person"+i+":"+id+" "+name+" "+pwd;
                    mCs.moveToNext();
                }
                ArrayAdapter<String> mAda = new ArrayAdapter<String>(MainActivity.
                        this,android.R.layout.simple_list_item_1,dataSt);
                lv.setAdapter(mAda);
            }
        });
    }
}
