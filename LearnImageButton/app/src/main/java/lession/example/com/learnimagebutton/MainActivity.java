package lession.example.com.learnimagebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN)//被按下时触发
                    ib.setImageResource(R.drawable.p1);
                else if (event.getAction()==MotionEvent.ACTION_UP)
                    ib.setImageResource(R.drawable.p2);
                return false;
            }
        });
    }
}
