package com.example.androidbutton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1=(Button) findViewById(R.id.button1);
        Button bt2=(Button) findViewById(R.id.button2);
        Button bt3=(Button) findViewById(R.id.button3);
        final Button bt4=(Button) findViewById(R.id.button4);
        final Button bt5=(Button) findViewById(R.id.button5);
        final Button bt6=(Button) findViewById(R.id.button6);
        final TextView tv=(TextView) findViewById(R.id.textView);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("监听按钮1被按下");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("监听按钮2被按下");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("监听按钮3被按下");
            }
        });
        View.OnClickListener MyCListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==bt4.getId())
                    tv.setText("共用监听器按钮1被按下");
                else if (v.getId()==bt5.getId())
                    tv.setText("共用监听器的按钮2被按下");
                else
                    tv.setText("共用监听器的按钮3被按下");
            }
        };
        bt4.setOnClickListener(MyCListener);
        bt5.setOnClickListener(MyCListener);
        bt6.setOnClickListener(MyCListener);
    }
}
