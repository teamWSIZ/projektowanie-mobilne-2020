package com.e.databaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyData.class}, version = 1, exportSchema = false )
abstract public class MyDatabase extends RoomDatabase {
    public abstract MyDataInterface myDataInterface();
}
