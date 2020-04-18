package com.e.retrofitexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        dataViewModel.getMutableSensorData().observe(this, new Observer<List<SensorData>>() {
            @Override
            public void onChanged(List<SensorData> sensorData) {
                Log.d("Response",sensorData.toString());
            }
        });

        /*

        Call<List<Pressure>> pressure = apiInterface.getPressure(5);

        pressure.enqueue(new Callback<List<Pressure>>() {
            @Override
            public void onResponse(Call<List<Pressure>> call, Response<List<Pressure>> response) {
                Log.d("pressure",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Pressure>> call, Throwable t) {

            }
        });

         */

    }
}
