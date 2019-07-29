package lession.example.com.learnanimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button) findViewById(R.id.button);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt3 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.button4);
        Button bt5 = (Button) findViewById(R.id.button5);
        final Animation mAt1 = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        final Animation mAt2 = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        final Animation mAt3 = AnimationUtils.loadAnimation(this,R.anim.anim_rotate);
        final Animation mAt4 = AnimationUtils.loadAnimation(this,R.anim.anim_translate);
        final Animation mAt5 = AnimationUtils.loadAnimation(this,R.anim.anim_rs);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(mAt1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(mAt2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(mAt3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(mAt4);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.startAnimation(mAt5);
            }
        });
    }
}
