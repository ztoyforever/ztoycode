package com.example.androidservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyService mSvc;//定义服务实例对象
    boolean bound;
    private ServiceConnection sc=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //通过IBinder获取服务实例
            MyService.LBinder mBinder=(MyService.LBinder)service;
            mSvc=mBinder.getService();
            bound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound=false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1= (Button) findViewById(R.id.button);
        Button bt2= (Button) findViewById(R.id.button2);
        Button bt3= (Button) findViewById(R.id.button3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this,MyService.class));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this,MyService.class));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动绑定服务
                bindService(new Intent(MainActivity.this,MyService.class),
                        sc, Service.BIND_AUTO_CREATE);
                if (bound){
                    String nowT;
                    nowT=mSvc.getCrurentTime();
                    Toast.makeText(MainActivity.this,nowT, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
