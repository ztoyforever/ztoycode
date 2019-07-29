package showproduct.example.com.productshow;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import bean.Account;
import dao.AccountDao;


public class MainActivity extends AppCompatActivity {
    private List<Account> list;
    private AccountDao dao;
    private EditText e1;
    private EditText e2;
    private MyAdapter adapter;
    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dao = new AccountDao(this);
        list=dao.queryAll();
        adapter = new MyAdapter();
        lv.setAdapter(adapter);
    }
    private void initView(){
        lv = (ListView) findViewById(R.id.listview1);
        e1 = (EditText) findViewById(R.id.productName);
        e2 = (EditText) findViewById(R.id.balance);
        lv.setOnItemClickListener(new MyOnItemClickListener());
    }
    public void add(View v) {
        String name = e1.getText().toString().trim();
        String balance = e2.getText().toString().trim();
        Account a = new Account(name, balance.equals("") ?0 : Integer.parseInt(balance));
        dao.insert(a);
        list.add(a);
        adapter.notifyDataSetChanged();
        lv.setSelection(lv.getCount() - 1);
        e1.setText("");
        e2.setText("");
    }

    private class MyAdapter extends BaseAdapter {
        public int getCount() {
            return list.size();
        }

        public Object getItem(int position) {
            return list.get(position);
        }
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null ? convertView : View.inflate(
                    getApplicationContext(), R.layout.item, null
            );
            TextView t1 = (TextView) item.findViewById(R.id.idTV);
            TextView t2 = (TextView) item.findViewById(R.id.nameTV);
            TextView t3 = (TextView) item.findViewById(R.id.balanceTV);
            final Account a = list.get(position);
            t1.setText(a.getId() + "");
            t2.setText(a.getName()+"");
            t3.setText(a.getBalance() + "");
            ImageView up = (ImageView) item.findViewById(R.id.addup);
            ImageView down = (ImageView) item.findViewById(R.id.adddown);
            ImageView delete = (ImageView) item.findViewById(R.id.delete);
            up.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    a.setBalance(a.getBalance() + 1);
                    notifyDataSetChanged();
                    dao.update(a);
                }
            });
            down.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    a.setBalance(a.getBalance() - 1);
                    notifyDataSetChanged();
                    dao.update(a);
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final DialogInterface.OnClickListener listener = new android.content.DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            list.remove(a);
                            dao.delete(a.getId());
                            notifyDataSetChanged();
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定", listener);
                    builder.setNegativeButton("取消", null);
                    builder.show();
                }
            });
            return item;
        }
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Account a = (Account)parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(),a.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
