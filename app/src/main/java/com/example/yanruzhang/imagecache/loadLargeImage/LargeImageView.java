package com.example.yanruzhang.imagecache.loadLargeImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yanru.zhang on 16/8/19.
 * Email:yanru.zhang@renren-inc.com
 *
 * 参考
 * http://blog.csdn.net/lmj623565791/article/details/49300989
 * https://github.com/LuckyJayce/LargeImage
 */
public class LargeImageView extends View{

    private BitmapRegionDecoder bitmapRegionDecoder;
    private int width,height,imageWidth,imageHeight;
    private Rect rect = new Rect();
    private BitmapFactory.Options options;
    private Bitmap bitmap;
    private Paint paint;
    private int downX,downY,moveX,moveY,lastMoveX,lastMoveY;
    public LargeImageView(Context context) {
        this(context,null);
    }

    public LargeImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LargeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(w!=oldw || h!=oldh){
            width = w;
            height = h;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap!=null){
            canvas.drawBitmap(bitmap,0,0,paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastMoveX = downX = (int)event.getX();
                lastMoveY = downY = (int)event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int)event.getX();
                moveY = (int)event.getY();
                if(rect.right + (lastMoveX - moveX) <=0 ||
                        rect.bottom + (lastMoveY - moveY) <=0 ||
                        rect.left + (lastMoveX - moveX) >=imageWidth ||
                        rect.top + (lastMoveY - moveY) >= imageHeight){
                    //right <=0
                    //bottom <=0
                    //left >= width
                    //top >= height
                }else{
                    rect.offset(lastMoveX - moveX , lastMoveY - moveY);
                    bitmap = bitmapRegionDecoder.decodeRegion(rect,options);
                    invalidate();
                }
                lastMoveX = moveX;
                lastMoveY = moveY;
                break;
        }

        return true;
    }

    public void setRes(int resId){
        InputStream inputStream = getResources().openRawResource(resId);
        //获取宽，高
        options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream,null,options);
        imageWidth = options.outWidth;
        imageHeight = options.outHeight;
        try {
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream,false);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            rect.set(0,0,width,height);
            bitmap = bitmapRegionDecoder.decodeRegion(rect,options);
            invalidate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
