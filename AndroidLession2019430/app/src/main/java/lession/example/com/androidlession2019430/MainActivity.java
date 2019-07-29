package lession.example.com.androidlession2019430;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import lession.example.com.androidlession2019430.dao.SQLDB;
import lession.example.com.androidlession2019430.dao.Student;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TopView topView;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        topView = (TopView) findViewById(R.id.top_view);
        topView.setTxtText("这是java测试");
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLDB sqldb = new SQLDB(context);
                Student student = new Student();
                student.id = 1;
                student.name = "lili";
                student.passWord = "这是一个测试";
                sqldb.insert(student);
                List<Student> list = sqldb.query("lili");
                Toast.makeText(context, list.get(0).passWord, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
