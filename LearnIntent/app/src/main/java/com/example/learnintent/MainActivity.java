package com.example.learnintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnStartMyAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this,MyAty.class));
                try {
                    startActivity(new Intent("com.example.learnintent.intent.action.MyAty", Uri.parse("app://hello")));
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"无法启动指定的Activity",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
