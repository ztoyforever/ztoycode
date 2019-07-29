package lession.example.com.androidlession529_1;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String It_Ation = "lession.example.com.androidlession529_1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyBroadcastReceiver myBCR = new MyBroadcastReceiver();
        IntentFilter itf = new IntentFilter(It_Ation);
        registerReceiver(myBCR,itf);
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(It_Ation);
                sendBroadcast(it);
            }
        });
    }
}
