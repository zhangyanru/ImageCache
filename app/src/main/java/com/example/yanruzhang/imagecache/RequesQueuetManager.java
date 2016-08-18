package com.example.yanruzhang.imagecache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yanru.zhang on 16/8/18.
 * Email:yanru.zhang@renren-inc.com
 *
 * Volley需要我们声明一个RequesQueuetManager来维持请求队列，因此，我们首先定义RequesQueuetManager类来管理
 */
public class RequesQueuetManager {
    public static RequestQueue mRequestQueue = Volley.newRequestQueue(MyApplication.getContext());
    public static void addRequest(Request<?> request, Object object){
        if (object != null){
            request.setTag(object);
        }
        mRequestQueue.add(request);
    }
    public static void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }
}
