package com.example.digicare.doctor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.digicare.R;

import java.util.ArrayList;
import java.util.Date;

public class Examine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examine);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String namestring=getIntent().getExtras().getString("name");
        String[] name=namestring.split(" ");

        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        //tab1
        TabHost.TabSpec spec=tabHost.newTabSpec("tab one");
        spec.setContent(R.id.Personalname);
        spec.setIndicator(name[0]+ "'s profile");
        tabHost.addTab(spec);

        //tab2
        TabHost.TabSpec spec2=tabHost.newTabSpec("tab two");
        spec2.setContent(R.id.report);
        spec2.setIndicator("report");
        tabHost.addTab(spec2);
    }
}