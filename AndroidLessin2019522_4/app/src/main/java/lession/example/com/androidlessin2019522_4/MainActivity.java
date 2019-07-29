package lession.example.com.androidlessin2019522_4;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    class mcAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            tv.setText("开始获取时间...请等待");
        }

        @Override
        protected String doInBackground(String... params) {
            SystemClock.sleep(5000);
            Time mt = new Time();
            mt.setToNow();
            String mtSt = params[0]+mt.format("%Y-%m-%d %H:%M:%S");
            return mtSt;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText("获取的时间是："+s);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final mcAsyncTask mATask = new mcAsyncTask();
        Button bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textview);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mATask.execute("我的时间");
            }
        });
    }
}
