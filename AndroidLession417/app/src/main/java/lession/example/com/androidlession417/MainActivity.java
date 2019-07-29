package lession.example.com.androidlession417;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static void verifyStoragePermissions(AppCompatActivity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_sdsave = (Button) findViewById(R.id.button);
        Button bt_sdsload = (Button) findViewById(R.id.button2);
        Button bt_sddir = (Button) findViewById(R.id.button3);
        final ListView lv = (ListView) findViewById(R.id.listView);
        verifyStoragePermissions(this);
        bt_sdsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = Environment.getExternalStorageDirectory();
                String st = "我要写入的文件的内容！";
                File saveFile = new File(path,"mySDfile");
                try {
                    FileOutputStream mfos = new FileOutputStream(saveFile);
                    mfos.write(st.getBytes());
                    mfos.flush();
                    mfos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bt_sdsload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = Environment.getExternalStorageDirectory();
                String st;
                File loadFile = new File(path,"mySDfile");
                try{
                    FileInputStream mfis = new FileInputStream(loadFile);
                    int len = mfis.available();
                    byte[] buffer = new byte[len];
                    mfis.read(buffer);
                    st = new String(buffer);
                    Toast.makeText(MainActivity.this,
                            "文件内容:"+st,Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        /*遍历SD卡中目录及文件的方法：
        通过创建File[]数组类型对象，利用构造函数获取
        File[] files=new File(filepath).listFiles();
        使用ListView控件来显示目录
        使用ArrayAdapter将目录中的信息，绑定到ListView中显示
        使用ListView控件的点击事件，来进入选中的目录
        主要函数实现：
        获取选定文件夹中的文件列表，
        将文件列表显示到到ListView中*/

        bt_sddir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = Environment.getExternalStorageDirectory();
                File[] mFs = new File(path.toString()).listFiles();
                ArrayAdapter<File> mAda = new ArrayAdapter<File>
                        (MainActivity.this,android.R.layout.simple_list_item_1,mFs);
                lv.setAdapter(mAda);
            }
        });
    }
}
