package lession.example.com.androidlession2019522_2;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private void ComTask(){
        SystemClock.sleep(5000);
    }
    TextView tv;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    tv.setText("线程消息："+msg.obj.toString());
                    break;
            }
        }
    };
    private Thread mThread = new Thread(){
        @Override
        public void run() {
            ComTask();
            Message msg = new Message();
            msg.what = 1;msg.obj = "已经处理完毕任务";
            mHandler.sendMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mThread.start();
            }
        });
    }
}
