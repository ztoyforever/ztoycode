package lession.example.com.learncanvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        DrawPaint MyPaint = new DrawPaint(MainActivity.this);
        setContentView(MyPaint);
    }
}
