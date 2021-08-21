package com.example.digicare.patients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.digicare.R;

import java.util.ArrayList;

public class TreatmentsLog extends AppCompatActivity {

    ArrayList<String> drNameList, drTypeList, drAddressList, visitDateList;
    TreatmentsLogAdapter treatmentsLogAdapter;
    RecyclerView rvTreatmentsLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments_log);

        rvTreatmentsLog = findViewById(R.id.rvTreatmentsLog);
        rvTreatmentsLog.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        drNameList = new ArrayList<>();

        drNameList.add("Dr. Saiyam Jain");
        drNameList.add("Dr. Milin Marathe");
        drNameList.add("Dr. Minah Khan");
        drNameList.add("Dr. Upasana Sharma");
        drNameList.add("Dr. No Name");
        drNameList.add("Dr. Saiyam Jain");
        drNameList.add("Dr. Milin Marathe");
        drNameList.add("Dr. Minah Khan");
        drNameList.add("Dr. Upasana Sharma");

        drTypeList = new ArrayList<>();

        drTypeList.add("Pulmonologist");
        drTypeList.add("Dermatologist");
        drTypeList.add("Orthodontist");
        drTypeList.add("Cardiologist");
        drTypeList.add("No Specialisation");
        drTypeList.add("Pulmonologist");
        drTypeList.add("Dermatologist");
        drTypeList.add("Orthodontist");
        drTypeList.add("Cardiologist");

        drAddressList = new ArrayList<>();

        drAddressList.add("112, Jawahar Chowk");
        drAddressList.add("11, Royal Market");
        drAddressList.add("112, Jawahar Chowk");
        drAddressList.add("Kolar Rd., Kolar");
        drAddressList.add("Nowhere");
        drAddressList.add("112, Jawahar Chowk");
        drAddressList.add("11, Royal Market");
        drAddressList.add("112, Jawahar Chowk");
        drAddressList.add("Kolar Rd., Kolar");

        visitDateList = new ArrayList<>();

        visitDateList.add("12 May, 2021");
        visitDateList.add("10 May, 2021");
        visitDateList.add("10 May, 2021");
        visitDateList.add("8 May, 2021");
        visitDateList.add("1 April, 2021");
        visitDateList.add("27 March, 2021");
        visitDateList.add("10 March, 2021");
        visitDateList.add("9 March, 2021");
        visitDateList.add("8 March, 2021");


        treatmentsLogAdapter = new TreatmentsLogAdapter(getApplicationContext(), drNameList, drTypeList, drAddressList, visitDateList);
        rvTreatmentsLog.setAdapter(treatmentsLogAdapter);

    }
}