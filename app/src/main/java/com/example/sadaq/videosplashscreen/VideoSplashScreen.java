package com.example.sadaq.videosplashscreen;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

public class VideoSplashScreen extends AppCompatActivity {
    private VideoView videoView;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_splash_screen);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        videoView = (VideoView) findViewById(R.id.videoView);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.zz;
        Uri uri = Uri.parse(path);

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoSplashScreen.this,demo.class));
                finish();
            }
        });



    }
}

