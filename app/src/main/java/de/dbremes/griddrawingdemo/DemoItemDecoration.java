package de.dbremes.griddrawingdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DemoItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        float startX = parent.getPaddingLeft();
        View childToDrawUnder = parent.getChildAt(50);
        float startY = Float.NaN;
        if (childToDrawUnder != null) {
            startY = childToDrawUnder.getBottom();
        }
        float endX = parent.getWidth() - parent.getPaddingRight();
        float endY = startY;
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        c.drawLine(startX, startY, endX, endY, paint);
    }
}