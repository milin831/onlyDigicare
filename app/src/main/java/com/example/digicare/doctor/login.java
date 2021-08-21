package com.example.digicare.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digicare.R;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class login extends AppCompatActivity{

    ImageButton scan;
    TextView alreadySignOut;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        alreadySignOut=findViewById(R.id.alreadyout);
        scan=findViewById(R.id.scanBtn);
        login=findViewById(R.id.loginBtn);
        scan.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),ScannerQr.class)));
        alreadySignOut.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), register.class)));
        login.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ScannerQr.class)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}