package com.zyablik.seventhapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager= getSupportFragmentManager();
    Fragment fragment;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager.beginTransaction().add(R.id.fragmentContainerView, Music.class, null).commit();
        Intent startIntent = new Intent(this, MusicService.class);
        startService(startIntent);
    }

    public void Alert(View view){
        fragment = new Alert();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, "alert").commit();
    }

    public void Date(View view){
        fragment = new Date();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, "date").commit();
    }

    public void Time(View view){
        fragment = new Time();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, "time").commit();
    }

    public void Music(View view){
        fragment = new Music();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, "music").commit();
    }

    public void Custom(View view){
        fragment = new Custom();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, "custom").commit();
    }
}