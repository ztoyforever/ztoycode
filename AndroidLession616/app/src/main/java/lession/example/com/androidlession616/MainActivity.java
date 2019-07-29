package lession.example.com.androidlession616;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3;
    private float x, y, z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过服务得到传感器管理对象
                SensorManager sensorMgr = (SensorManager)
                        getSystemService(SENSOR_SERVICE);
                //得到重力传感器实例
                //TYPE_ACCELEROMETER 加速度传感器(重力传感器)类型。
                //TYPE_ALL 描述所有类型的传感器。
                //TYPE_GYROSCOPE 陀螺仪传感器类型
                //TYPE_LIGHT 光传感器类型
                //TYPE_MAGNETIC_FIELD 恒定磁场传感器类型。
                //TYPE_ORIENTATION 方向传感器类型。
                //TYPE_PRESSURE 描述一个恒定的压力传感器类型
                //TYPE_PROXIMITY 常量描述型接近传感器
                //TYPE_TEMPERATURE 温度传感器类型描述
                final Sensor sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                SensorEventListener lsn = new SensorEventListener() {
                    @SuppressWarnings("deprecation")//表示不检测过期的方法
                    //传感器获取值改变时响应此函数
                    public void onSensorChanged(SensorEvent e) {
                        x = e.values[0];
                        y = e.values[1];
                        z = e.values[2];
//                        x = e.values[SensorManager.DATA_X];
//                        y = e.values[SensorManager.DATA_Y];
//                        z = e.values[SensorManager.DATA_Z];
                        tv1.setText("x=" + x );//手机水平放置，左右x值
                        tv2.setText("y=" + y );//手机水平放置，前后y值
                        tv3.setText("z=" + z );//手机竖直放置，上下z值
                    }

                    public void onAccuracyChanged(Sensor s, int accuracy) {
                    }
                };
                //注册listener，第三个参数是检测的精确度
                sensorMgr.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);

            }
        });
    }
}