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

    void init() {
        mPaint = new Paint();
        mBitmapPaint = new Paint();

        mCompassBackground = BitmapFactory.decodeResource(getResources(), R.drawable.compass);

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xcenter = getMeasuredWidth() / 2;
        int ycenter = getMeasuredHeight() / 2;

        int r = Math.min(xcenter, ycenter);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5.0f);

        //canvas.translate(xcenter,ycenter);
        //canvas.translate(100,100);
        //canvas.rotate(mAzimuth-90);

        Rect rect = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());

        //canvas.drawRect(rect, mPaint);


        //for(int i=0;i<50;i++) {
        //canvas.rotate(i*2);

        canvas.save();
        canvas.translate(rect.centerX(), rect.centerY());
        canvas.rotate(mAzimuth - 90);
        canvas.translate(-rect.centerX(), -rect.centerY());

        //canvas.rotate(20,rect.centerX(), rect.centerY());

        canvas.drawBitmap(mCompassBackground, null, rect, mBitmapPaint);
        canvas.restore();

        Rect rect1 = new Rect(0, 0, 100, 100);

        float width = getMeasuredWidth();
        float height = getMeasuredHeight();

        float xposition = 0.0f + width * 3.0f / 4.0f - rect1.width() / 2.0f;
        float yposition = 0.0f + height * 1.0f / 4.0f - rect1.height() / 2.0f;

        canvas.rotate(mAzimuth - 90, rect1.centerX(), rect1.centerY());
        canvas.translate(xposition, yposition);

        canvas.drawRect(rect1, mPaint);
        //}

        //canvas.rotate(mAzimuth);
        /*canvas.drawLine(xcenter,ycenter,
                (float) (xcenter+r*Math.sin(Math.toRadians(180-mAzimuth))),
                (float) (ycenter+r*Math.cos(Math.toRadians(180-mAzimuth))),mPaint);*/

        /*canvas.translate(xcenter,ycenter);
        canvas.rotate(mAzimuth-90);

        canvas.drawLine(0,0, r, r,mPaint);*/
    }

    void updateAzimuth(float azimuth) {
        mAzimuth = azimuth;
        invalidate();
    }
}
