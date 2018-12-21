package com.sstudio.truecallerlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import im.delight.android.webview.AdvancedWebView;

public class Search extends AppCompatActivity {
    AdvancedWebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String number=getIntent().getExtras().getString("number",""+0);
        String url="https://www.truecaller.com/search/in/"+number;
        url=url.replaceAll("\\\\+","");

        webView=(AdvancedWebView) findViewById(R.id.web);
        webView.loadUrl(url);

        Log.d("Search activity  ::  ","URL :: "+url);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }*/
    }
}
