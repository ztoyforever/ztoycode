package lession.example.com.androidlession2019430;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ZView extends View {

    public ZView(Context context) {
        this(context,null);
    }

    public ZView(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ZView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //画控件
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Canvas画布
        //画笔
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(5);
        paint.setTextSize(50);
        canvas.drawLine(0,0,getWidth(),getHeight()/2,paint);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getHeight()/2,paint);
        canvas.drawRect(0,0,100,100,paint);
        canvas.drawText("这是一个测试",0,40,paint);
    }
}
