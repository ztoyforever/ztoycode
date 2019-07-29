package lession.example.com.androidlession4_10_3;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class MainActivity extends AppCompatActivity {
    SharedPreferences msp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msp = getSharedPreferences("myfile", Context.MODE_PRIVATE);
        final EditText ed_name = (EditText) findViewById(R.id.editText);
        final EditText ed_pwd = (EditText) findViewById(R.id.editText2);
        Button bt_sps = (Button) findViewById(R.id.button);
        Button bt_spl = (Button) findViewById(R.id.button2);
        Button bt_datas = (Button) findViewById(R.id.button3);
        Button bt_datal = (Button) findViewById(R.id.button4);
        bt_sps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor mEdt = msp.edit();
                mEdt.putString("name",ed_name.getText().toString());
                mEdt.putString("pwd",ed_pwd.getText().toString());
                mEdt.commit();
            }
        });
        bt_spl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_name.setText(msp.getString("name",null));
                ed_pwd.setText(msp.getString("pwd",null));
            }
        });
        bt_datas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream mfos = openFileOutput("datafile",MODE_PRIVATE);
                    String st = ed_name.getText().toString();
                    byte[ ] buffer = st.getBytes();
                    mfos.write(buffer);
                    mfos.flush();
                    mfos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bt_datal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream mfis = openFileInput("datafile");
                    int len = mfis.available();
                    byte[ ] buffer = new byte[len];
                    mfis.read(buffer);
                    String st = new String(buffer);
                    ed_pwd.setText(st);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
