package lession.example.com.androidlession4_10;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final AnimationDrawable mAd = (AnimationDrawable) iv.getBackground();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAd.start();
            }
        });
    }
}
