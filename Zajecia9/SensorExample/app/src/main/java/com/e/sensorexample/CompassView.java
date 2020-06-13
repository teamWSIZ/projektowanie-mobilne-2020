package com.e.sensorexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CompassView extends View {
    private float mAzimuth = 45;
    private Paint mPaint;

    public CompassView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setBackgroundColor(Color.GRAY);

        init();
    }

    void init(){
        mPaint = new Paint();

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.BLUE);
        Rect rect = new Rect(0,0,200,200);

        //canvas.rotate(mAzimuth);
        canvas.drawRect(rect, mPaint);
    }

    void updateAzimuth(float azimuth){
        mAzimuth = azimuth;
        //invalidate();
    }
}
