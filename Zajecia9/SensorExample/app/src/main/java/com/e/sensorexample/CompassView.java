package com.e.sensorexample;

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

    public CompassView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        canvas.rotate(mAzimuth);
        canvas.drawRect(new Rect(0,0,200,200), paint);
    }

    void updateAzimuth(float azimuth){
        mAzimuth = azimuth;
        invalidate();
    }
}
