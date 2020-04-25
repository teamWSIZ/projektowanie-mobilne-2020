package com.e.databaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyData.class, SimpleData.class}, version = 2, exportSchema = false )
abstract public class MyDatabase extends RoomDatabase {
    public abstract MyDataInterface myDataInterface();
    public abstract SimpleDataInterface mySimpleDataInterface();
}
