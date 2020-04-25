package com.e.databaseexample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SimpleDataInterface {
    @Insert
    void adddata(SimpleData data);

    @Query("SELECT * from simpledata")
    List<SimpleData> getData();
}
