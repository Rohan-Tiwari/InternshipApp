package com.example.internshipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    float barWidth;
    float barSpace;
    float groupSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        barChart = findViewById(R.id.barChart);

        barWidth = 0.3f;
        barSpace = 0f;
        groupSpace = 0.4f;

        getEntries();

        barDataSet = new BarDataSet(barEntries, "Data Set");
        barData = new BarData(barDataSet);

        barChart.setData(barData);
        barChart.setDescription(null);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);


        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

    }

    private void getEntries(){
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 2)); //values to go from  and to
        barEntries.add(new BarEntry(2f, 4)); //values to go from  and to
        barEntries.add(new BarEntry(3f, 5)); //values to go from  and to
        barEntries.add(new BarEntry(5f, 6)); //values to go from  and to
        barEntries.add(new BarEntry(7f, 2)); //values to go from  and to
    }
}
