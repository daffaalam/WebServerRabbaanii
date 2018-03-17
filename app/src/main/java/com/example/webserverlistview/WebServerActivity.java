package com.example.webserverlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_server);

        WebView webServer = findViewById(R.id.webserver_web);
        webServer.loadUrl(getIntent().getStringExtra("URL"));
        webServer.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                getSupportActionBar().setTitle(view.getTitle());
                getSupportActionBar().setSubtitle(view.getUrl());
            }
        });
    }
}
