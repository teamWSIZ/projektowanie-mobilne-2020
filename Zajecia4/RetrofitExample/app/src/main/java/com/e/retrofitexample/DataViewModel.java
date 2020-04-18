package com.e.retrofitexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
    private double A = 0.0;
    private double B = 0.0;

    private MutableLiveData<List<SensorData>> mutableSensorData = null;

    public MutableLiveData<List<SensorData>> getMutableSensorData() {
        if(mutableSensorData==null){
            mutableSensorData = new MutableLiveData<>();
            loadSensorData();
        }
        return mutableSensorData;
    }


    void loadSensorData(){
        APIInterface apiInterface = RetrofitClient.getRetrofit().create(APIInterface.class);

        Call<List<SensorData>> sensorData = apiInterface.getSensordata();

        sensorData.enqueue(new Callback<List<SensorData>>() {
            @Override
            public void onResponse(Call<List<SensorData>> call, Response<List<SensorData>> response) {
                if(response.isSuccessful()){
                    mutableSensorData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<SensorData>> call, Throwable t) {

            }
        });
    }
}
