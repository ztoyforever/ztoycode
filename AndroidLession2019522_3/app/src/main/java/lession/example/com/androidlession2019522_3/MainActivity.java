package lession.example.com.androidlession2019522_3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler hinHandler;
    TextView tv;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    tv.setText("线程计算结果："+msg.arg1);
                   // tv.setText("处理完毕");
            }
        }
    };
    private Thread mThread = new Thread(){
        @Override
        public void run() {
//            super.run();
//            SystemClock.sleep(2000);
//            Message msg = new Message();
//            msg.what = 1;
//            msg.obj = "获取数据：";
//            mHandler.sendMessage(msg);
            Looper.prepare();
            hinHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what){
                        case 1:
                            /*String st = "线程接收："+msg.obj.toString();
                            Toast.makeText(MainActivity.this,st,
                                    Toast.LENGTH_LONG).show();*/
                            int rz = msg.arg1+msg.arg2;
                            Message hinMsg = new Message();
                            hinMsg.what=1;hinMsg.arg1=rz;
                            mHandler.sendMessage(hinMsg);
                            break;
                    }
                }
            };
            Looper.loop();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        mThread.start();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mThread.start();
                Message msg = new Message();
                msg.what = 1;
                //msg.obj = "主线程传递的数据";
                msg.arg1 = 100;msg.arg2 = 200;
                hinHandler.sendMessage(msg);
            }
        });
    }
}
