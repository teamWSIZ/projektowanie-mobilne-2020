package com.e.sensorexample;

import java.util.ArrayDeque;

public class AngleFilter {
    private final int LENGTH;

    private float sinSum, cosSum;

    private ArrayDeque<Float> queue = new ArrayDeque<Float>();

    AngleFilter(int length){
        LENGTH = length;
    }

    public void add(float radians){

        sinSum += (float) Math.sin(radians);
        cosSum += (float) Math.cos(radians);

        queue.add(radians);

        if(queue.size() > LENGTH){

            float old = queue.poll();

            sinSum -= Math.sin(old);
            cosSum -= Math.cos(old);
        }
    }

    public float average(){

        int size = queue.size();
        return (float) Math.atan2(sinSum / size, cosSum / size);
    }
}
