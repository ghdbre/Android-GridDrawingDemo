package de.dbremes.griddrawingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<DemoItem> demoItems = createDemoItems();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        DemoAdapter demoAdapter = new DemoAdapter(this, demoItems);
        gridview.setAdapter(demoAdapter);
    }

    private List<DemoItem> createDemoItems() {
        List<DemoItem> demoItems = new ArrayList<DemoItem>();
        for (int i =0; i < 50; i++)
            demoItems.add(new DemoItem(i));
        return demoItems;
    }
}
