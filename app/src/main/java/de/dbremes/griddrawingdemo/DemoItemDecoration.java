package de.dbremes.griddrawingdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DemoItemDecoration extends RecyclerView.ItemDecoration {
    static final String TAG = DemoItemDecoration.class.getSimpleName();
    final Paint mPaint;

    public DemoItemDecoration() {
        // For better performance don't create mPaint in each onDraw()
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(3);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        float startX = parent.getPaddingLeft();
        float startY = getYPositionOfLine(parent);
        float endX = parent.getWidth() - parent.getPaddingRight();
        float endY = startY;
        c.drawLine(startX, startY, endX, endY, mPaint);
        TextView textView = (TextView)parent.getChildAt(150);
        // Shows that RecyclerView's position != DemoAdapter's position which is what we
        // actually need
        Log.d(TAG,"parent.getChildAt(150)).getText()=" + textView.getText());
        // Shows that RecyclerView keeps only up to 250 items (10 columns * 22 rows + spare rows)
        Log.d(TAG, "parent.getChildCount()=" + parent.getChildCount());
    }

    private float getYPositionOfLine(RecyclerView parent) {
        float result = Float.NaN;
        for (int i = 0; i < parent.getChildCount(); i += 10) {
            if (parent.getChildLayoutPosition(parent.getChildAt(i)) >= 150
                    && parent.getChildLayoutPosition(parent.getChildAt(i)) < 160) {
                result = parent.getChildAt(i).getBottom();
                break;
            }
        }
        return result;
    }
}