package lession.example.com.android2019529;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.button);
        final TextView tv = (TextView) findViewById(R.id.textView);
        alarmMan = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h,m;
                Calendar cal = Calendar.getInstance();
                h = cal.get(Calendar.HOUR_OF_DAY);
                m = cal.get(Calendar.MINUTE);
                TimePickerDialog tpDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Calendar calSet = Calendar.getInstance();
                                calSet.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                calSet.set(Calendar.MINUTE,minute);
                                tv.setText("提醒时间："+hourOfDay+":"+minute);
                                Intent it = new Intent();
                                it.setAction("lession.example.com.android2019529");
                                PendingIntent pit =
                                        PendingIntent.getBroadcast(MainActivity.this,0,it,0);
                                alarmMan.set(AlarmManager.RTC_WAKEUP,calSet.getTimeInMillis(),pit);
                            }
                        },h,m,true);
                tpDialog.show();
            }

        });
    }
}
