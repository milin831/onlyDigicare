package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.digicare.R;


public class PersonalAnalysis extends AppCompatActivity {

    String userName;
    TextView userNametv;
    View bloodPressure, bloodSugar, oxygenLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_analysis);

        userNametv = findViewById(R.id.personalAnalysisUserName);
        userName = getIntent().getStringExtra("userName");

        userNametv.setText(userName +"'s Health");

        bloodPressure = findViewById(R.id.bloodPressureCard);
        bloodSugar = findViewById(R.id.bloodSugarCard);
        oxygenLevel = findViewById(R.id.oxygenCard);

        bloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalAnalysis.this, BloodPressure.class);
                startActivity(i);
            }
        });

        bloodSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalAnalysis.this, BloodSugar.class);
                startActivity(i);
            }
        });

        oxygenLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalAnalysis.this, OxygenLevel.class);
                startActivity(i);
            }
        });
    }
}