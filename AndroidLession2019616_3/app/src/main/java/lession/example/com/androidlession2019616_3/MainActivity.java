package lession.example.com.androidlession2019616_3;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取系统LocationManager服务
                final LocationManager mLm = (LocationManager)
                        getSystemService(Context.LOCATION_SERVICE);
//                if (mLm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//                    Toast.makeText(MainActivity.this,
//                            "请开启GPS导航",Toast.LENGTH_LONG).show();
//                    return;
//                }
                // 从GPS获取最近的定位信息
                Location mLct = mLm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                updateShow(mLct);
                mLm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        updateShow(location);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                        updateShow(mLm.getLastKnownLocation(provider));
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                        updateShow(null);
                    }
                });
            }
            private void updateShow(Location lc){
                if (lc!=null){
                    StringBuilder stbd = new StringBuilder();
                    stbd.append("当前位置信息：\n");
                    stbd.append("经度："+lc.getLongitude()+"\n");
                    stbd.append("纬度："+lc.getLatitude()+"\n");
                    stbd.append("高度："+lc.getAltitude()+"\n");
                    stbd.append("速度："+lc.getSpeed()+"\n");
                    stbd.append("方向："+lc.getBearing()+"\n");
                    stbd.append("定位精度："+lc.getAccuracy()+"\n");
                    tv.setText(stbd.toString());
                }else {
                    Toast.makeText(MainActivity.this,"未获取数据",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
