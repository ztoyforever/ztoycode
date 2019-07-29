package lession.example.com.androidlession2019430;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopView extends RelativeLayout {
    private ImageView imgView;
    private TextView txtView;
    public TopView(Context context) {
        this(context,null);
    }
    //layout xml调用的
    public TopView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }
    //style 里面调用的
    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_top, this,true);
        imgView = (ImageView) findViewById(R.id.img_view);
        txtView = (TextView) findViewById(R.id.txt_view);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TopView);
        int leftImgBg = array.getResourceId(R.styleable.TopView_leftImgBg, R.mipmap.ic_launcher);
        String txtText = array.getString(R.styleable.TopView_txtText);
        int txtColor = array.getColor(R.styleable.TopView_txtColor,Color.RED);
        if(txtText!=null){
            txtView.setText(txtText);
        }
        imgView.setImageResource(leftImgBg);
        txtView.setTextColor(txtColor);
        array.recycle();
    }
    public void setTxtText(String name){
        txtView.setText(name);
    }
}
