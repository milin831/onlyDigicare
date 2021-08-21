package com.example.digicare.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.digicare.R;
import com.example.digicare.patients.LoginPatients;

public class LoginRegister extends AppCompatActivity {

    Button login,register,patientBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        register=findViewById(R.id.Register);
        login=findViewById(R.id.Login);
        patientBtn=findViewById(R.id.patient);
        patientBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginPatients.class)));
        login.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), login.class)));
        register.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), register.class)));

    }
}