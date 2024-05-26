package activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

public class Activity02 extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private ImageView iv_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_01 = (ImageView) findViewById(R.id.iv_01);

        iv_back.setOnClickListener(this);
        iv_01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_01:
                startActivity( new Intent().setClass( Activity02.this, RecordActivity.class ) );
                break;
        }
    }
}