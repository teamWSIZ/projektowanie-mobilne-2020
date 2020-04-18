package com.e.retrofitexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataViewModel dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        /*APIInterface apiInterface = RetrofitClient.getRetrofit().create(APIInterface.class);

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
