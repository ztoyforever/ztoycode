package lession.example.com.learncanvas;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
public class DrawPaint extends View {
    Paint pt;
    public DrawPaint(Context context) {
        super(context);
        pt = new Paint();//创建画笔
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pt.setARGB(255,255,0,0);
        pt.setStrokeWidth(3);
        pt.setStyle(Paint.Style.STROKE);
        pt.setTextSize(60);
//        //画圆
//        canvas.drawText("圆：",80,120,pt);
//        canvas.drawCircle(200,100,30,pt);
//        //画矩形
//        canvas.drawText("矩形：",80,220,pt);
//        canvas.drawRect(250,180,400,250,pt);
//        //正方形
//        canvas.drawText("正方形：",80,320,pt);
//        canvas.drawRect(290,290,370,370,pt);
//        //圆角矩形
//        canvas.drawText("圆角矩形：",80,440,pt);
//        RectF rectF = new RectF(350,400,550,500);
//        canvas.drawRoundRect(rectF,20,30,pt);
//        //椭圆形
//        canvas.drawText("椭圆形：",80,600,pt);
//        RectF oval = new RectF(350,550,650,700);
//        canvas.drawOval(oval,pt);
//        //三角形
//        canvas.drawText("三角形：",80,750,pt);
//        Path path = new Path();
//        path.moveTo(300,700);
//        path.lineTo(300,800);
//        path.lineTo(400,800);
//        path.close();
//        canvas.drawPath(path,pt);
//        //五边形
//        canvas.drawText("五边形：",80,900,pt);
//        Path path1 = new Path();
//        path1.moveTo(300,900);
//        path1.lineTo(400,900);
//        path1.lineTo(450,1000);
//        path1.lineTo(400,1100);
//        path1.lineTo(300,1100);
//        path1.lineTo(300,1000);
//        path1.close();
//        canvas.drawPath(path1,pt);
        canvas.drawCircle(250,250,150,pt);
        canvas.drawRect(100,100,400,250,pt);
        Path path = new Path();
        path.moveTo(100,250);
        path.lineTo(250,400);
        path.lineTo(400,250);
        path.close();
        canvas.drawPath(path,pt);
    }
}
