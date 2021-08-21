package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digicare.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button nextbtn;
    EditText userName, userAge, userGender, userEmail, userAddress;
    Boolean valid = true;
    String userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        nextbtn = findViewById(R.id.regNextBtn);
        userName = findViewById(R.id.tvUserName);
        userAge = findViewById(R.id.tvUserAge);
        userGender = findViewById(R.id.tvUserGender);
        userEmail = findViewById(R.id.tvUserEmail);
        userAddress = findViewById(R.id.tvUserAddress);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, RegisterHealth.class);
                startActivity(i);
            }
        });
    }
}