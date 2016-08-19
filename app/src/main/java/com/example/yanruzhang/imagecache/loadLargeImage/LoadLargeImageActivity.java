package com.example.yanruzhang.imagecache.loadLargeImage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yanruzhang.imagecache.R;

/**
 * Created by yanru.zhang on 16/8/19.
 * Email:yanru.zhang@renren-inc.com
 */
public class LoadLargeImageActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_large_image);
        setTitle("加载大图");
        imageView = (ImageView) findViewById(R.id.iv);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                imageView.setImageResource(R.drawable.qing_ming_shang_he_tu);
                break;
        }
    }
}
