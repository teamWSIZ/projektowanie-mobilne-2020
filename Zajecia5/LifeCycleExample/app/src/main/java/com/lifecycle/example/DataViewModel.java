package com.lifecycle.example;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private double A = 0.0;
    private double B = 0.0;

    private MutableLiveData<Double> mutableLiveDataA = new MutableLiveData<>();
    private MutableLiveData<Double> mutableLiveDataB = new MutableLiveData<>();

    public MutableLiveData<Double> getMutableLiveDataA() {
        return mutableLiveDataA;
    }

    public MutableLiveData<Double> getMutableLiveDataB() {
        return mutableLiveDataB;
    }

    void loadData(){
        A = 10.0;
        B = 40.0;

        mutableLiveDataA.setValue(A);
        mutableLiveDataB.setValue(B);
    }
}
