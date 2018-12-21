package com.sstudio.truecallerlite;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import im.delight.android.webview.AdvancedWebView;

public class RegActivity extends AppCompatActivity {
    AdvancedWebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Intent intent=new Intent(RegActivity.this,PSservice.class);
        startService(intent);
        String url="https://www.truecaller.com/";

        webView=(AdvancedWebView) findViewById(R.id.regWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setDesktopMode(true);
        webView.loadUrl(url);
        if (ActivityCompat.checkSelfPermission(RegActivity.this, Manifest.permission.READ_PHONE_STATE)
                !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},112);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("TrueCaller Lite is developed by sstudio.\n" +
                        "For more cool stuff like this, visit www.sstudiome.blogspot.com.\n" +
                        "Thanks.")
                .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Stay",null)
                .setNeutralButton("Visit blog", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri uri = Uri.parse("https://sstudiome.blogspot.in/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .show();
    }
}
