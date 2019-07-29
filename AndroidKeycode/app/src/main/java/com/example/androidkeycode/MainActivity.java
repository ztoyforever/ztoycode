package com.example.androidkeycode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;
    int fontsize=20;
    GestureDetector gd;
    class myGueLsn extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            if (distanceY<0){
                if (fontsize>10)
                    fontsize=fontsize-2;
            }
            if (distanceY>0){
                if (fontsize<40)
                    fontsize=fontsize+2;
            }
            tv.setTextSize(fontsize);
            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt= (Button) findViewById(R.id.button);
        iv= (ImageView) findViewById(R.id.imageView);
        tv= (TextView) findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"短时点击按钮",
                        Toast.LENGTH_SHORT).show();
            }
        });
        bt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this,"长时点击按钮",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        gd=new GestureDetector(new myGueLsn());
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gd.onTouchEvent(event);
                return true;
            }
        });
    }
}
