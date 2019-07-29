package com.example.a96349.intentactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv1=(TextView)findViewById(R.id.textView1);
        TextView tv2=(TextView)findViewById(R.id.textView2);
        Intent it=this.getIntent();
        Bundle bd=it.getExtras();
        //String na=bd.getString("name");
        //String a=bd.getString("age");

        tv1.setText(bd.getString("name"));
        tv2.setText(bd.getString("age"));
    }
}
