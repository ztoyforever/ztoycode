package com.example.a96349.intentactivity;

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
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                Bundle bd=new Bundle();
                bd.putString("name","张三");
                bd.putString("age","18");
                //bd.putString("name",ed1.getText().toString());
                //bd.putString("age",ed2.getText().toString());
                it.putExtras(bd);
                it.setClass(MainActivity.this,Main2Activity.class);
                startActivity(it);
            }
        });
    }
}
