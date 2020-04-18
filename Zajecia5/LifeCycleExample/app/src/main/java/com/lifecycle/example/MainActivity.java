package com.lifecycle.example;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    TextView textViewValueA;
    TextView textViewValueB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewValueA = findViewById(R.id.textViewA);
        textViewValueB = findViewById(R.id.textViewB);

        textViewValueA.setText("0");
        textViewValueB.setText("0");

        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        dataViewModel.getMutableLiveDataA().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double a) {
                textViewValueA.setText("A: "+a);
            }
        });

        dataViewModel.getMutableLiveDataB().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double b) {
                textViewValueB.setText("B: "+b);
            }
        });

        Log.d("LifeCycle", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeCycle", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("LifeCycle", "OnStop");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LifeCycle", "OnResume");
    }
}
