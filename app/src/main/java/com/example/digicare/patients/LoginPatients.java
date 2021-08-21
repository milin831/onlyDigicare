package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.digicare.R;
import com.hbb20.CountryCodePicker;

public class LoginPatients extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText numberet;
    Button getOTPbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patients);

        numberet = findViewById(R.id.num_input);
        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(numberet);
        getOTPbtn = findViewById(R.id.getOTPbtn);

        getOTPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPatients.this,  ManageOTP.class);
                startActivity(intent);
            }
        });
    }
}