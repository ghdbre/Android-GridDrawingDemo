package de.dbremes.griddrawingdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<DemoItem> mDemoItems;

    public DemoAdapter(Context context, List<DemoItem> demoItems) {
        mContext = context;
        mDemoItems = demoItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = new TextView(mContext);
        textView.setTextSize(16);
        return new DemoViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DemoViewHolder)holder).setText(mDemoItems.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mDemoItems.size();
    }
}