package com.example.crelytics_pranilrathod.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crelytics_pranilrathod.DataModels.JSONInputModel;
import com.example.crelytics_pranilrathod.MainActivity;
import com.example.crelytics_pranilrathod.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ValueInput extends Fragment implements View.OnClickListener {
    EditText valueInputET;
    FloatingActionButton processDataBtn;

    public ValueInput() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        processDataBtn = view.findViewById(R.id.processDataBtn);
        valueInputET = view.findViewById(R.id.valueInputET);

        processDataBtn.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_value_input, container, false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.processDataBtn){
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,((MainActivity)getActivity()).fragChartDisplay).commit();
            try {
                JSONObject jsonInput = new JSONObject(valueInputET.getText().toString());
                JSONInputModel inputModel = new JSONInputModel();
                ArrayList<JSONInputModel> inputData = new ArrayList<>();
                inputModel.setMean_balance(Float.valueOf(jsonInput.get("mean_balance").toString()));
                inputModel.setMedian_balance(Float.valueOf(jsonInput.get("median_balance").toString()));
                inputModel.setMin_balance(Float.valueOf(jsonInput.get("min_balance").toString()));
                inputModel.setMode_debit(Float.valueOf(jsonInput.get("mode_debit").toString()));
                inputModel.setMode_credit(Float.valueOf(jsonInput.get("mode_credit").toString()));
                inputModel.setAvgsal(Float.valueOf(jsonInput.get("avgsal").toString()));
                inputModel.setAvgach(Float.valueOf(jsonInput.get("avgach").toString()));
                inputModel.setTotal_bounces(Integer.valueOf(jsonInput.get("total_bounces").toString()));

                JSONArray jsonArray = jsonInput.getJSONArray("raw");
                for(int i=0;i< jsonArray.length();i++){
                    Toast.makeText(getContext(), jsonArray.getString(i), Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                Toast.makeText(getContext(), "Bad Input Format", Toast.LENGTH_SHORT).show();
            }
            catch (NumberFormatException e){
                Toast.makeText(getContext(), "Expected float value", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
