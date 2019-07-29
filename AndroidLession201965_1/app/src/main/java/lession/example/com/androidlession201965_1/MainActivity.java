package lession.example.com.androidlession201965_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView mWv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWv = (WebView) findViewById(R.id.webView);
        Button bt = (Button) findViewById(R.id.button);
        final EditText ed = (EditText) findViewById(R.id.editText);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mWv.loadUrl("http://www.baidu.com");
                mWv.loadUrl(ed.getText().toString());
            }
        });

        mWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            mWv.goBack();
            return true;
        }else
        System.exit(0);

        return super.onKeyDown(keyCode, event);
    }
}
