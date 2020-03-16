package com.example.crelytics_pranilrathod;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.crelytics_pranilrathod.Fragments.ChartDisplay;
import com.example.crelytics_pranilrathod.Fragments.ValueInput;

public class MainActivity extends AppCompatActivity {
    public ValueInput fragValueInput = new ValueInput();
    public ChartDisplay fragChartDisplay = new ChartDisplay();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Crelytics");
        getSupportActionBar().setSubtitle("Assignment - Pranil Rathod");

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,fragValueInput).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.resetBtn) {
            fragValueInput = new ValueInput();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,fragValueInput).commit();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
