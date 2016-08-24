package com.example.yanruzhang.imagecache;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by yanru.zhang on 16/8/24.
 * Email:yanru.zhang@renren-inc.com
 */
public class ChildV extends View {
    public ChildV(Context context) {
        super(context);
    }

    public ChildV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildV(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("zyr","ChildV dispatchTouchEvent:" + ev.getAction());

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("zyr","ChildV onTouchEvent:" + event.getAction());

        return super.onTouchEvent(event);
    }
}
