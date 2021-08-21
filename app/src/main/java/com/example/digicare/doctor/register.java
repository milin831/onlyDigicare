package com.example.digicare.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.digicare.R;

public class register extends AppCompatActivity {


    ImageButton scan;
    TextView alreadySignIn;
    Button  nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextBtn=findViewById(R.id.next);
        alreadySignIn=findViewById(R.id.alreadyin);
        scan=findViewById(R.id.scanBtn);

        scan.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ScannerQr.class)));
        nextBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), phoneNumVerify.class)));
        alreadySignIn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), login.class)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}