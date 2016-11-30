package com.ledaonetwork.parseurltitledemo;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    GetTitleUtilClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.tv_main);
//        final WebView webView = (WebView) findViewById(R.id.webview);
        client = new GetTitleUtilClient(this);
        client.getTitleFromUrl("http://pic.mystarcloud.com/apks/upshequ1.4.0rc.apk", new GetTitleUtilClient.TitleGetListener() {
            @Override
            public void onTitleGet(String title) {
                textView.setText(title);
            }
        });
        client.getTitleFromUrl("", new GetTitleUtilClient.TitleGetListener() {
            @Override
            public void onTitleGet(String title) {
                textView.setText(title);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.destory();
    }
}
