package lession.example.com.androidlession2019617;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String operatorName;//营运商名字
    private int netWorkState;//网络为：2G、3G、4G
    private boolean netConnected;//是否有网络
    private boolean wifiConnected;//网络是否为wifi
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        operatorName = NetUtils.getOperatorName(this);
        netWorkState = NetUtils.getNetworkState(this);
        netConnected = NetUtils.isNetConnected(this);
        wifiConnected = NetUtils.isWifiConnected(this);
        tv.setText("运营商名字："+operatorName+"\n网络为："+netWorkState
                +"\n是否有网络："+netConnected+"\n网络是否为wifi："+wifiConnected);
        Log.e("运营商名字", operatorName + "");
        Log.e("网络为", netWorkState + "");
        Log.e("是否有网络", netConnected + "");
        Log.e("网络是否为wifi", wifiConnected + "");
    }
}
