package com.example.webserverlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] url_main = {
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik1/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik2/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik3/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik4/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik5/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik6/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik7/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik8/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik9/",
            "http://192.168.2.61/PRAKTIKUM-ABIYYU/Praktik10/"
    };

    String[] judul_main = {
            "PRAKTIKUM 1",
            "PRAKTIKUM 2",
            "PRAKTIKUM 3",
            "PRAKTIKUM 4",
            "PRAKTIKUM 5",
            "PRAKTIKUM 6",
            "PRAKTIKUM 7",
            "PRAKTIKUM 8",
            "PRAKTIKUM 9",
            "PRAKTIKUM 10"
    };

    Integer[] image_main = {
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud,
            R.drawable.cloud
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web_main);
        webView.loadUrl("http://192.168.2.40/PRAKTIKUM-ABIYYU");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                getSupportActionBar().setTitle(view.getTitle());
                getSupportActionBar().setSubtitle(view.getUrl());
            }
        });

        ListView listView = findViewById(R.id.lv_main);

//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, judul_main));

        listView.setAdapter(new Adapter(this, judul_main, image_main));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, WebServerActivity.class).putExtra("URL", url_main[position]));
            }
        });

    }
}
