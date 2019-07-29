package lession.example.com.androidlession616_2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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
        final TextView tv = (TextView) findViewById(R.id.textView);
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SensorManager mSManager = (SensorManager)
                        getSystemService(Context.SENSOR_SERVICE);
                Sensor mSen = mSManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                SensorEventListener mSEListener = new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {
                        tv.setText("光照强度为：\n"+event.values[0]+"勒克斯");
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                };
                mSManager.registerListener(mSEListener,mSen,SensorManager.SENSOR_DELAY_NORMAL);
            }
        });
    }
}
