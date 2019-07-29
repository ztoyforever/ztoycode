package com.example.a96349.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(it);
                //Toast.makeText(MainActivity.this,"我的好消息", Toast.LENGTH_LONG).show();
            }
        });
        Log.e(TAG,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
