package com.example.civilclass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import user.AgreementActivity;
import user.SetActivity;

public class CsActivity extends AppCompatActivity implements View.OnClickListener {

    private Banner myBanner;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private ImageView iv_back;
    private Button btn_web;
    private Button btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        initView();
    }

    private void initView() {
        myBanner = (Banner) findViewById(R.id.myBanner);
        myBanner.setOnClickListener(this);
        BannerCs();

        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        btn_web = (Button) findViewById(R.id.btn_web);
        btn_web.setOnClickListener(this);
        btn_set = (Button) findViewById(R.id.btn_set);
        btn_set.setOnClickListener(this);
    }

    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

    private void BannerCs() {
        imagePath = new ArrayList<>();
        imagePath.add(R.drawable.guide);
        imagePath.add(R.drawable.guide);
        imagePath.add(R.drawable.guide);

        imageTitle = new ArrayList<>();
        imageTitle.add("这是第一张图片");
        imageTitle.add("这是第二张图片");
        imageTitle.add("这是第三张图片");
        myBanner.setImages(imagePath);
        myBanner.setImageLoader(new MyImageLoader());
        //设置样式
        myBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        myBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        //设置图片加载器
        myBanner.setImageLoader(new MyImageLoader());
        //设置图片的文字
        myBanner.setBannerTitles(imageTitle);
        //设置轮播间隔时间
        myBanner.setDelayTime(2000);
        //设置是否自动轮播,默认是true
        myBanner.isAutoPlay(true);
        //设置指示器的位置,小点点,居中显示
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载地址
        myBanner.setImages(imagePath).start();
        //轮播的监听
//        myBanner.setOnBannerListener((OnBannerListener) ZYMActivity.this);
        //开始

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myBanner:

                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_web:
                startActivity(new Intent().setClass(CsActivity.this, AgreementActivity.class));
                break;
            case R.id.btn_set:
                startActivity( new Intent().setClass( CsActivity.this, SetActivity.class));
                break;
        }
    }
}