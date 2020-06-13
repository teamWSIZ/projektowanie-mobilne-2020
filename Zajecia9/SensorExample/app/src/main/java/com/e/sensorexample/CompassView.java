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

        //setBackgroundColor(Color.GRAY);

        init();
    }

    void init(){
        mPaint = new Paint();

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xcenter = getMeasuredWidth()/2;
        int ycenter = getMeasuredHeight()/2;

        int r = Math.min(xcenter,ycenter);

        mPaint.setColor(Color.BLUE);

        //canvas.translate(xcenter,ycenter);
        //canvas.rotate(mAzimuth-90);
        Rect rect = new Rect(0,0,200,200);

        //canvas.rotate(mAzimuth);
        //canvas.drawRect(rect, mPaint);
        canvas.drawLine(xcenter,ycenter,
                (float) (xcenter+r*Math.sin(Math.toRadians(mAzimuth+90))),
                (float) (ycenter+r*Math.cos(Math.toRadians(mAzimuth+90))),mPaint);
    }

    void updateAzimuth(float azimuth){
        mAzimuth = azimuth;
        invalidate();
    }
}
