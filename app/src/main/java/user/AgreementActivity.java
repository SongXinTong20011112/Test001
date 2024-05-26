package user;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

import util.WebUtils;

public class AgreementActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AgreementActivity - SXT";
    private ImageView iv_back;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        webView = (WebView) findViewById(R.id.webView_agreement);

        iv_back.setOnClickListener(this);

        String url = "https://fzapph5.gjfzpt.cn/Agreements/policy.html";
        WebUtils.initWebView( webView, AgreementActivity.this,url);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 清除WebView缓存
        webView.clearCache(true);
    }
}