package lession.example.com.androidlession01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        DrawPaint myDp = new DrawPaint(MainActivity.this);
        setContentView(myDp);
        //FrameLayout fm = (FrameLayout) findViewById(R.id.frameLy1);
        //fm.addView(myDp);
//        Button bt1 = (Button) findViewById(R.id.button);
//        Button bt2 = (Button) findViewById(R.id.button2);
//        final Animation mAt = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
//        final Animation mAt1 = AnimationUtils.loadAnimation(this,R.anim.anim_rscom);
//        final ImageView iv = (ImageView) findViewById(R.id.imageView);
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iv.startAnimation(mAt);
//            }
//        });
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iv.startAnimation(mAt1);
//            }
//        });
    }
}
