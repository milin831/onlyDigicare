package com.example.digicare.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.digicare.R;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        new Handler().postDelayed((Runnable) () -> {
            Intent homeIntent=new Intent(MainActivity.this,LoginRegister.class);
            startActivity(homeIntent);
            finish();
        },SPLASH_TIME_OUT);
    }
}