package com.zyablik.seventhapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    FragmentManager fragmentManager= getSupportFragmentManager();
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager.beginTransaction().add(R.id.fragmentContainerView, Music.class, null).commit();
    }

    public void changeFragment(View view){
        int id = button.getId();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (id == R.id.alert){
            fragment = new Alert();
            transaction.replace(R.id.fragmentContainerView, fragment, "alert").commit();
        } else if (id == R.id.date) {
            fragment = new Date();
            transaction.replace(R.id.fragmentContainerView, fragment, "date").commit();
        } else if (id == R.id.time) {
            fragment = new Time();
            transaction.replace(R.id.fragmentContainerView, fragment, "time").commit();
        } else if (id == R.id.music) {
            fragment = new Music();
            transaction.replace(R.id.fragmentContainerView, fragment, "music").commit();
        }else if(id == R.id.custom){
            fragment = new Custom();
            transaction.replace(R.id.fragmentContainerView, fragment, "custom").commit();
        }
    }
}