package com.e.databaseexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabase database = Room.databaseBuilder(this,MyDatabase.class,"nasza_baza")
                .allowMainThreadQueries().build();

        MyDataInterface myDataInterface = database.myDataInterface();

        for(int i=0;i<10;i++)
            myDataInterface.insertData(new MyData(40,10));

        List<MyData> myData = myDataInterface.getData();


    }
}
