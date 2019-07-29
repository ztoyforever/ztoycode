package com.example.menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textView);
        iv= (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(tv);
        registerForContextMenu(iv);
        Button bt1= (Button) findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"这是一个通知",Toast.LENGTH_LONG).show();
                //Toast tot=Toast.makeText(MainActivity.this,"这是一个通知",Toast.LENGTH_LONG);
                //tot.setGravity(Gravity.CENTER,0,0);
                //tot.show();
            }
        });
        Button bt2= (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lyIF=MainActivity.this.getLayoutInflater();
                View toastView=lyIF.inflate(R.layout.toast_layout,null);
                TextView tv=(TextView)toastView.findViewById(R.id.textView2);
                ImageView iv= (ImageView) toastView.findViewById(R.id.imageView2);
                iv.setImageResource(R.drawable.p1);
                tv.setText("这是自定义的Toast");
                Toast ts=new Toast(MainActivity.this);
                ts.setDuration(Toast.LENGTH_LONG);
                ts.setView(toastView);
                ts.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==tv.getId()) {
            //menu.add(0,0,0,"打开");
            menu.add(0, 0, 0, "大号字体");
            //menu.add(0,1,1,"保存");
            menu.add(0, 1, 1, "小号字体");
            //SubMenu sm1=menu.addSubMenu(0,2,2,"编辑");
            SubMenu sm1 = menu.addSubMenu(0, 2, 2, "颜色");
            //sm1.add(0,3,3,"复制");
            //sm1.add(0,4,4,"粘贴");
            sm1.add(0, 3, 3, "黑色");
            sm1.add(0, 4, 4, "红色");
        }else {
            menu.add(1,5,5,"图片信息");
            menu.add(1,6,6,"图片说明");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                tv.setTextSize(32);
                break;
            case 1:
                tv.setTextSize(16);
                break;

            case 3:
                tv.setTextColor(Color.BLACK);
                break;
            case 4:
                tv.setTextColor(Color.RED);
                break;
            case 5:
                Toast.makeText(this,"png格式图片，分辨率64",Toast.LENGTH_LONG).show();
                break;
            case 6:
                Toast.makeText(this,"这是安卓机器人的图片",Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub1=menu.addSubMenu(0,0,0,"文件");
        SubMenu sub2=menu.addSubMenu(0,1,1,"编辑");
        sub1.add(0,2,2,"打开");
        sub1.add(0,3,3,"保存");
        sub1.add(0,4,4,"另存为");
        sub2.add(0,5,5,"复制");
        sub2.add(0,6,6,"粘贴");
        menu.add(0,7,7,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 7:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

