package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digicare.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OxygenLevel extends AppCompatActivity {

    TextView oxygenStatus, oxygenRemarks, oAverage, oLowest, oHighest, oLatest, oStatus, oRemarks;
    View oxygenCurrentStatus;
    EditText oHeartRate, oSaturation;
    Button oRecordBtn, oPreviousBtn, oAnalysisBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_level);
        oxygenStatus.setVisibility(View.GONE);

        oHeartRate = findViewById(R.id.oHeartRate);
        oSaturation = findViewById(R.id.oSaturation);
        String HR;
        Integer saturationnum;
        HR = oHeartRate.getText().toString();
        saturationnum = Integer.valueOf(oSaturation.getText().toString());

        oxygenStatus = findViewById(R.id.oxygenStatustv);
        oxygenRemarks = findViewById(R.id.oxygenRemarkstv);
        oAverage = findViewById(R.id.avgOxygen);
        oLowest = findViewById(R.id.lowestOxygen);
        oHighest = findViewById(R.id.highestOxygen);
        oLatest = findViewById(R.id.latestOxygen);

        oRecordBtn = findViewById(R.id.oRecordBtn);
        oPreviousBtn = findViewById(R.id.oPreviousBtn);
        oAnalysisBtn = findViewById(R.id.oAnalysisBtn);

        oxygenCurrentStatus = findViewById(R.id.oxygenStatus);
        oStatus = findViewById(R.id.oxygenStatustv);
        oRemarks = findViewById(R.id.oxygenRemarkstv);



        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        oRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Map<String,Object> userOxygenAnalysis = new HashMap<>();
                userOxygenAnalysis.put("HR", HR);
                userOxygenAnalysis.put("Saturation", saturationnum);
                userOxygenAnalysis.put("Date", date);



                if(saturationnum<100 && saturationnum>50) {
                    if(saturationnum>=90 && saturationnum<=100){
                        oStatus.setText("Normal");
                        oRemarks.setText("No significant intervention needed.");
                    }
                    else if(saturationnum>=85 && saturationnum<90){
                        oStatus.setText("Mild Hypoxia");
                        oRemarks.setText("Continue with Respiratory Assesments and Monitoring.");
                    }
                    else if(saturationnum>80 && saturationnum<85){
                        oStatus.setText("Hypoxic");
                        oRemarks.setText("Asses for Underlying Respiratory Disease.");
                    }
                    else if(saturationnum<79){
                        oStatus.setText("Severe Hypoxia");
                        oRemarks.setText("Administer Supplemental Oxygen immediately");
                    }
                    oxygenCurrentStatus.setVisibility(View.VISIBLE);

                    oLatest.setText(HR + "/" + saturationnum);
                    oHeartRate.setText("");
                    oSaturation.setText("");


                }
                else Toast.makeText(OxygenLevel.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
            }
        });
        oPreviousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        oAnalysisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}