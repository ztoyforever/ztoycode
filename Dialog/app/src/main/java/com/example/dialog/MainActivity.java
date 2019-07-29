package com.example.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int picWhich;
    boolean chk[]=new boolean[]{false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1=(Button)findViewById(R.id.button);
        Button bt2=(Button)findViewById(R.id.button2);
        Button bt3=(Button)findViewById(R.id.button3);
        Button bt4=(Button)findViewById(R.id.button4);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog adlg;
                AlertDialog.Builder adBb=new AlertDialog.Builder(MainActivity.this);
                adBb.setIcon(R.drawable.p1);
                adBb.setTitle(" 我的提示框");
                //adBb.setMessage("这是我通过程序创建的一个提示框，这里显示提示信息");
                adBb.setMessage("确定要关闭本应用程序吗？");
                adBb.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                adBb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ;
                    }
                });
                adlg=adBb.create();
                adlg.show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String[] starr=new String[]{"教师","公务员","律师","程序员"};
                AlertDialog adlg;
                adlg=new AlertDialog.Builder(MainActivity.this).setTitle("选择职业")
                        .setSingleChoiceItems(starr,0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                picWhich=which;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"你选定的职业是"
                                        +starr[picWhich],Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(" 取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                adlg.show();

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] starr=new String[]{"音乐","美术","舞蹈"," 运动"};

                AlertDialog adlg;
                adlg=new AlertDialog.Builder(MainActivity.this).setTitle("选择爱好")
                        .setMultiChoiceItems(starr, chk,
                                new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {
                                chk[which]=isChecked;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String st="";
                                for (int i=0;i<chk.length;i++)
                                    if (chk[i])
                                        st=st+starr[i]+" ";
                                Toast.makeText(MainActivity.this,"你选定的爱好有是"
                                        +st,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(" 取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                adlg.show();


            }
        });
    }
    public void ProOnClick(View v){
        Dialog pdlg;
        pdlg= ProgressDialog.show(MainActivity.this," 进度条对话框","");
    }
    public void SeekOnClick(View v){
        Dialog myDlg=new Dialog(MainActivity.this);
        myDlg.setTitle("拖动对话框：亮度调节");
        myDlg.setContentView(R.layout.seekbardlg);
        SeekBar sb=(SeekBar)myDlg.findViewById(R.id.seekBar);
        final TextView tv=(TextView)myDlg.findViewById(R.id.textView);
        sb.setMax(100);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("当前亮度为："+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        myDlg.show();
    }
}
