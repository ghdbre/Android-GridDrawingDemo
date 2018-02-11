package de.dbremes.griddrawingdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class DemoItemDecoration extends RecyclerView.ItemDecoration {
    final Paint mPaint;

    public DemoItemDecoration() {
        // For better performance don't create mPaint in each onDraw()
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        float startX = parent.getPaddingLeft();
        float startY = getYPositionOfLine(parent);
        float endX = parent.getWidth() - parent.getPaddingRight();
        float endY = startY;
        c.drawLine(startX, startY, endX, endY, mPaint);
    }

    private float getYPositionOfLine(RecyclerView parent) {
        float result = Float.NaN;
        for (int i = 0; i < parent.getChildCount(); i+=10) {
            if (parent.getChildLayoutPosition(parent.getChildAt(i)) >= 150
                    && parent.getChildLayoutPosition(parent.getChildAt(i)) < 160) {
                result = parent.getChildAt(i).getBottom();
                break;
            }
        }
        return result;
    }
}