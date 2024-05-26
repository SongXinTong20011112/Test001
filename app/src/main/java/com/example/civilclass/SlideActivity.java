package com.example.civilclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SlideActivity extends AppCompatActivity {

    private ImageView image_slide;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        sharedPreferences = getSharedPreferences("user",0);

        initView();

//        if ( sharedPreferences.getBoolean("isFlag", false)){
//            startActivity( new Intent().setClass( SlideActivity.this, ZYMActivity.class ) );
//            finish();
//        }
    }


    private void saveDate(){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("isFlag",true);
        edit.commit();
    }

    private void initView() {
        image_slide = (ImageView) findViewById(R.id.image_slide);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    saveDate();
                    startActivity( new Intent().setClass( SlideActivity.this, ZYMActivity.class ) );
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}