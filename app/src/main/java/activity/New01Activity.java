package activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

public class New01Activity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new01);
        initView();


    }

    private void initView() {
        myWebView = (WebView) findViewById(R.id.myWebView);
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        //重回下面俩个方法，就会在App中打开页面，而不是跳转到浏览器
        myWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        myWebView.loadUrl("https://mp.weixin.qq.com/s/e7c4UbRVMGZNspLhgiAz6Q");

    }
}