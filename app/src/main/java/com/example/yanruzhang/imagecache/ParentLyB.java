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
public class ParentLyB extends LinearLayout {
    public ParentLyB(Context context) {
        super(context);
    }

    public ParentLyB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParentLyB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLyB dispatchTouchEvent:" + ev.getAction());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLyB onInterceptTouchEvent:" + ev.getAction());

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("zyr","com.example.yanruzhang.imagecache.ParentLyB onTouchEvent:" + event.getAction());

        return super.onTouchEvent(event);
    }
}
