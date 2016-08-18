package com.example.yanruzhang.imagecache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private View progressLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.iv);
        progressLy = findViewById(R.id.progress_ly);


        ImageCacheManager.loadImage("http://img0.bdstatic.com/img/image/shouye/xiaoxiao/%E5%AE%A0%E7%89%A983.jpg",
                new ImageLoader.ImageListener() {
                    @Override
                    public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
                        Log.d("zyr",Thread.currentThread().getName());
                        progressLy.setVisibility(View.GONE);
                        if(imageContainer.getBitmap() != null){
                            imageView.setImageBitmap(imageContainer.getBitmap());
                        }
                    }

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("zyr",Thread.currentThread().getName());
                        progressLy.setVisibility(View.GONE);
                    }
                });
    }
}
