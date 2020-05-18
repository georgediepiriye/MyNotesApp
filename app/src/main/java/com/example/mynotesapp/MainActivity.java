package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //this method is clicked when personal notes is clicked
    public void openPersonalNotes(View view) {
        Intent intent = new Intent(MainActivity.this, PersonalNotes.class);
        startActivity(intent);
    }

    //this method is clicked when works notes is clicked
    public void openWorkNotes(View view) {
        Intent intent = new Intent(MainActivity.this, WorkNotes.class);
        startActivity(intent);
    }

    //this method is clicked when personal notes is clicked
    public void openRandomNotes(View view) {
        Intent intent = new Intent(MainActivity.this, RandomNotes.class);
        startActivity(intent);
    }
}

