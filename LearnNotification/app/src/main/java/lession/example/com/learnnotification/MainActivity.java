package lession.example.com.learnnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    NotificationManager NotiMg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotiMg= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Button bt1= (Button) findViewById(R.id.button);
        Button bt2= (Button) findViewById(R.id.button2);
        Button bt3= (Button) findViewById(R.id.button3);
        final ListView listView=(ListView)findViewById(R.id.ListView1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder nfbd=new Notification.Builder(MainActivity.this);
                Intent it=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pit=PendingIntent.getActivity(MainActivity.this,0,it,0);
                nfbd.setContentTitle("天气预报");
                nfbd.setContentText("下雨了，天气湿冷，注意保暖！");
                nfbd.setSmallIcon(R.drawable.p1);
                nfbd.setContentIntent(pit);
                Notification nf=nfbd.build();
                NotiMg.notify(1,nf);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder nfbd=new Notification.Builder(MainActivity.this);
                RemoteViews rv=new RemoteViews(getPackageName(),R.layout.noti_layout);
                nfbd.setContentTitle("下载管理器");
                nfbd.setSmallIcon(R.drawable.p01);
                //nfbd.setContent(rv);
                Notification nf=nfbd.build();
                nf.contentView=rv;
                rv.setTextViewText(R.id.textView,"我的下载：");
                rv.setImageViewResource(R.id.imageView,R.drawable.p01);
                rv.setProgressBar(R.id.progressBar,100,50,false);
                NotiMg.notify(2,nf);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strArr=new String[]{"教授","副教授","讲师","助教"};
                ArrayAdapter<String> ArrApt=new ArrayAdapter<String>
                        (MainActivity.this,android.R.layout.simple_list_item_1,strArr);
                listView.setAdapter(ArrApt);
            }
        });
    }
}
