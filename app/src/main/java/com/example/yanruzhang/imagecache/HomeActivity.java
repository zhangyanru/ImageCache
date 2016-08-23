package com.example.yanruzhang.imagecache;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yanruzhang.imagecache.cache.MainActivity;
import com.example.yanruzhang.imagecache.handlerThread.HandlerThreadActivity;
import com.example.yanruzhang.imagecache.loadLargeImage.LoadLargeImageActivity;

/**
 * Created by yanru.zhang on 16/8/19.
 * Email:yanru.zhang@renren-inc.com
 */
public class HomeActivity extends Activity implements View.OnClickListener{
    private Button cache,largeI,handlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        cache = (Button) findViewById(R.id.cache);
        largeI = (Button) findViewById(R.id.large_i);
        handlerThread = (Button) findViewById(R.id.handler_thread);

        cache.setOnClickListener(this);
        largeI.setOnClickListener(this);
        handlerThread.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cache:
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.large_i:
                Intent intent2 = new Intent(HomeActivity.this, LoadLargeImageActivity.class);
                startActivity(intent2);
                break;
            case R.id.handler_thread:
                Intent intent3 = new Intent(HomeActivity.this, HandlerThreadActivity.class);
                startActivity(intent3);
                break;
        }

    }
}
