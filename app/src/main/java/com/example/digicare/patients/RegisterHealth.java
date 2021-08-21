package com.example.digicare.patients;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digicare.R;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class RegisterHealth extends AppCompatActivity {

    Button registerFinishbtn;
    EditText userHeight, userWeight, userBloodGroup, userAllergies;
    Boolean valid = true;
    String userNumber, Allergies, FullName, Age, Gender, Email, Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_health);

        registerFinishbtn = findViewById(R.id.regFinishBtn);
        userHeight = findViewById(R.id.tvUserHeight);
        userWeight = findViewById(R.id.tvUserWeight);
        userBloodGroup = findViewById(R.id.tvUserBloodGroup);
        userAllergies = findViewById(R.id.tvUserAllergies);
        registerFinishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterHealth.this, DoctorPatients.class);
                startActivity(i);
            }
        });
    }
}