package com.lifecycle.example;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private double A = 0.0;
    private double B = 0.0;

    private MutableLiveData<Double> mutableLiveDataA = null;
    private MutableLiveData<Double> mutableLiveDataB = null;

    public MutableLiveData<Double> getMutableLiveDataA() {
        if(mutableLiveDataA==null){
            mutableLiveDataA = new MutableLiveData<>();
            loadDataA();
        }
        return mutableLiveDataA;
    }

    public MutableLiveData<Double> getMutableLiveDataB() {
        if(mutableLiveDataB==null){
            mutableLiveDataB = new MutableLiveData<>();
            loadDataB();
        }
        return mutableLiveDataB;
    }

    void loadDataA(){
        A = 10.0;

        Log.d("LifeCycle", "LoadDataA");
        mutableLiveDataA.setValue(A);
    }

    void loadDataB(){
        B = 40.0;

        Log.d("LifeCycle", "LoadDataB");
        mutableLiveDataB.setValue(B);
    }
}
