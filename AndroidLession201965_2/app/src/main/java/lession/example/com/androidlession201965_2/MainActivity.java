package lession.example.com.androidlession201965_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    int maxX = 8,maxY = 11,maxW=1100,maxH=1500,dx,dy;
    ImageView[][] lkIview;
    RelativeLayout ly;
    int[] imageId = new int[]{R.drawable.p00,R.drawable.p01,R.drawable.p02,R.drawable.p03,
                                R.drawable.p04,R.drawable.p05,R.drawable.p06,R.drawable.p07,
                                R.drawable.p08,R.drawable.p09,R.drawable.p10,R.drawable.p11,
                                R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,
                                R.drawable.p16,R.drawable.p17,R.drawable.p18, R.drawable.p19,
                                R.drawable.p20,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lkIview = new ImageView[maxX][maxY];
        ly = (RelativeLayout) findViewById(R.id.relaLy);
        dx= maxW/maxX;dy=maxH/maxY;
        int i,j;
        for (i=1;i<maxX-1;i++){
            for (j=1;j<maxY-1;j++){
                lkIview[i][j] = new ImageView(MainActivity.this);
                lkIview[i][j].setImageResource(R.drawable.p00);
                ly.addView(lkIview[i][j]);
                lkIview[i][j].setX(i*dx);
                lkIview[i][j].setY(j*dy);
                lkIview[i][j].setMaxWidth(50);
                lkIview[i][j].setMaxHeight(50);
                lkIview[i][j].setLayoutParams(new RelativeLayout.LayoutParams(dx,dy));
                lkIview[i][j].setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }
    private void setImageReady(){
        int i,j;
        for(i=0;i<maxX;i++){
            lkIview[i][0].setImageResource(imageId[19]);
            lkIview[i][maxY-1].setImageResource(imageId[19]);
        }
        for (j=0;j<maxY;j++){
            lkIview[0][j].setImageResource(imageId[19]);
            lkIview[maxY-1][j].setImageResource(imageId[19]);
        }
    }
}
