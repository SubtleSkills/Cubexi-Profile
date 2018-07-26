package com.example.aayushsarkar.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
