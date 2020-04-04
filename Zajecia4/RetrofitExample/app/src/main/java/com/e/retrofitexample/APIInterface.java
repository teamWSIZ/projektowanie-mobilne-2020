package com.e.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("json")
    Call<List<SensorData>> getSensordata();

    @GET("json")
    Call<List<Pressure>> getPressure(@Query("limit") Integer limit);

}
