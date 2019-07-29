package lession.example.com.learncontentprovider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
/*
 * 获取手机联系人信息
 */
public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ListView实例
        ListView lv = (ListView) findViewById(R.id.listView);
        //获取Button实例
        Button bt = (Button) findViewById(R.id.button);
        ContentResolver cr = this.getContentResolver();
        final Cursor cs = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (cs.moveToNext()){
                    String name = cs.getString
                            (cs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cs.getString
                            (cs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    //添加信息
                    list.add(name+"\n"+number);
                }
                //更新适配器
                adapter.notifyDataSetChanged();
            }
        });
        //获取数据源
        list = new ArrayList<>();
        //创建适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        //设置适配器
        lv.setAdapter(adapter);
    }
}
