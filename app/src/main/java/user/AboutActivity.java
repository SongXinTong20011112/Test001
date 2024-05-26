package user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

import dialog.CustomDialog;
import util.ToastUtil;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout rl_01;
    private RelativeLayout rl_02;
    private RelativeLayout rl_03;
    private RelativeLayout rl_04;
    private RelativeLayout rl_05;
    private Button btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        rl_01 = (RelativeLayout) findViewById(R.id.rl_01);
        rl_02 = (RelativeLayout) findViewById(R.id.rl_02);
        rl_03 = (RelativeLayout) findViewById(R.id.rl_03);
        rl_04 = (RelativeLayout) findViewById(R.id.rl_04);
        rl_05 = (RelativeLayout) findViewById(R.id.rl_05);
        btn_update = (Button) findViewById(R.id.btn_update);

        iv_back.setOnClickListener(this);
        rl_01.setOnClickListener(this);
        rl_02.setOnClickListener(this);
        rl_03.setOnClickListener(this);
        rl_04.setOnClickListener(this);
        rl_05.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_01:
                break;
            case R.id.rl_02:
                startActivity( new Intent(AboutActivity.this,AgreementActivity.class));
                break;
            case R.id.rl_03:
                startActivity( new Intent(AboutActivity.this,PrivacyActivity.class));
                break;
            case R.id.btn_update:
                initUpdate();
                break;
        }
    }
 
    private void initUpdate() {
        final CustomDialog customDialog = new CustomDialog(this, "正在加载...");
        customDialog.show();//显示,显示时页面不可点击,只能点击返回
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ToastUtil.shouToast(AboutActivity.this,"当前以是最新版本");
                            customDialog.dismiss();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}