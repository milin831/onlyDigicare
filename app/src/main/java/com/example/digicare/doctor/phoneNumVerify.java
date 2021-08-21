package com.example.digicare.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.digicare.R;

public class phoneNumVerify extends AppCompatActivity {

    Button lateBtn,continueBtns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_num_verify);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lateBtn=findViewById(R.id.later);
        continueBtns=findViewById(R.id.continueBtn);
        continueBtns.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ScannerQr.class)));
        lateBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginRegister.class)));
    }
}