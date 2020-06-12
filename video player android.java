package com.codewithharry.harrytube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView cricket = findViewById(R.id.cricket);
        cricket.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.clip);
        MediaController mediaController = new MediaController(this);
        cricket.setMediaController(mediaController);
        mediaController.setAnchorView(cricket);
        cricket.start();
    }
}

