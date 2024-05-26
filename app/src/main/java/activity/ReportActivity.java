package activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

public class ReportActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_01;
    private ImageView iv_01;
    private TextView tv_02;
    private ImageView iv_02;
    private TextView tv_03;
    private ImageView iv_03;
    private TextView tv_04;
    private ImageView iv_04;
    private TextView tv_05;
    private Button btn_01;
    private Button btn_02;
    private Button btn_03;
    private Button btn_04;
    private Button btn_05;
    private Button btn_06;
    private TextView tv_06;
    private ImageView iv_05;
    private TextView tv_07;
    private ImageView iv_06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_01 = (TextView) findViewById(R.id.tv_01);
        iv_01 = (ImageView) findViewById(R.id.iv_01);
        tv_02 = (TextView) findViewById(R.id.tv_02);
        iv_02 = (ImageView) findViewById(R.id.iv_02);
        tv_03 = (TextView) findViewById(R.id.tv_03);
        iv_03 = (ImageView) findViewById(R.id.iv_03);
        tv_04 = (TextView) findViewById(R.id.tv_04);
        iv_04 = (ImageView) findViewById(R.id.iv_04);
        tv_05 = (TextView) findViewById(R.id.tv_05);
        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);
        btn_03 = (Button) findViewById(R.id.btn_03);
        btn_04 = (Button) findViewById(R.id.btn_04);
        btn_05 = (Button) findViewById(R.id.btn_05);
        btn_06 = (Button) findViewById(R.id.btn_06);
        tv_06 = (TextView) findViewById(R.id.tv_06);
        iv_05 = (ImageView) findViewById(R.id.iv_05);
        tv_07 = (TextView) findViewById(R.id.tv_07);
        iv_06 = (ImageView) findViewById(R.id.iv_06);

        iv_01.setOnClickListener(this);
        iv_02.setOnClickListener(this);
        iv_03.setOnClickListener(this);
        iv_04.setOnClickListener(this);
        btn_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_04.setOnClickListener(this);
        btn_05.setOnClickListener(this);
        btn_06.setOnClickListener(this);
        iv_05.setOnClickListener(this);
        iv_06.setOnClickListener(this);
        iv_back.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_01:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_02:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_03:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_04:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_01:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_02:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_03:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_04:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_05:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.btn_06:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_05:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_06:
                startActivity( new Intent( Intent.ACTION_DIAL, Uri.parse("tel:7797110") ));
                break;
            case R.id.iv_back:
//                startActivity( new Intent().setClass( ReportActivity.this, ZYMActivity.class ) );
                finish();
                break;
        }
    }
}