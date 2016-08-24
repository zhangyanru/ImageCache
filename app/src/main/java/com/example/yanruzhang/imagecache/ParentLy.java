package com.example.yanruzhang.imagecache;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by yanru.zhang on 16/8/24.
 * Email:yanru.zhang@renren-inc.com
 */
public class ParentLy extends LinearLayout {
    public ParentLy(Context context) {
        super(context);
    }

    public ParentLy(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentLy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLy dispatchTouchEvent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLy onInterceptTouchEvent:" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLy onTouchEvent:" + event.getAction());
        return super.onTouchEvent(event);
    }
}
