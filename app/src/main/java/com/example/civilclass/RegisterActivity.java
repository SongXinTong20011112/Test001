package com.example.civilclass;

import static com.example.civilclass.R.layout.layout_edt_toast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import activity.NewActivity;
import ng.max.slideview.SlideView;
import util.HttpRequest;
import util.ToastUtil;
import util.Utils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RegisterActivity-SXT";
    private EditText edt_account;
    private LinearLayout ll;
    private EditText edt_pwd;
    private LinearLayout ll_01;
    private SlideView slideView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        edt_account = (EditText) findViewById(R.id.edt_account);
        ll = (LinearLayout) findViewById(R.id.ll);
        edt_pwd = (EditText) findViewById(R.id.edt_pwd);
        ll_01 = (LinearLayout) findViewById(R.id.ll_01);
        slideView = findViewById(R.id.slideView);
        edt_pwd.setOnClickListener(this);

        slideView.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                //获取手机震动
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                if (edt(edt_account, ll) && edt(edt_pwd, ll_01)) {
                    Log.e(TAG, "onSlideComplete: 红色提示弹出" );
                } else {
                    if (Utils.checkMobile(edt_account.getText().toString())) {
                        Log.e(TAG, "onSlideComplete: 输入电话号码格式是否正确------"+ Utils.checkMobile(edt_account.getText().toString()) );
//                        initRegister();
                    }
                }
            }
        });
    }

    private void initRegister() {
        final String pwd = edt_pwd.getText().toString();
        final String account = edt_account.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final JsonObject register = HttpRequest.getPost("/app", "{\n" +
                        "  \"phone\": \"" + account + "\",\n" +
                        "  \"password\": \"" + pwd + "\"\n" +
                        "}", JsonObject.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ( register != null ){
                            int code = register.get("code").getAsInt();
                            if ( code == 200 ){
                                ToastUtil.shouToast(RegisterActivity.this,"注册成功");
                                startActivity(new Intent(RegisterActivity.this, NewActivity.class));
                            }else {
                                ToastUtil.shouToast(RegisterActivity.this,"注册失败");
                            }
                        }

                    }
                });
            }
        }).start();
    }

    private boolean edt(EditText editText, LinearLayout ll) {
        boolean is = true;
        String s = editText.getText().toString().trim();
        if (TextUtils.isEmpty(s)) {
            View inflate = getLayoutInflater().inflate(layout_edt_toast, null);
            ll.removeAllViews();
            ll.addView(inflate);
            return is;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {

    }
}