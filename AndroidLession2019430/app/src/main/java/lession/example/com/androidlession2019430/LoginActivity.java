package lession.example.com.androidlession2019430;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context context;
    private RecycleAdapterDome adapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_login);
        recyclerView = (RecyclerView) findViewById(R.id.recy_view);
        list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("这是一个测试");
        }
        //初始化RecycleView
        adapter = new RecycleAdapterDome(context,list);
//        GridLayoutManager manager = new GridLayoutManager(context,4);
        //确定recycleview排列方式
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        //绑定排列方式
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }
}
