package com.example.a96349.ientent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.button);
        Button bt2=(Button)findViewById(R.id.button2);
        Button bt3=(Button)findViewById(R.id.button3);
        Button bt4=(Button)findViewById(R.id.button4);
        final EditText ed1=(EditText)findViewById(R.id.editText);
        final EditText ed2=(EditText)findViewById(R.id.editText2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,Main2Activity.class);
                Bundle bd=new Bundle();
                bd.putString("name",ed1.getText().toString());
                bd.putString("age",ed2.getText().toString());
                it.putExtras(bd);
                startActivity(it);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setClass(MainActivity.this,Main3Activity.class);
                startActivity(it);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setAction(Intent.ACTION_VIEW);
                it.setData(Uri.parse("http://www.baidu.com"));

                startActivity(it);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setAction(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel://10086"));
                startActivity(it);
            }
        });
    }
}
