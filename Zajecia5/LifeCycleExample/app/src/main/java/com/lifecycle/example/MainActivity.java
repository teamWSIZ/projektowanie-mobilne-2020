package com.lifecycle.example;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle","OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeCycle","OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("LifeCycle","OnStop");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LifeCycle","OnResume");
    }
}
