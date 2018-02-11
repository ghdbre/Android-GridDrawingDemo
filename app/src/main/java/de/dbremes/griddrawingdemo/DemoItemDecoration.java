package de.dbremes.griddrawingdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class DemoItemDecoration extends RecyclerView.ItemDecoration {
    final String TAG = DemoItemDecoration.class.getSimpleName();
    final Paint mPaint;

    public DemoItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        float startX = parent.getPaddingLeft();
        GridLayoutManager lm = (GridLayoutManager)parent.getLayoutManager();
        int firstVisibleItemPosition = lm.findFirstVisibleItemPosition();
        Log.v(TAG, "firstVisibleItemPosition=" + firstVisibleItemPosition);
        int childToDrawUnderPosition = 150 - firstVisibleItemPosition;
        View childToDrawUnder = parent.getChildAt(childToDrawUnderPosition);
        float startY = Float.NaN;
        if (childToDrawUnder != null) {
            startY = childToDrawUnder.getBottom();
        }
        float endX = parent.getWidth() - parent.getPaddingRight();
        float endY = startY;
        c.drawLine(startX, startY, endX, endY, mPaint);
    }
}