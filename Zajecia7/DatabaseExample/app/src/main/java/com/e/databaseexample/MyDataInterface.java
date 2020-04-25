package com.e.databaseexample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDataInterface {
    @Insert
    void insertData(MyData data);

    @Query("SELECT * from mydata")
    List<MyData> getData();
}
