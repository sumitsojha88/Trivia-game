package com.codewithharry.musicxdev;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    // for playing the music
    public void play(View view){
        player.start();
    }

    // for pausing the music
    public void pause(View view){
        player.pause();
    }

    // for stopping the music
    public void stop(View view){
        player.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.music);
    }
}

