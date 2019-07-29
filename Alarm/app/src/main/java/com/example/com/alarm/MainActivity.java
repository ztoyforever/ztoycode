package com.example.com.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent("MYALARMRECEIVER");
        intent.putExtra("msg","你该起床了");
        PendingIntent pi=PendingIntent.getBroadcast(this,0,intent,0);
        //创建PendingIntent对象封装Intent，由于是使用广播，注意使用getBroadcast方法
        //获取AlarmManager对象
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
       //设置闹钟从当前时间开始，每隔10分钟执行一次PendingIntent对象，
        // 注意第一个参数与第二个参数的关系
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),60*1,pi);
    }

}
