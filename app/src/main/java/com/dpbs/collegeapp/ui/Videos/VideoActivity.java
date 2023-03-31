package com.dpbs.collegeapp.ui.Videos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.dpbs.collegeapp.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.checkerframework.checker.nullness.qual.NonNull;

public class VideoActivity extends AppCompatActivity {
    WebView webView;
    private ProgressBar progressBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);
       // YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("College Videos");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        progressBar = findViewById(R.id.youtubeProgress);
        progressBar.setMax(100);

        webView = (WebView) findViewById(R.id.youtube);
        webView.getSettings().setJavaScriptEnabled(true);
        // webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Html%20Files%2Fiframe.html?alt=media&token=eed63325-8c43-4d09-bc6f-a15ef8ebb7c7");
        webView.loadUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Youtube%2Fiframe.html?alt=media&token=6294611a-690f-43f8-afd1-3e4befc87a08");
        // webView.loadUrl("file:///android_asset/"+fileName);

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
//        getLifecycle().addObserver(youTubePlayerView);
//
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = "LSUAlr7_qmA";
//                youTubePlayer.loadVideo(videoId, 0);
//            }
//        });
//
//        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
//        getLifecycle().addObserver(youTubePlayerView2);
//
//        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = "nUW-CWVsV6o";
//                youTubePlayer.loadVideo(videoId, 0);
//            }
//        });
    }
}
