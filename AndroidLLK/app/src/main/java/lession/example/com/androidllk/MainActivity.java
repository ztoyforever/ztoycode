package lession.example.com.androidllk;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int maxX=8,maxY=11;
    //int maxW=1080,maxH=1580;
    int dx,dy;
    int startX=-1,startY=-1,endX=-1,endY=-1;
    ArrayList<Integer> list_startX,list_startY,list_endX,list_endY;
    ImageView[][] lkIview;
    TableLayout ly;
    TableRow[] mTr=new TableRow[maxY];  //表格布局对象
    int[] imageId=new int[]{R.drawable.p00,R.drawable.p01,R.drawable.p02,R.drawable.p03,
                              R.drawable.p04,R.drawable.p05,R.drawable.p06,R.drawable.p07,
                              R.drawable.p08,R.drawable.p09,R.drawable.p10,R.drawable.p11,
                              R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,
                              R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,
                              R.drawable.p20,};
    //创建主线程中接收子线程的消息对象，进行界面清理
    Handler mainHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                setImagetoBk(startY,startX);
                setImagetoBk(endY,endX);
                clear_Line();
                startX=-1;startY=-1;  //重置用户选择的状态
            }
        }
    };
    //创建一个子线程，用于暂定显示连线,并通过子线程中的消息发送给主线程
    //让其进行清理
    Handler chlHandler;
    Thread clearThread=new Thread(){
        @Override
        public void run() {
            Looper.prepare();
            chlHandler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    SystemClock.sleep(1000);
                    Message sendmsg=new Message();
                    sendmsg.what=1;
                    mainHandler.sendMessage(sendmsg);
                }
            };
            Looper.loop();
        }
    };

    private ImageView.OnClickListener LLk_Listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView mIview=(ImageView)v;  //将点击传递的View对象v转换为图片对象
            if(!mIview.getTag().toString().equals("bk")){   //非bk对象可进行匹配操作
                mIview.setColorFilter(Color.argb(100,0,0,255));  //为图片添加滤镜标记
                TableRow tr=(TableRow)mIview.getParent();
                int y=((TableLayout)tr.getParent()).indexOfChild(tr);  //获取图片所在行
                int x=tr.indexOfChild(mIview);//获取图片所在列
                if(startX==x && startY==y)  //若第二次点击的位置和第一次一样，则不执行任何操作
                    return;
                if(startX==-1){         //用户点击的是第一个图片
                    startX=x;startY=y;  //记录第一个图片的位置
                }else{                  //用户点击的是第二个图片
                    endX=x;endY=y;      //记录第二个图片的位置
                    String sStr=lkIview[startY][startX].getTag().toString();//获取图片id信息
                    String eStr=lkIview[endY][endX].getTag().toString();
                    if(sStr.equals(eStr)){  //比较id信息是否一致，判断是否为相同的图片
                        LinkImage(startX,startY,endX,endY);
                    }else{         //若不是相同的图片
                        lkIview[startY][startX].clearColorFilter();//取消滤镜效果
                        lkIview[endY][endX].clearColorFilter();
                        startX=-1;startY=-1;//重置用户选择的状态
                    }
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lkIview=new ImageView[maxY][maxX];
        ly=(TableLayout)findViewById(R.id.tbLy);
        WindowManager wm1 = this.getWindowManager();
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();
        int maxW=width1,maxH=height1;
        dx=maxW/maxX;dy=maxH/maxY;
        int i,j;
        for(i=0;i<maxY;i++){
            mTr[i]=new TableRow(MainActivity.this);
            for(j=0;j<maxX;j++){
                lkIview[i][j]=new ImageView(MainActivity.this);
                lkIview[i][j].setImageResource(imageId[20]);
                lkIview[i][j].setTag("bk");
                lkIview[i][j].setMaxHeight(dy);
                lkIview[i][j].setMaxWidth(dx);
                lkIview[i][j].setAdjustViewBounds(true);
                lkIview[i][j].setPadding(0,0,0,0);
                lkIview[i][j].setOnClickListener(LLk_Listener);
                mTr[i].addView(lkIview[i][j]);
            }
            mTr[i].setPadding(0,0,0,0);
            ly.addView(mTr[i]);
        }
        setImageLLK();
        clearThread.start();
    }
    //添加各种图片用于消除，每个图片必须是双数
    private void setImageLLK(){
        int n=0,id,i,x,y;
        int max=(maxX-2)*(maxY-2)/2;
        while (n<max){
            Random rnd=new Random();  //产生随机数的类和对象
            id=rnd.nextInt(20);    //随机产生一个图片的id，范围为0-19
            for(i=0;i<2;){         //循环两次，以保证图片成对出现
                x=rnd.nextInt(maxX-2)+1;  //产生随机位置
                y=rnd.nextInt(maxY-2)+1;
                //判断该位置是否为空白，空白可放入图片，同时标记图片信息
                if(lkIview[y][x].getTag().toString().equals("bk")){
                    lkIview[y][x].setImageResource(imageId[id]);
                    lkIview[y][x].setTag("ig"+id);
                    i++;   //确认可以放入图片再进行i的增值，以保证每次循环放入两张图片
                }
            }
            n++;
        }
    }
    private void setImagetoBk(int y,int x){
        lkIview[y][x].setImageResource(imageId[20]);
        lkIview[y][x].setTag("bk");
    }
    //判断相同的图片是否可以消除
    private void LinkImage(int sx,int sy,int ex,int ey){
        //判断是否相邻，若相邻则可以直接消除
        if(Math.abs(sy-ey)==1 && sx-ex==0 || Math.abs(sx-ex)==1 && sy-ey==0){
            setImagetoBk(startY,startX);
            setImagetoBk(endY,endX);
            startX=-1;startY=-1;  //重置用户选择的状态
        }else{//不相邻，需要判断是否连线可以消除
            if(LinkTest(sy,sx,ey,ex)){
                Message msg=new Message();
                msg.what=0;
                chlHandler.sendMessage(msg);
            }else{
                lkIview[startY][startX].clearColorFilter();//取消滤镜效果
                lkIview[endY][endX].clearColorFilter();
                startX=-1;startY=-1;//重置用户选择的状态
            }
        }
    }
    private boolean LinkTest(int sy,int sx,int ey,int ex){
        int tx1,ty1,tx2,ty2;
        list_startX=LinkEx_X(sy,sx);
        list_startY=LinkEx_Y(sy,sx);
        list_endX=LinkEx_X(ey,ex);
        list_endY=LinkEx_Y(ey,ex);
        //两个图片在同一行或同一列，没有拐点的判断
        //两个图片在同一行的判断
        if(sx==ex && Link_X(sx,sy,ey)){
            Link_Line_X(sx,sy,ey);
            return true;
        }
        if(sy==ey && Link_Y(sy,sx,ex)){
            Link_Line_Y(sy,sx,ex);
            return true;
        }

        //两个不同方向线的相交判断，只有一个拐点
        //起点横向延伸x集合中，包含终点的x值，且终点的纵向延伸y集合中，包含起点的y值
        if(list_startX.contains(ex)&&list_endY.contains(sy)){
            tx1=ex;ty1=sy;
            Link_Line_X(tx1,sy,ey);
            Link_Line_Y(ty1,sx,ex);
            Link_Trun(tx1,ty1,sx,ey);
            return true;
        }
        if(list_startY.contains(ey)&&list_endX.contains(sx)){
            tx1=sx;ty1=ey;
            Link_Line_X(tx1,sy,ey);
            Link_Line_Y(ty1,sx,ex);
            Link_Trun(tx1,ty1,ex,sy);
            return true;
        }
        //判断转折两次,有两个拐点的判断
        //判断两个图片的横向延伸之间是否可以连通
        list_startX.retainAll(list_endX);
        for(int i=0;i<list_startX.size();i++){
            if(Link_X(list_startX.get(i),sy,ey)){
                tx1=tx2=list_startX.get(i);
                ty1=sy;ty2=ey;
                Link_Line_X(tx1,sy,ey);
                Link_Line_Y(ty1,sx,tx1);
                Link_Line_Y(ty2,ex,tx2);
                Link_Trun(tx1,ty1,sx,ty2);
                Link_Trun(tx2,ty2,ex,ty1);
                return true;
            }
        }
        //判断两个图片的纵向延伸之间是否可以连通
        list_startY.retainAll(list_endY);
        for(int i=0;i<list_startY.size();i++){
            if(Link_Y(list_startY.get(i),sx,ex)){
                ty1=ty2=list_startY.get(i);
                tx1=sx;tx2=ex;
                Link_Line_Y(ty1,sx,ex);
                Link_Line_X(tx1,sy,ty1);
                Link_Line_X(tx2,ey,ty2);
                Link_Trun(tx1,ty1,tx2,sy);
                Link_Trun(tx2,ty2,tx1,ey);
                return true;
            }
        }
        return false;
    }

    //根据一个图片所在位置，获取其可用于连线的横向延伸集合（存储对应的x值）
    private ArrayList<Integer> LinkEx_X(int y,int x){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=x+1;i<maxX;i++){  //以图片位置开始，正向获取
            if(lkIview[y][i].getTag().toString().equals("bk")){
                list.add(i);//图片为空白，可用于连线，添加到集合
            }else
                break;       //遇到非空白，不能再延伸，终止获取
        }
        for(int i=x-1;i>=0;i--){//同上，以图片位置开始，负向获取
            if(lkIview[y][i].getTag().toString().equals("bk")){
                list.add(i);
            }else
                break;
        }
        return list;
    }
    //同上，根据一个图片所在位置，获取其可用于连线的纵向向延伸集合（存储对应的x值）
    private ArrayList<Integer> LinkEx_Y(int y,int x){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=y+1;i<maxY;i++){  //以图片位置开始，正向获取
            if(lkIview[i][x].getTag().toString().equals("bk")){
                list.add(i);//图片为空白，可用于连线，添加到集合
            }else
                break;       //遇到非空白，不能再延伸，终止获取
        }
        for(int i=y-1;i>=0;i--){//同上，以图片位置开始，负向获取
            if(lkIview[i][x].getTag().toString().equals("bk")){
                list.add(i);
            }else
                break;
        }
        return list;
    }
    //判断x行中，y1到y2的区间是否可连通
    private boolean Link_X(int x,int y1,int y2){
        int t;
        if(y1>y2){t=y1;y1=y2;y2=t;}
        for(int y=y1+1;y<y2;y++){
            if(!lkIview[y][x].getTag().equals("bk")){
                return false;
            }
        }
        return true;
    }
    //判断y行中，x1到x2的区间是否可连通
    private boolean Link_Y(int y,int x1,int x2){
        int t;
        if(x1>x2){t=x1;x1=x2;x2=t;}
        for(int x=x1+1;x<x2;x++){
            if(!lkIview[y][x].getTag().equals("bk")){
                return false;
            }
        }
        return true;
    }
    //绘制横向的连线
    private void Link_Line_X(int x,int y1,int y2){
        int t;
        if(y1>y2){t=y1;y1=y2;y2=t;}
        for(int y=y1+1;y<y2;y++){
            lkIview[y][x].setImageResource(R.drawable.zud);
            lkIview[y][x].setTag("lk");
        }
    }
    //绘制纵向的连线
    private void Link_Line_Y(int y,int x1,int x2){
        int t;
        if(x1>x2){t=x1;x1=x2;x2=t;}
        for(int x=x1+1;x<x2;x++){
            lkIview[y][x].setImageResource(R.drawable.zlr);
            lkIview[y][x].setTag("lk");
        }
    }
    //绘制拐点的连线
    private void Link_Trun(int x,int y,int sx,int ey){
        if(x<sx && y<ey){
            lkIview[y][x].setImageResource(R.drawable.zrd);
            lkIview[y][x].setTag("lk");
        }
        if(x<sx && y>ey){
            lkIview[y][x].setImageResource(R.drawable.zru);
            lkIview[y][x].setTag("lk");
        }
        if(x>sx && y<ey){
            lkIview[y][x].setImageResource(R.drawable.zld);
            lkIview[y][x].setTag("lk");
        }
        if(x>sx && y>ey){
            lkIview[y][x].setImageResource(R.drawable.zlu);
            lkIview[y][x].setTag("lk");
        }
    }
    private void clear_Line(){
        for(int i=0;i<maxY;i++){
            for(int j=0;j<maxX;j++) {
                if(lkIview[i][j].getTag().equals("lk")){
                    setImagetoBk(i,j);
                }
            }
        }
    }
}

