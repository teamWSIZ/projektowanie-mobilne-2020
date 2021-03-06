package com.e.databaseexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mydata")
public class MyData {
    @PrimaryKey(autoGenerate = true)
    Long id;
    double temperature;
    double humidity;

    MyData(double temperature, double humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
