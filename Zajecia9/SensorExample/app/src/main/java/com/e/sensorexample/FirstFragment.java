package com.e.sensorexample;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private float mMaxAcceleration = 0.0f;
    private TextView mAccelerationText;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAccelerationText = view.findViewById(R.id.maxAcceleration);

        mSensorManager = (SensorManager)getActivity().getSystemService(getContext().SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        mSensorManager.registerListener(this,mAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float gravity[] = event.values;
        float vectorLength = (float)Math.sqrt(gravity[0]*gravity[0]+gravity[1]*gravity[1]+gravity[2]*gravity[2]);

        if(vectorLength>mMaxAcceleration)
            mMaxAcceleration = vectorLength;

        Log.v("accelerometer","gravity = ["+gravity[0]+","+gravity[1]+","+gravity[2]+"] length="+vectorLength);
        Log.v("accelerometer", "maxAcceleration: "+mMaxAcceleration);

        mAccelerationText.setText(""+mMaxAcceleration);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
