package com.example.yanruzhang.imagecache.handlerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.example.yanruzhang.imagecache.R;

import java.util.Random;

/**
 * Created by yanru.zhang on 16/8/23.
 * Email:yanru.zhang@renren-inc.com
 */
public class HandlerThreadActivity extends Activity {

    private TextView textView;
    private HandlerThread handlerThread;
    private Handler threadHandler;
    private Handler mainHandler;
    private static final int UPDATE_UI = 1;
    private static final int GET_DATA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_handler_thread);
        textView = (TextView) findViewById(R.id.tv);

        handlerThread = new HandlerThread("zyr thread");
        handlerThread.start();

        threadHandler = new Handler(handlerThread.getLooper(),new Handler.Callback() {
            private Random random = new Random();
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case GET_DATA:
                        //子线程做的事情
                        Log.d("zyr",Thread.currentThread().getName());
                        try {
                            int i = random.nextInt();
                            //得到结果给主线程更新ui
                            Message message = new Message();
                            message.what = UPDATE_UI;
                            Bundle bundle = new Bundle();
                            bundle.putInt("i",i);
                            message.setData(bundle);
                            mainHandler.sendMessage(message);
                            Thread.sleep(5000);
                            //给ThreadHandler发消息
                            threadHandler.sendEmptyMessage(GET_DATA);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                return true;
            }
        });

        mainHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case UPDATE_UI:
                        int i = msg.getData().getInt("i");
                        textView.setText(i+"");
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        threadHandler.sendEmptyMessage(GET_DATA);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        threadHandler.removeMessages(GET_DATA);
        handlerThread.quit();
    }
}
