package com.example.crelytics_pranilrathod.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.crelytics_pranilrathod.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartDisplay extends Fragment {
    BarChart barChart;
    LineChart multiLineChart;

    public ChartDisplay() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barChart = view.findViewById(R.id.hBarChart);
        multiLineChart = view.findViewById(R.id.multiLineChart);

        barChart();
        multiLineChart();
    }

    private void multiLineChart() {

        //Multiline chart configuration's
        multiLineChart.setDrawGridBackground(false);
        multiLineChart.getDescription().setEnabled(false);
        multiLineChart.setDrawBorders(false);
        multiLineChart.getAxisLeft().setEnabled(false);
        multiLineChart.getAxisRight().setDrawAxisLine(false);
        multiLineChart.getAxisRight().setDrawGridLines(false);
        multiLineChart.getXAxis().setDrawAxisLine(false);
        multiLineChart.getXAxis().setDrawGridLines(false);
        multiLineChart.setTouchEnabled(true);
        multiLineChart.setDragEnabled(true);
        multiLineChart.setScaleEnabled(true);
        multiLineChart.setPinchZoom(false);

        //Legend Setup
        Legend l = multiLineChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        //Setup ArrayList Entry Set 1
        ArrayList<Entry> dataGroup1 = new ArrayList<>();
        dataGroup1.add(new Entry(0,4260.0f));
        dataGroup1.add(new Entry(1,4260.0f));
        dataGroup1.add(new Entry(2,0.0f));
        dataGroup1.add(new Entry(3,20.0f));
        dataGroup1.add(new Entry(4,4260.0f));

        //Setup ArrayList Entry Set 2
        ArrayList<Entry> dataGroup2 = new ArrayList<>();
        dataGroup2.add(new Entry(0,60.0f));
        dataGroup2.add(new Entry(1,0.0f));
        dataGroup2.add(new Entry(2,4200.0f));
        dataGroup2.add(new Entry(3,22.0f));
        dataGroup2.add(new Entry(4,4200.0f));

        //Multiline DataSet's
        LineDataSet ld1 = new LineDataSet(dataGroup1,"Group 1");
        LineDataSet ld2 = new LineDataSet(dataGroup2,"Group 2");

        ld1.setColor(ColorTemplate.VORDIPLOM_COLORS[3]);
        ld2.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
        ld1.setValueTextSize(10);
        ld2.setValueTextSize(10);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(ld1);
        dataSets.add(ld2);

        LineData data = new LineData(dataSets);

        //Label For XAxis
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Balance");
        xAxisLabel.add("Credit");
        xAxisLabel.add("Debit");
        xAxisLabel.add("ID");
        xAxisLabel.add("Amount");

        //Label Formatter
        XAxis xAxis = multiLineChart.getXAxis();
        xAxis.setLabelCount(3  ,false);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                if (value >= 0) {
                    //Display label only at available axisLabel Index
                    if (value <= xAxisLabel.size() - 1) {
                        return xAxisLabel.get((int) value);
                    }
                    //Else display nothing
                    return "";
                }
                return "";
            }
        });

        multiLineChart.setData(data);
        multiLineChart.invalidate();

    }

    private void barChart() {
        barChart.getDescription().setEnabled(false);

        //Bar Values
        ArrayList<BarEntry> yvals = new ArrayList<>();

        yvals.add(new BarEntry(0,64.0f));
        yvals.add(new BarEntry(1,2160.0f));
        yvals.add(new BarEntry(2,60.0f));
        yvals.add(new BarEntry(3,4260.0f));
        yvals.add(new BarEntry(4,4200.0f));
        yvals.add(new BarEntry(5,0.0f));
        yvals.add(new BarEntry(6,0.0f));
        yvals.add(new BarEntry(7,0f));

        BarDataSet set1 = new BarDataSet(yvals,"Data set 1");
        set1.setValueTextSize(10f);
        BarData data = new BarData(set1);

        //Add xAxis Labels
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Mean Bal");
        xAxisLabel.add("Median Bal");
        xAxisLabel.add("Min Bal");
        xAxisLabel.add("Mode Deb");
        xAxisLabel.add("Mode Cred");
        xAxisLabel.add("Avg Sal");
        xAxisLabel.add("Avg Ach");
        xAxisLabel.add("Total Bounces");

        //X axis customizations
        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelCount(3  ,false);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(false);

        //Set Legend Label, Label Styling And Color Individually
        Legend l = barChart.getLegend();
        l.setTextSize(10f);
        l.setTextColor(Color.BLACK);
        l.setForm(Legend.LegendForm.CIRCLE);
        l.getEntries();
        l.setYEntrySpace(5f);
        l.setXEntrySpace(10);
        l.setWordWrapEnabled(true);

        LegendEntry l1=new LegendEntry("mean_balance",Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_amber_500));
        LegendEntry l2=new LegendEntry("median_balance", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_cyan_500));
        LegendEntry l3=new LegendEntry("min_balance", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_grey_500));
        LegendEntry l4=new LegendEntry("mode_debit", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_red_500));
        LegendEntry l5=new LegendEntry("mode_credit", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_green_500));
        LegendEntry l6=new LegendEntry("avgsal", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_purple_500));
        LegendEntry l7=new LegendEntry("avgach", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_indigo_500));
        LegendEntry l8=new LegendEntry("total_bounces", Legend.LegendForm.CIRCLE,10f,2f,null,getContext().getResources().getColor(R.color.md_teal_500));

        l.setCustom(new LegendEntry[]{l1,l2,l3,l4,l5,l6,l7,l8});
        l.setEnabled(true);

        //Set Bar Color Individually
        set1.setColors(getContext().getResources().getColor(R.color.md_amber_500),
                getContext().getResources().getColor(R.color.md_cyan_500),
                getContext().getResources().getColor(R.color.md_grey_500),
                getContext().getResources().getColor(R.color.md_red_500),
                getContext().getResources().getColor(R.color.md_green_500),
                getContext().getResources().getColor(R.color.md_purple_500),
                getContext().getResources().getColor(R.color.md_indigo_500),
                getContext().getResources().getColor(R.color.md_teal_500));

        //Label Formatter
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                if (value >= 0) {
                    //Display label only at available axisLabel Index
                    if (value <= xAxisLabel.size() - 1) {
                        return xAxisLabel.get((int) value);
                    }
                    //Else display nothing
                    return "";
                }
                return "";
            }
        });

        //Set Data
        barChart.setData(data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart_display, container, false);
    }

}