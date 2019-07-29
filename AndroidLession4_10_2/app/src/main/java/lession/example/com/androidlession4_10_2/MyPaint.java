package lession.example.com.androidlession4_10_2;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.View;
public class MyPaint extends View{
    Bitmap mAnBmp;
    Rect bmpRect,drawRect;
    int bmpSx,bmpSy,dx,dy;
    int drawSx,drawSy;
    int aniPage,maxPage;
    Handler mHandler;
    public MyPaint(Context context) {
        super(context);
        mAnBmp = BitmapFactory.decodeResource
                (context.getResources(),R.drawable.pp);
        bmpRect = new Rect();drawRect = new Rect();
        drawSx = 300;drawSy = 500;
        dx = mAnBmp.getWidth()/15;dy = mAnBmp.getHeight();
        aniPage = 0; maxPage = 14;
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                aniPage++;
                if (aniPage>maxPage)
                    aniPage = 0;
                invalidate();
                this.sendEmptyMessageDelayed(0,100);
            }
        };
        mHandler.sendEmptyMessageDelayed(0,200);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bmpSx = aniPage*dx;bmpSy = 0;
        bmpRect.set(bmpSx,bmpSy,bmpSx+dx,bmpSy+dy);
        drawRect.set(drawSx,drawSy,drawSx+dx*2,drawSy+dy*2);
        canvas.drawBitmap(mAnBmp,bmpRect,drawRect,null);
    }
}
