package com.example.yanruzhang.imagecache.cache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by yanru.zhang on 16/8/18.
 * Email:yanru.zhang@renren-inc.com
 *
 * 图片缓存管理  获取Volley的ImageLoader对象
 */
public class ImageCacheManager {

    private static String TAG = ImageCacheManager.class.getSimpleName();

    private static ImageCacheUtil mImagetCache = new ImageCacheUtil();

    public static ImageLoader mImageLoader = new ImageLoader(RequestQueueManager.mRequestQueue,mImagetCache);

    public static void loadImage(String url,ImageLoader.ImageListener imageListener){
        mImageLoader.get(url,imageListener,0,0);
    }

    public static void loadImage(String url,ImageLoader.ImageListener imageListener,int maxWidth,int maxHeight){
        mImageLoader.get(url,imageListener,maxWidth,maxHeight);
    }
}
