package lession.example.com.androidlession417_3;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PhoneDto> phoneDtos;
    private ListView lv_main_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check();
    }
    /**
     * 检查权限
     */
    private void check() {
        //判断是否有权限
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_CONTACTS},201);
        }else{
            initViews();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==201){
            initViews();
        }else{
            return;
        }
    }

    private void initViews() {
        PhoneUtil phoneUtil = new PhoneUtil(this);
        phoneDtos = phoneUtil.getPhone();
        lv_main_list = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter();
        lv_main_list.setAdapter(myAdapter);
    }
    //自定义适配器
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return phoneDtos.size();
        }

        @Override
        public Object getItem(int position) {
            return phoneDtos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @SuppressLint("NewApi")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            PhoneDto phoneDto = phoneDtos.get(position);
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new
                    LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;
            TextView tv_name = new TextView(MainActivity.this);
            tv_name.setId(View.generateViewId());
            tv_name.setLayoutParams(layoutParams);
            tv_name.setText(phoneDto.getName());
            TextView tv_num = new TextView(MainActivity.this);
            tv_num.setId(View.generateViewId());
            tv_num.setLayoutParams(layoutParams);
            tv_num.setText(phoneDto.getTelPhone());
            linearLayout.addView(tv_name);
            linearLayout.addView(tv_num);
            return linearLayout;
        }
    }
}