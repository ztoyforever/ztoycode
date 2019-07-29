package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textview);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_del).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
    }
    double d1,d2;//定义第一个操作数和第二个操作数
    String oprator="";//定义运算符
    @Override
    public void onClick(View v) {
        String str=textView.getText().toString();
        switch (v.getId()){
            //点击数字按钮和小数点时，在文本内追加内容
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_0:
            case R.id.btn_point:
                textView.setText(str + ((Button) v).getText().toString());
                break;
            case R.id.btn_add:
            case R.id.btn_minus:
            case R.id.btn_mul:
            case R.id.btn_div:
                d1 = Double.parseDouble(textView.getText().toString());
                // 点击运算符按钮时，获取前面输入的第一个运算符
                textView.setText(str + " " + ((Button) v).getText().toString() + " ");
                // 添加到文本区域内
                oprator = ((Button) v).getText().toString();// 获取点击的运算符
                break;
            case R.id.btn_clear:// 清空文本内容
                textView.setText("");
                break;
            case R.id.btn_del:// 点击删除按钮，删除一个字符
                if (str != null && !str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    textView.setText(str);
                }
                break;
            case R.id.btn_equal:// 计算结果方法，获取第二个输入的数字
                int start = str.lastIndexOf(oprator);
                d2 = Double.parseDouble(str.substring(start + 1, str.length()));
                getResult(d1, d2, oprator);
                break;
        }
    }
    private void getResult(double d1, double d2, String oprator) {
        String str = textView.getText().toString();
        double result = 0;
        if (oprator.equals("+")) {
            result = d1 + d2;
        } else if (oprator.equals("-")) {
            result = d1 - d2;
        } else if (oprator.equals("*")) {
            result = d1 * d2;
        } else if (oprator.equals("/")) {
            if (d2 == 0) {
                result = 0;
            } else {
                result = d1 / d2;
            }
        }

        // 如果不包含小数点则为小数和除法运算
        if (!str.contains(".") && oprator != "/") {
            textView.setText(((int) result) + "");
        } else {
            textView.setText(result + "");
        }

    }

}
