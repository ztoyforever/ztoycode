package lession.example.com.androidlession2019616;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    SeekBar sBar;
    MediaPlayer mPlayer;
    Timer mTimer;
    int mDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.textView);
        Button btPlay = (Button) findViewById(R.id.button);
        Button btPause = (Button) findViewById(R.id.button2);
        Button btStop = (Button) findViewById(R.id.button3);
        sBar = (SeekBar) findViewById(R.id.seekBar);
        tv.setText("音乐播放器");
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer!=null){
                    mPlayer.start();
                    return;
                }
                try {
                    mPlayer = MediaPlayer.create(MainActivity.this,R.raw.again);
                    mDuration = mPlayer.getDuration();
                    sBar.setMax(mDuration);
                    mPlayer.start();
                    if (mTimer==null){
                        mTimer = new Timer();
                        mTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (mPlayer.isPlaying()==true){
                                    int mPosition = mPlayer.getCurrentPosition();
                                    sBar.setProgress(mPosition);
                                }
                            }
                        },0,1000);
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"音乐播放失败",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer!=null && mPlayer.isPlaying()==true){
                    mPlayer.pause();
                }
            }
        });
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayer!=null){
                    mTimer.cancel();
                    mTimer = null;
                    mPlayer.stop();
                    mPlayer.release();
                    mPlayer = null;
                    sBar.setProgress(0);
                }
            }
        });
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mPlayer==null){
                    seekBar.setProgress(0);
                }else if (fromUser==true){
                    mPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mPlayer==null){
                    Toast.makeText(MainActivity.this,"音乐播放器尚未准备好",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
