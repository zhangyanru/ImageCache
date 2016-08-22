package com.example.yanruzhang.imagecache.loadLargeImage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by yanru.zhang on 16/8/19.
 * Email:yanru.zhang@renren-inc.com
 */
public class DecodeImageUtil {

    /**
     * 如果图片的大小大于ImageView的大小，根据需要显示图片控件的大小对图片进行压缩显示
     * @param res
     * @param resId
     * @param targetWidth
     * @param targetHeight
     * @return
     */
    public static Bitmap decodeFromRes(Resources res,int resId, int targetWidth, int targetHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; //当这个属性为true的时候，我们就可以禁止系统加载图像到内存，但是！！！这时候，Options参数中的图像宽高、类型等属性已经被赋值了
        BitmapFactory.decodeResource(res,resId,options);
        int width = options.outWidth;
        int height = options.outHeight;
        String type = options.outMimeType;
        int inSampleSize = 1;
        if(height > targetHeight || width > targetHeight){
            int widthRate = Math.round((float) width/(float)targetWidth);
            int heightRate = Math.round((float) height/(float)targetHeight);
            inSampleSize = widthRate > heightRate ? widthRate : heightRate;
        }
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        //另外，为了节约内存我们还可以使用下面的几个字段：
        options.inDither=false;    /*不进行图片抖动处理*/
        options.inPreferredConfig=null;  /*设置让解码器以最佳方式解码*/
        /* 下面两个字段需要组合使用 */
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeResource(res,resId,options);
    }
}
