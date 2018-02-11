package de.dbremes.griddrawingdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DemoViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;

    public DemoViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView)itemView;
    }

    public void setText(String text) {
        mTextView.setText(text);
    }
}