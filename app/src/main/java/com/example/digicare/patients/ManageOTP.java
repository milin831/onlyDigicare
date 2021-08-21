package com.example.digicare.patients;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digicare.R;

public class ManageOTP extends AppCompatActivity {

    EditText otpInput;
    Button verifybtn;
    String phoneNumber;
    String otpid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_otp);

        phoneNumber=getIntent().getStringExtra("mobile");
        otpInput = findViewById(R.id.otpinput);
        verifybtn = findViewById(R.id.verifybtn);

        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageOTP.this,  DoctorPatients.class);
                startActivity(intent);
            }
        });
    }
}