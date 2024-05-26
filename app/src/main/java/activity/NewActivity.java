package activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

import java.util.ArrayList;
import java.util.List;

import util.AppConfig;

public class NewActivity extends AppCompatActivity {

    private WebView myWebView;
    private List<String> newUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initView();
        initDate();
    }

    private void initDate() {

        newUrl.add("https://mp.weixin.qq.com/s/e7c4UbRVMGZNspLhgiAz6Q");
        newUrl.add("https://mp.weixin.qq.com/s/Q8Mp3ZiMPf-uMfj1wLDM_Q");
        newUrl.add("https://mp.weixin.qq.com/s/SFHJSdvcgklNSQ-tIFXJYA");
        newUrl.add("https://mp.weixin.qq.com/s/hmYWF_qplfLF4gQ9-bP1BA");
        newUrl.add("https://mp.weixin.qq.com/s/x88DtGaKSHT7FemcsPVLSQ");
        newUrl.add("https://mp.weixin.qq.com/s/z9qi8m1aVV-7z8KCaB1FMQ");
        newUrl.add("https://mp.weixin.qq.com/s/upaKGhSImWKUXB791QCb0A");
        newUrl.add("https://mp.weixin.qq.com/s/BRheVZiJmDKPaZBvn5vVQQ");
        newUrl.add("https://mp.weixin.qq.com/s/M2wcpTh6xvM2aak7sieNCg");
        newUrl.add("https://mp.weixin.qq.com/s/bYzx-UkTcq2PeER8GIW_zw");
        newUrl.add("https://mp.weixin.qq.com/s/pKYzhnQ4jE9JyqT7IkRORg");
        newUrl.add("https://mp.weixin.qq.com/s/_-q_ZGLEFbVK9Akt45OMTA");

        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled( true );

        myWebView.setWebChromeClient( new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });

        myWebView.setWebViewClient( new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        myWebView.loadUrl( newUrl.get( AppConfig.newNumber ));

    }

    private void initView() {
        myWebView = (WebView) findViewById(R.id.myWebView);
    }
}