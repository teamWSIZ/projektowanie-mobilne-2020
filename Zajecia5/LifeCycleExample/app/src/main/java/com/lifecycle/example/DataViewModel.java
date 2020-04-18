package com.lifecycle.example;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private double A = 0.0;
    private double B = 0.0;

    MutableLiveData<Double> mutableLiveDataA = new MutableLiveData<>();
    MutableLiveData<Double> mutableLiveDataB = new MutableLiveData<>();

    void loadData(){
        A = 10.0;
        B = 40.0;

        mutableLiveDataA.setValue(A);
        mutableLiveDataB.setValue(B);
    }
}
