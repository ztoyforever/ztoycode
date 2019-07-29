package com.example.androidadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    class myData{
        String name;
        int image;
        int t1;//体力
        int z1;//智力
        int w1;//武力
    }
    class myAdapter extends BaseAdapter{
        List<myData> mListDate;
        LayoutInflater mLayInflater;
        public myAdapter(List<myData> md, Context context){
            mListDate=md;
            mLayInflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return mListDate.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return mListDate.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            mViewHolder mVhd=null;
            if (convertView==null){
                mVhd=new mViewHolder();
                convertView=mLayInflater.inflate(R.layout.list_view,null);
                mVhd.name= (TextView) convertView.findViewById(R.id.textView3);
                mVhd.img= (ImageView) convertView.findViewById(R.id.imageView2);
                mVhd.pt1= (ProgressBar) convertView.findViewById(R.id.progressBar);
                mVhd.pz1= (ProgressBar) convertView.findViewById(R.id.progressBar2);
                mVhd.pw1= (ProgressBar) convertView.findViewById(R.id.progressBar3);
                convertView.setTag(mVhd);
            }else
                mVhd=(mViewHolder)convertView.getTag();
            mVhd.name.setText(mListDate.get(position).name);
            mVhd.img.setImageResource(mListDate.get(position).image);
            mVhd.pt1.setProgress(mListDate.get(position).t1);
            mVhd.pz1.setProgress(mListDate.get(position).z1);
            mVhd.pw1.setProgress(mListDate.get(position).w1);
            return convertView;
        }
        public class mViewHolder{
            public TextView name;
            public ImageView img;
            public ProgressBar pt1,pz1,pw1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1= (Button) findViewById(R.id.button);
        Button bt2= (Button) findViewById(R.id.button2);
        final ListView lv= (ListView) findViewById(R.id.listview1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<HashMap<String,Object>> Listdata=
                        new ArrayList<HashMap<String, Object>>();
                HashMap<String,Object> mp1=new HashMap<String,Object>();
                mp1.put("name"," 武松");
                mp1.put("ps","景阳冈打虎");
                mp1.put("img",R.drawable.p1);
                Listdata.add(mp1);
                HashMap<String,Object> mp2=new HashMap<String,Object>();
                mp2.put("name","鲁智深");
                mp2.put("ps","倒拔垂杨柳");
                mp2.put("img",R.drawable.p2);
                Listdata.add(mp2);
                SimpleAdapter mySAda=new SimpleAdapter(MainActivity.this,Listdata,
                        R.layout.layout,
                        new String[]{"name","ps","img"},
                        new int[]{R.id.textView,R.id.textView2,R.id.imageView});
                lv.setAdapter(mySAda);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<myData> mDate=new ArrayList<myData>();
                myData md1=new myData();
                md1.name="关羽";
                md1.image=R.drawable.p1;
                md1.t1=100;md1.z1=80;md1.w1=90;
                mDate.add(md1);
                myData md2=new myData();
                md2.name="张飞";
                md2.image=R.drawable.p2;
                md2.t1=90;md2.z1=70;md2.w1=80;
                mDate.add(md2);
                myAdapter mAda=new myAdapter(mDate,MainActivity.this);
                lv.setAdapter(mAda);

            }
        });

    }
}
