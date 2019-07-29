package lession.example.com.androidlession01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class DrawPaint extends View {
    Paint pt;
    DrawPaint(Context context){
        super(context);
        pt = new Paint();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pt.setARGB(255,255,0,0);
        pt.setStrokeWidth(3);
        pt.setStyle(Paint.Style.STROKE);
        pt.setTextSize(30);
        canvas.drawLine(0,800,1080,800,pt);
        for (int i=100;i<1080;i=i+100)
            canvas.drawLine(i,815,i,785,pt);
        canvas.drawLine(100,0,100,1800,pt);
        double d = 1.4;
        for (int i=100;i<1800;i=i+100) {
            canvas.drawLine(85, i, 115, i, pt);
            canvas.drawText(String.format("%.1f",d), 30, i+10, pt);
            d = d-0.2;
        }
        pt.setARGB(255,0,0,255);
        pt.setStrokeWidth(5);
        int x,y,dy=500;
        for (x=0;x<720;x++){
            //y = (int) (500*Math.sin(x/2.0*Math.PI/180.0));
            //y = (int) (500*Math.sin(x/360.0*Math.PI));
            y = (int) (dy*Math.sin(x/60.0*Math.PI));
            canvas.drawPoint(100+x,800-y,pt);
            dy = 500-(int)(x*0.5);
        }
        for (int i=100;i<1000;i=i+20){
            pt.setARGB(255,255-(i/5),i/5,0);
            canvas.drawLine(i,0,1000-i,1800+i,pt);
        }
    }
}
