package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.digicare.R;


public class BloodSugar extends AppCompatActivity {

    TextView bsStatus, bsRemark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_sugar_analysis);
    }
}