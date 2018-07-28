package com.example.aayushsarkar.profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();

        b = (Button)findViewById(R.id.call);
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v)
            {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9999999999"));
                startActivity(callIntent);
            }
        });


        double x,y;
        x=0;
        GraphView graph=(GraphView)findViewById(R.id.graph);
        series=new LineGraphSeries<>();

        int numDataPoints=500;
        for(int i=0; i<numDataPoints; i++)
        {
            x=x+0.1;
            y=Math.sin(x);
            series.appendData(new DataPoint(x,y), true,200);
        }
        graph.addSeries(series);
    }
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://cdn5.vectorstock.com/i/1000x1000/73/99/taxi-driver-with-hat-vector-19077399.jpg");
        mNames.add("Driver_1");

        mImageUrls.add("https://cdn5.vectorstock.com/i/1000x1000/73/99/taxi-driver-with-hat-vector-19077399.jpg");
        mNames.add("Driver_2");

        mImageUrls.add("https://cdn5.vectorstock.com/i/1000x1000/73/99/taxi-driver-with-hat-vector-19077399.jpg");
        mNames.add("Driver_3");

        mImageUrls.add("https://cdn5.vectorstock.com/i/1000x1000/73/99/taxi-driver-with-hat-vector-19077399.jpg");
        mNames.add("Driver_4");

        mImageUrls.add("https://cdn5.vectorstock.com/i/1000x1000/73/99/taxi-driver-with-hat-vector-19077399.jpg");
        mNames.add("Driver_5");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }


}
