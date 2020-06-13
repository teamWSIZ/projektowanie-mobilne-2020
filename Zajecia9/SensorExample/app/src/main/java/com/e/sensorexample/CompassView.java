package com.e.sensorexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private Paint mBitmapPaint;


    private Bitmap mCompassBackground;

    public CompassView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //setBackgroundColor(Color.GRAY);

        init();
    }

    void init(){
        mPaint = new Paint();
        mBitmapPaint = new Paint();

        mCompassBackground = BitmapFactory.decodeResource(getResources(),R.drawable.compass);

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xcenter = getMeasuredWidth()/2;
        int ycenter = getMeasuredHeight()/2;

        int r = Math.min(xcenter,ycenter);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5.0f);

        //canvas.translate(xcenter,ycenter);
        //canvas.rotate(mAzimuth-90);

        Rect rect = new Rect(0,0,getMeasuredWidth(),getMeasuredHeight());

        //canvas.drawRect(rect, mPaint);
        canvas.drawBitmap(mCompassBackground,null,rect,mBitmapPaint);

        //canvas.rotate(mAzimuth);
        canvas.drawLine(xcenter,ycenter,
                (float) (xcenter+r*Math.sin(Math.toRadians(180-mAzimuth))),
                (float) (ycenter+r*Math.cos(Math.toRadians(180-mAzimuth))),mPaint);

        /*canvas.translate(xcenter,ycenter);
        canvas.rotate(mAzimuth-90);

        canvas.drawLine(0,0, r, r,mPaint);*/
    }

    void updateAzimuth(float azimuth){
        mAzimuth = azimuth;
        invalidate();
    }
}
