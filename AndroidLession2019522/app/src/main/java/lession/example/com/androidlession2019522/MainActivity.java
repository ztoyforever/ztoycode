package lession.example.com.androidlession2019522;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int count;
    class mThread extends Thread{
        mThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while (count<10000)
                Log.e("MainActivity",
                        Thread.currentThread().getName()+"--->"+count++);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                mThread mt1 = new mThread("Td1");
                mThread mt2 = new mThread("Td2");
                mThread mt3 = new mThread("Td3");
                mt1.start();
                mt2.start();
                mt3.start();
            }
        });
    }
}
