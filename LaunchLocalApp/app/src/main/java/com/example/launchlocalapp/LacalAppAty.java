package com.example.launchlocalapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LacalAppAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lacal_app_aty);

        Uri uri=getIntent().getData();
        System.out.println(uri);
    }
}
