package com.example.activitylearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("2--onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("2--onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("2--onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("2--onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("2--onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("2--onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("2--onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("2--onDestroy");
    }
}
