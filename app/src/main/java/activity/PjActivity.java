package activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.civilclass.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.AppConfig;

public class PjActivity extends AppCompatActivity {

    private WebView myWebView;
    private HashMap<String, List<String> > map = new HashMap<>();
    private List<String> tjNewsUrl = new ArrayList<>();
    private List<String> gxNewsUrl = new ArrayList<>();
    private List<String> sdNewsUrl = new ArrayList<>();
    private List<String> wdNewsUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pj);
        initView();
        initListDate();
        initDate();
    }

    private void initListDate() {
        tjNewsUrl.add("https://mp.weixin.qq.com/s/M2wcpTh6xvM2aak7sieNCg");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/bYzx-UkTcq2PeER8GIW_zw");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/pKYzhnQ4jE9JyqT7IkRORg");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/_-q_ZGLEFbVK9Akt45OMTA");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/e7c4UbRVMGZNspLhgiAz6Q");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/Q8Mp3ZiMPf-uMfj1wLDM_Q");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/SFHJSdvcgklNSQ-tIFXJYA");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/hmYWF_qplfLF4gQ9-bP1BA");
        tjNewsUrl.add("https://mp.weixin.qq.com/s/x88DtGaKSHT7FemcsPVLSQ");

        gxNewsUrl.add("https://mp.weixin.qq.com/s/M2wcpTh6xvM2aak7sieNCg");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/kq2qUP-KUMb8bc4BEqtpJg");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/pKYzhnQ4jE9JyqT7IkRORg");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/NoXJ8Q79daD8GShlz--KJA");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/HTjeq3FiBkjNCVd45FNOXg");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/BCp_fYBMKudpSNNMp1TcGg");
        gxNewsUrl.add("https://mp.weixin.qq.com/s/2DrsBEuXdSyjOrjVUUqrzw");

        sdNewsUrl.add("https://mp.weixin.qq.com/s/ebcwSZOi3QNEri6E3leeBQ");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/X9nIIW157ZLnKdZLl83AYg");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/mnN-a8QgQQl4Hv5Y10b82g");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/RGQ4jC31SboXlq4Ggwg-cA");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/qpAXtwmVbXAcxy2Dkt3gyA");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/M2wcpTh6xvM2aak7sieNCg");
        sdNewsUrl.add("https://mp.weixin.qq.com/s/pKYzhnQ4jE9JyqT7IkRORg");

        wdNewsUrl.add("https://mp.weixin.qq.com/s/pKYzhnQ4jE9JyqT7IkRORg");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/sY60mLy-oruooPXb9mPLcg");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/-k_AhGoWZwfBPe3vQOU_eA");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/P2LxO5Wt0NdrKZeVj7hJgQ");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/1iM4uCyuwH5PJDDcSHgftw");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/0hTQzc_Ba15aEFT58UtgxQ");
        wdNewsUrl.add("https://mp.weixin.qq.com/s/ebcwSZOi3QNEri6E3leeBQ");

        map.put("推荐", tjNewsUrl );
        map.put("高校", gxNewsUrl );
        map.put("刷单", sdNewsUrl );
        map.put("网贷", wdNewsUrl );

    }

    private void initDate() {
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);

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
        System.out.println(AppConfig.newType);
        String s = map.get(AppConfig.newType).get(AppConfig.pjNewsPosition);
        System.out.println("新闻类型是 " + AppConfig.newType + ", 新闻索引是 " + AppConfig.pjNewsPosition );
        myWebView.loadUrl(s);
    }

    private void initView() {
        myWebView = (WebView) findViewById(R.id.myWebView);
    }
}