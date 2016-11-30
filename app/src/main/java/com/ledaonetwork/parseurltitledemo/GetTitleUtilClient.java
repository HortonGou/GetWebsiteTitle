package com.ledaonetwork.parseurltitledemo;

import android.app.Activity;
import android.os.Build;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by ght on 2016/11/28.
 */

public class GetTitleUtilClient {
    private WebView webView;

    /**
     * 必须调用destory在activity销毁的的时候，否则会导致内存泄露
     *
     * @param activity
     */
    public GetTitleUtilClient(Activity activity) {
        webView = new WebView(activity);
    }

    public void stopLoading() {
        webView.stopLoading();
    }

    public void destory() {
        webView.destroy();
    }

    interface TitleGetListener {
        void onTitleGet(String title);
    }

    public void getTitleFromUrl(String url, final TitleGetListener callback) {
        webView.stopLoading();
        webView.loadUrl(url);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {

            }
        });
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setJavaScriptEnabled(false);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.getSettings().setBlockNetworkImage(false);
//        webView.getSettings().setDomStorageEnabled(true);
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {

            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                callback.onTitleGet(title);
                webView.stopLoading();
            }

        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    webView.loadUrl(request.getUrl().toString());
                }
                return true;
            }
        });
    }
}
