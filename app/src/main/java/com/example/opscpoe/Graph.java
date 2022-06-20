package com.example.opscpoe;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.opscpoe.databinding.ActivityGraphBinding;

import java.util.ArrayList;

public class Graph extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGraphBinding binding;

    ArrayList barArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_graph);
        BarChart barChart = findViewById(R.id.barchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArraylist, "Jared");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);





    }



    private void getData()
    {
        barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(2f, 10, "Sunday"));
        barArraylist.add(new BarEntry(3f, 20, "Sunday"));
        barArraylist.add(new BarEntry(4f, 30, "Sunday"));
        barArraylist.add(new BarEntry(5f, 50, "Sunday"));
        barArraylist.add(new BarEntry(6f, 60, "Sunday"));

    }
}



