package com.e.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class SensorData {
    @SerializedName("wilg")
    Double humidity;
    @SerializedName("temp")
    Double temperature;
}
