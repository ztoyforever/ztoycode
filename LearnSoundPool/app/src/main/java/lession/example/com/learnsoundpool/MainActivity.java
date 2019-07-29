package lession.example.com.learnsoundpool;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    int sid1,sid2,sid3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个最多支持5个流同时播放的类型标记为音乐的SoundPool
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        //使用load加载不同的音乐文件并获取ID
        sid1 = soundPool.load(getApplicationContext(),R.raw.again,1);
        sid2 = soundPool.load(getApplicationContext(),R.raw.snowflakes,1);
        sid3 = soundPool.load(getApplicationContext(),R.raw.weddingindream,1);
        //使用OnLoadCompleteListener监听是否加载完成
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Toast.makeText(getApplicationContext(),"音乐播放",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                soundPool.play(sid1,1,1,0,0,1);
                break;
            case R.id.button2:
                soundPool.play(sid2,1,1,0,0,1);
                break;
            case R.id.button3:
                soundPool.play(sid3,1,1,0,0,1);
                break;
        }
    }
}
