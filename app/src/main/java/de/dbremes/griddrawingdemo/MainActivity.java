package de.dbremes.griddrawingdemo;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up RecyclerView
        List<DemoItem> demoItems = createDemoItems(300);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DemoAdapter demoAdapter = new DemoAdapter(this, demoItems);
        recyclerView.setAdapter(demoAdapter);
        recyclerView.addItemDecoration(new DemoItemDecoration());
        // Set up GridLayoutManager
        int spanCount = 10;
        mGridLayoutManager = new GridLayoutManager(this, spanCount);
        recyclerView.setLayoutManager(mGridLayoutManager);
    }

    private List<DemoItem> createDemoItems(int amount) {
        List<DemoItem> demoItems = new ArrayList<>();
        for (int i = 0; i < amount; i++)
            demoItems.add(new DemoItem(i));
        return demoItems;
    }
}
