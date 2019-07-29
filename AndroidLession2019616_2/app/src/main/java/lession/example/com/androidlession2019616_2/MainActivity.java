package lession.example.com.androidlession2019616_2;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;
    private Button btPlay,btPause,btResume,btStop;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取VideoView、Button实例
        mVideoView = (VideoView) findViewById(R.id.videoView);
        btPlay = (Button) findViewById(R.id.button);
        btPause = (Button) findViewById(R.id.button2);
        btResume = (Button) findViewById(R.id.button3);
        btStop = (Button) findViewById(R.id.button4);
//        //设置视频路径
//        mVideoView.setVideoURI(Uri.parse(
//                "android.resource://lession.example.com.androidlession2019616_2/"
//                        +R.raw.video));
//        //与MediaController关联
//        mVideoView.setMediaController(new MediaController(MainActivity.this));
//        mVideoView.start();
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置视频路径
                mVideoView.setVideoURI(Uri.parse(
                        "android.resource://lession.example.com.androidlession2019616_2/" + R.raw.video));
                mVideoView.start();
            }
        });
        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                } else {
                    mVideoView.start();
                }
            }
        });
        btResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.resume();
            }
        });
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.stopPlayback();
            }
        });
    }

}
