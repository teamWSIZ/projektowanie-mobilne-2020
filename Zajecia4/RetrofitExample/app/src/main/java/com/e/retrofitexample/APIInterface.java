package com.e.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("json")
    Call<List<SensorData>> getSensordata();


}
