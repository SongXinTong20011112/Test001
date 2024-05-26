package util;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import dialog.CustomDialog;

public class WebUtils {
    public static void initWebView(WebView webView, Context context,String url) {
        final CustomDialog customDialog = new CustomDialog(context, "正在加载...");
        customDialog.show();//显示,显示时页面不可点击,只能点击返回
        //设置硬件加速
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE,null);

        WebSettings webSettings = webView.getSettings();

        //启用JS支持
        webSettings.setJavaScriptEnabled(true);

        //启用缓存
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);

        // 设置缓存目录
        String cachePath = context.getApplicationContext().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(cachePath);

        //启用DOM存储API支持
        webSettings.setDomStorageEnabled(true);

        //启用数据库存储API支持
        webSettings.setDatabaseEnabled(true);

        // 设置WebViewClient，以便在WebView内加载页面
//        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient( new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                customDialog.dismiss();
            }
        });

        //设置web视口的宽度适应屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        //加载网页
        webView.loadUrl(url);
    }
}

