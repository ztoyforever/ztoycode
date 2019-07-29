package com.example.a96349.test;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class Main2Activity extends AppCompatActivity {
    private static final String TAG="Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(TAG,"2:--onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"2:--onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"2:--onResume");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"2:--onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"2:--onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"2:--onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"2:--onDestroy");
    }
}
