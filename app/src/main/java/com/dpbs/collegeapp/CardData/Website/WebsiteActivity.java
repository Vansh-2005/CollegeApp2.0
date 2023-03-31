package com.dpbs.collegeapp.CardData.Website;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.dpbs.collegeapp.R;

public class WebsiteActivity extends AppCompatActivity {

    private Button visitWebsite;
    private WebView WebsiteView;
    private ProgressBar wvProgress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        visitWebsite = findViewById(R.id.visitWebsite);
        WebsiteView = findViewById(R.id.websiteFrame);

        wvProgress = findViewById(R.id.wvProgress);
        wvProgress.setMax(50);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("College Website");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        visitWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent  intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://dpbspgcollege.edu.in/"));
                startActivity(intent);
                finish();
            }
        });

        WebsiteView.getSettings().setJavaScriptEnabled(true);
       WebsiteView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Website%20Iframe%2FWebsiteIframe.html?alt=media&token=9f4b585b-5aa6-4698-919d-bf89630f4df7");
        //WebsiteView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Syllabus%2FBCA%2FBCA1.pdf?alt=media&token=d5852f28-9a69-45b3-8957-d0fc9378ba8d");

        WebsiteView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                wvProgress.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                wvProgress.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });

    }
}
