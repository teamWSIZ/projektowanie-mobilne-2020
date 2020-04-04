package com.e.retrofitexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIInterface apiInterface = RetrofitClient.getRetrofit().create(APIInterface.class);

    }
}
