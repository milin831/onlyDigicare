package com.example.digicare.doctor;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.digicare.R;
import com.example.digicare.patients.LoginPatients;
import com.example.digicare.patients.ManageOTP;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class ScannerQr extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{

    CodeScanner codeScanner;
    CodeScannerView scannerView;
    TextView resultData;
    EditText et;
    Button nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        nextbtn=findViewById(R.id.next);
        scannerView=findViewById(R.id.scannerview);
        resultData=findViewById(R.id.resultofQr);
        codeScanner=new CodeScanner(this,scannerView);

//        nextbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ScannerQr.this,  GenerateDetails.class);
//                startActivity(intent);
//            }
//        });

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        resultData.setText(result.getText());
                        if(!resultData.getText().toString().equals("")){
                            showStartDialog();
                        }
                    }
                });
            }
        });
        scannerView.setOnClickListener(v -> codeScanner.startPreview());
    }

    private void showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmation Message")
                .setMessage("Your QR has been scanned. Click on Done Button to proceed")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), GenerateDetails.class));
                        Intent i=new Intent(ScannerQr.this,GenerateDetails.class);
                        String bigstr=resultData.getText().toString();
                        i.putExtra("value",bigstr);
                        startActivity(i);
                        finish();
                    }
                })
                .create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
        requestforCamera();
    }
    @AfterPermissionGranted(123)
    private void requestforCamera() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Opening camera", Toast.LENGTH_SHORT).show();
        } else {
            EasyPermissions.requestPermissions(this, "We need permissions because this and that",
                    123, perms);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
    }
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
        }
    }
}