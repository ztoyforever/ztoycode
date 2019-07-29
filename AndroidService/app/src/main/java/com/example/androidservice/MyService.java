package com.example.androidservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.format.Time;

public class MyService extends Service{
    MediaPlayer mediaPlayer;
    public class LBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
    private final IBinder ibinder=new LBinder();//定义IBinder对象
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return ibinder;//绑定服务时，返回IBinder对象
    }

    public String getCrurentTime(){
        Time t=new Time();
        t.setToNow();
        String ct= t.format("%Y-%m-%d %H:%M:%S");
        return ct;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.kalimba);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
