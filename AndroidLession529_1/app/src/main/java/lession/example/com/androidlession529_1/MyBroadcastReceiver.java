package lession.example.com.androidlession529_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    String It_Ation = "lession.example.com.androidlession529_1";
    @Override
    public void onReceive(Context context, Intent intent) {
        String Ation = intent.getAction();
        if (It_Ation.equals(Ation)){
            Toast.makeText(context,"响应接收消息",Toast.LENGTH_LONG).show();
        }

    }
}
