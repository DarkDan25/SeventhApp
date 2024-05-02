package com.zyablik.seventhapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    private MediaPlayer mediaPlayer;
    private TextView music_state;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.neosphere);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Toast.makeText(MusicService.this, "Start playing...", Toast.LENGTH_LONG).show();
            music_state.findViewById(R.id.music_state);
            music_state.setText("Playing");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            Log.d(TAG, "Music stopped");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}