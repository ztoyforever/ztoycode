package lession.example.com.android2019529;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("lession.example.com.android2019529".equals(intent.getAction())){
            Toast.makeText(context,"设定的时间到了",Toast.LENGTH_LONG).show();
            MediaPlayer mPlayer = MediaPlayer.create(context,R.raw.again);
            mPlayer.start();
        }
    }
}
