package com.example.soundplay;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private static String logTag = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }
    public void buttonClick(View view) {
        int id = view.getId();
        int resourceId = 0;
        if (id == R.id.bark) {
            resourceId = R.raw.bark;
            Log.i(logTag, "buttonClick: bark");
        }
        else if (id == R.id.drip) {
            resourceId = R.raw.drip;
            Log.i(logTag, "buttonClick: drip");
        }
        else if (id == R.id.glass) {
            resourceId = R.raw.glass;
            Log.i(logTag, "buttonClick: glass");
        }
        else if (id == R.id.sonar) {
            resourceId = R.raw.sonar;
            Log.i(logTag, "buttonClick: sonar");
        }
        else {
            Log.i(logTag, "buttonClick: unrecognized");

        }
        if (resourceId > 0) {
            MediaPlayer mediaPlayer
                = MediaPlayer.create(this, resourceId);
            mediaPlayer.setOnCompletionListener(
                new OnCompletionListener() {
                    @Override
                    public void onCompletion( MediaPlayer mp )
                    {
                        mp.release();
                    }
                }
            );
            mediaPlayer.start();
        }
    }
}
