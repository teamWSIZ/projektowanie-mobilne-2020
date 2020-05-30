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

    private Sensor mMagneticField;

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

        mSensorManager = (SensorManager) getActivity().getSystemService(getContext().SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float values[] = event.values;
        float vectorLength = (float) Math.sqrt(values[0] * values[0] + values[1] * values[1] + values[2] * values[2]);

        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:

                if (vectorLength > mMaxAcceleration)
                    mMaxAcceleration = vectorLength;

                Log.v("sensor", "gravity = [" + values[0] + "," + values[1] + "," + values[2] + "] length=" + vectorLength);

                mAccelerationText.setText("" + mMaxAcceleration);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:

                Log.v("sensor", "magnetic field = [" + values[0] + "," + values[1] + "," + values[2] + "] length=" + vectorLength);

                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
