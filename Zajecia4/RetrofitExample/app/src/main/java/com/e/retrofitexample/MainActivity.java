package com.e.retrofitexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIInterface apiInterface = RetrofitClient.getRetrofit().create(APIInterface.class);

        Call<List<SensorData>> sensorData = apiInterface.getSensordata();

        sensorData.enqueue(new Callback<List<SensorData>>() {
            @Override
            public void onResponse(Call<List<SensorData>> call, Response<List<SensorData>> response) {
                if(response.isSuccessful()){
                    Log.d("response",response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<List<SensorData>> call, Throwable t) {

            }
        });

    }
}
