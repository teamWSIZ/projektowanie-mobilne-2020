package com.e.databaseexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "simpledata")
public class SimpleData {
    @PrimaryKey(autoGenerate = true)
    Long id;
    double pressure;
}
