package com.example.ravindra.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug", "OnCreate is called!");
    }

    @Override
    protected void onStart() {
        Log.d("Debug", "onStart is called!");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("Debug", "onstop is called!");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d("Debug", "onResume is called!");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("Debug", "onPause is called!");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("Debug", "onRestart is called!");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d("Debug", "onDestry is called!");
        super.onDestroy();
    }
}
