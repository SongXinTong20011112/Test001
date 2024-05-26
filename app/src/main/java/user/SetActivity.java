package user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private RelativeLayout rl_account;
    private CheckBox cb_inspection;
    private CheckBox cb_inform;
    private TextView tv_clear;
    private Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        rl_account = (RelativeLayout) findViewById(R.id.rl_account);
        cb_inspection = (CheckBox) findViewById(R.id.cb_inspection);
        cb_inform = (CheckBox) findViewById(R.id.cb_inform);
        tv_clear = (TextView) findViewById(R.id.tv_clear);
        btn_exit = (Button) findViewById(R.id.btn_exit);

        iv_back.setOnClickListener(this);
        rl_account.setOnClickListener(this);
        cb_inspection.setOnClickListener(this);
        cb_inform.setOnClickListener(this);
        tv_clear.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_account:

                break;
            case R.id.cb_inspection:

                break;
            case R.id.cb_inform:

                break;
            case R.id.tv_clear:

                break;
            case R.id.btn_exit:

                break;
        }
    }
}