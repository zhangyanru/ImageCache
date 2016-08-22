package com.example.yanruzhang.imagecache.loadLargeImage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yanruzhang.imagecache.R;

import java.io.InputStream;

/**
 * Created by yanru.zhang on 16/8/19.
 * Email:yanru.zhang@renren-inc.com
 */
public class LoadLargeImageActivity extends AppCompatActivity implements View.OnClickListener{
    private LargeImageView largeImageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_large_image);
        setTitle("加载大图");
        largeImageView = (LargeImageView) findViewById(R.id.large_iv);
        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                largeImageView.setRes(R.drawable.qing_ming_shang_he_tu);
                break;
        }
    }
}
