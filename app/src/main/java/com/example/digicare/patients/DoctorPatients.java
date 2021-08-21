package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.digicare.R;

public class DoctorPatients extends AppCompatActivity {

    View treatmentsbtn, personalAnalysisbtn, userProfilebtn, helpbtn, aboutbtn;
    TextView homepageUserGreeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        treatmentsbtn = findViewById(R.id.treatmentsbtn);
        personalAnalysisbtn = findViewById(R.id.personalAnalysisbtn);
        userProfilebtn = findViewById(R.id.userProfilebtn);
        helpbtn = findViewById(R.id.helpbtn);
        aboutbtn = findViewById(R.id.aboutUsbtn);
        homepageUserGreeting = findViewById(R.id.homepageUserGreeting);

        String userName = getIntent().getStringExtra("FullName");
        homepageUserGreeting.setText("Hello, " + userName);

        treatmentsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoctorPatients.this, TreatmentsLog.class);
                startActivity(i);
            }
        });
        personalAnalysisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoctorPatients.this, PersonalAnalysis.class);
                i.putExtra("userName", userName);
                startActivity(i);
            }
        });
    }
}