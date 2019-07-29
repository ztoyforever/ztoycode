package lession.example.com.learncamera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Button mBtC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mBtC = (Button) findViewById(R.id.button);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                camerainit();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
        camera = Camera.open();
        final Camera.PictureCallback pcjpeg = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                final Bitmap bm = BitmapFactory.decodeByteArray(data,0,data.length);
                File mfile = new File("/sdcard/camerap.jpg");
                try {
                    mfile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(mfile);
                    bm.compress(Bitmap.CompressFormat.JPEG,100,fos);
                    fos.flush();
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        mBtC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camera!=null){
                    camera.takePicture(null,null,pcjpeg);
                }
            }
        });
    }
    private void camerainit(){
        try {
            camera.setPreviewDisplay(surfaceHolder);
            Camera.Parameters mPt = camera.getParameters();
            mPt.setPreviewSize(640,480);
            mPt.setPictureFormat(PixelFormat.JPEG);
            mPt.set("jpeg",80);
            camera.setParameters(mPt);
            camera.startPreview();
            camera.autoFocus(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        if (camera!=null){
            camera.stopPreview();
            camera.release();
        }
        super.onPause();
    }
}
