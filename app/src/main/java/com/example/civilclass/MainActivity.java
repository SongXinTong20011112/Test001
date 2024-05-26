package com.example.civilclass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import util.HttpRequest;
import util.ToastUtil;
import util.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity-SXT:  ";
    private EditText edt_account;
    private EditText edt_password;
    private CheckBox cb;
    private Button btn_login;
    private Button btn_exit;
    private SharedPreferences sharedPreferences;
    private CheckBox cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_password = (EditText) findViewById(R.id.edt_password);
        cb = (CheckBox) findViewById(R.id.cb);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        btn_login.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        cb.setChecked(true);
        cb2.setChecked(true);

        sharedPreferences = getSharedPreferences("user", 0);
        setUser();

        if (cb.isChecked() && cb2.isChecked()) {
            if (edt_password.getText().toString().equals("123") && edt_account.getText().toString().equals("user01")) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            startActivity(new Intent().setClass(MainActivity.this, ZYMActivity.class));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }

    }

    private void setUser() {
        String account = sharedPreferences.getString("account", "");
        String password = sharedPreferences.getString("password", "");
        boolean cb1 = sharedPreferences.getBoolean("cb", false);
        boolean cb2_boolean = sharedPreferences.getBoolean("cb2", false);
        if (cb1) {
            cb.setChecked(cb1);
            edt_account.setText(account);
            edt_password.setText(password);
        }
        if (cb2_boolean) {
            cb2.setChecked(cb2_boolean);
        }
    }

    private void saveUser() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("account", edt_account.getText().toString());
        edit.putString("password", edt_password.getText().toString());
        edit.putBoolean("cb", cb.isChecked());
        edit.putBoolean("cb2", cb2.isChecked());
        edit.commit();
    }

    @Override
    public void onClick(View v) {
        String account = edt_account.getText().toString();
        String password = edt_password.getText().toString();
        switch (v.getId()) {
            case R.id.btn_login:
                if (submit()) {
                    if (Utils.checkMobile(account) == true) {
                        initLogin();
                    } else if (Utils.checkMobile(account) == false) {
                        ToastUtil.shouToast(MainActivity.this, "号码格式有误");
                    }

                } else {
                    ToastUtil.shouToast(this, "用户名或者密码错误");
                }
                break;
            case R.id.btn_exit://注册按钮
//                ToastUtil.shouToast(this,"退出成功");
                startActivity(new Intent().setClass(MainActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void initLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final JsonObject login = HttpRequest.getPost("/app/login", "{\n" +
                        "  \"phone\": \"test01\",\n" +
                        "  \"password\": \"123456\"\n" +
                        "}", JsonObject.class);
                final int code = login.get("code").getAsInt();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (login != null) {
                            System.out.println(login.get("code").getAsInt() + "8888888888888");
                            if (code == 200) {
                                saveUser();
                                startActivity(new Intent().setClass(MainActivity.this, ZYMActivity.class));
                                ToastUtil.shouToast(MainActivity.this, "登录成功");
                            } else {
                                ToastUtil.shouToast(MainActivity.this, "登录失败");
                            }
                        } else {
                            ToastUtil.shouToast(MainActivity.this, "网络请求失败");
                        }

                    }
                });

            }
        }).start();
    }

    private boolean submit() {
        boolean is = true;
        // validate
        String account = edt_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            ToastUtil.shouToast(this, "请输入用户号");
            return is = false;
        }

        String password = edt_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            ToastUtil.shouToast(this, "请输入密码");
            return is = false;
        }

        return is;
        // TODO validate success, do something
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb:

                break;
            case R.id.cb2:
                break;
        }
    }
}