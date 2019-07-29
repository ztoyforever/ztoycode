package com.example.a96349.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display dp=getWindowManager().getDefaultDisplay();
        if (dp.getWidth()<dp.getHeight()){
            BlankFragment1 bf1=new BlankFragment1();
            getFragmentManager().beginTransaction().replace(R.id.activity_main,bf1).commit();
        }else {
            BlankFragment2 bf2=new BlankFragment2();
            getFragmentManager().beginTransaction().replace(R.id.activity_main,bf2).commit();

        }
    }
}
