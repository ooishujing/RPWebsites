package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wv = findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        String s = intent.getStringExtra("website");
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setAllowFileAccess(false);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.loadUrl(s);
}
}
