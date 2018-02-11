package de.dbremes.griddrawingdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DemoAdapter extends BaseAdapter {
    private Context mContext;
    private List<DemoItem> mDemoItems;

    public DemoAdapter(Context context, List<DemoItem> demoItems) {
        mContext = context;
        mDemoItems = demoItems;
    }

    @Override
    public int getCount() {
        return mDemoItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mDemoItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mDemoItems.get(i).Id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            textView = new TextView(mContext);
        } else {
            textView = (TextView) view;
        }
        textView.setText(Integer.toString(mDemoItems.get(i).Id));
        return textView;
    }
}