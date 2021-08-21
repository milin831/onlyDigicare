package com.example.digicare.doctor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.digicare.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GenerateDetails extends AppCompatActivity {

    String age,curbirth,lastFourDigits;

    Map<String,String> map=new HashMap<String, String>();
    ArrayList<String> lists;
    Button but,exmbtn;
    EditText et;
    TextView  pn , dob , g , mob , ageOf , resultData;
    int nxtText,toText;
    ImageView qrImage,imagephone;
    private static final String TAG="MainActivity";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dob=findViewById(R.id.dataofbirth);
        g=findViewById(R.id.gender);
        mob=findViewById(R.id.mobile);
        pn=findViewById(R.id.personname);
        exmbtn=findViewById(R.id.examinebtn);
        but=findViewById(R.id.refresh);
        ageOf=findViewById(R.id.age);
        resultData=findViewById(R.id.resultofQr);
        qrImage=findViewById(R.id.qrPlaceHolder);
        imagephone=findViewById(R.id.imageView2);


        lists =new ArrayList<>();

        Date d = new Date();
        CharSequence s  = DateFormat.format("yyyy ", d.getTime());


        //initialize by split
        String sentence=getIntent().getExtras().getString("value");
//        String sentence="<QPDB n=\"Milin Marathe\" u=\"xxxxxxxx5808\" g=\"M\" m=\"xxxxxx1310\" d=\"08-03-2001\" a=\"42 shivlok-5 BDA road,near deep nagar awadhpuri bhopal,Huzur,Bhopal,Madhya Pradesh,462022\" i=\"AAAADGpQICANCocKAAAAFGZ0eXBqcDIgAAAAAGpwMiAAAAAtanAyaAAAABZpaGRyAAAAyAAAAKAAAwcHAAAAAAAPY29scgEAAAAAABAAAAGZanAyY/9P/1EALwAAAAAAoAAAAMgAAAAAAAAAAAAAAKAAAADIAAAAAAAAAAAAAwcBAQcBAQcBAf9SAAwAAAABAQUEBAAA/1wAI0JvGG7qbupuvGcAZwBm4l9MX0xfZEgDSANIRU/ST9JPYf9kACIAAUNyZWF0ZWQgYnk6IEpKMjAwMCB2ZXJzaW9uIDQuMf+QAAoAAAAAAQUAAf9SAAwAAAABAQUEBAAA/5PH0GQVLho+5mEbQyHfArK3/aYjAPy6HdSBqNtrwfEOHYaMvQL/FsTk3iKiuBTB8Q4e1Qdf4hvkye17dnaYssPlKQfCZA6MGKiDafb5xXG08UpE4fCo6oNwGnEc/g4aCRpoiF6IRwEgOoL5i2vAcLARgCkXjel6HYzcgMPhah8ZqDo4TmaSHEoe+35F3a2iLaLsa4eGHw3iOadnBHoqiVUimu4uZ1TQUXltj0myGcmdAjRmx5aQOCDyk8j2gE+AgMOow6YAmVjrf2yzjY074JagwvHuuGDBbHCUAvyryGZOBxCAgICAgICAgP/Z\" x=\"\" s=\"kZyvHGkTP89IWfr96UZmYFEJ0K9exHv05R0ip8zxuaa8iCXApSczvzlChYZhnC+eYt5GuqhVyfCcSjufO71Vmy4Opybx7GPY8kw92yzdNVU1MbRDXL0jr2IET45S9IWnd5Wr+jQUVpkL0BOu54zorCWscGiok9FIb0pBlUXq8M+bw/4CSp5g27df1xU6UPGEkA05tgvDT/ydG+Ov5ec4LyYEVifcr3uv9HOjt4PApB7HUyIhifIKpUvUQ4fcLa5e9Q3CumCCcRCtQWJJ/nzZOqqmJMuM72WPyA+qU5Gy55djksG0QEgRGoF3qa1RReaEOSRfci+RZWCjgOy2Sn4TLg==\"/>";
//        String sentence="<PrintLetterBarcodeData uid=\"931501626514\" name=\"Minah Khan\" gender=\"F\" yob=\"2001\" gname=\"Shamim Uddin Khan\" co=\"D/O Shamimuddin Khan\" house=\"81, kalindi kunj\" street=\"scheme no 140\" lm=\"talab ki pal\" vtc=\"Indore\" po=\"Indore Kanadia Road\" dist=\"Indore\" subdist=\"Indore\" state=\"Madhya Pradesh\" pc=\"452016\" dob=\"13/08/2001\"/>";


//        code to generate the information from addhar card
        Pattern ptn=Pattern.compile("(\"|<QPDB |<PrintLetterBarcodeData |/>)");
        String[] arr1=ptn.split(sentence);
        for(int i=0;i<arr1.length;i++){
            if(sentence.contains("QPDB")==true){
                arr1[i]=arr1[i].replace("\"","");
                arr1[i]=arr1[i].replace("=",":");
                arr1[i]=arr1[i].replace(" n:","n:");
                arr1[i]=arr1[i].replace(" u:","u:");
                arr1[i]=arr1[i].replace(" g:","g:");
                arr1[i]=arr1[i].replace(" m:","m:");
                arr1[i]=arr1[i].replace(" d:","d:");
                arr1[i]=arr1[i].replace(":"," ");
            }else if(sentence.contains("PrintLetterBarcodeData")==true){
                arr1[i]=arr1[i].replace("\"","");
                arr1[i]=arr1[i].replace("=",":");
                arr1[i]=arr1[i].replace(" uid:","uid:");
                arr1[i]=arr1[i].replace(" name:","name:");
                arr1[i]=arr1[i].replace(" gender:","gender:");
                arr1[i]=arr1[i].replace(" yob:","yob:");
                arr1[i]=arr1[i].replace(" dob:","dob:");
                arr1[i]=arr1[i].replace(":"," ");
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr1.length; i++) {
            sb.append(arr1[i]+"::");
        }
        Pattern ptn2=Pattern.compile("::");
        String str = sb.toString();
        String[] parts = ptn2.split(str);
        HashMap<String, String> idInfo = new HashMap<String, String>();

        for(int i=1;i<parts.length;i=i+2){
            idInfo.put(parts[i], parts[i + 1]);
        }

//        converting dob into age
        try {
            if(sentence.contains("dob=")==true){
                curbirth=(idInfo.get("dob ")).toString();
            }else if(sentence.contains("d=")==true){
                curbirth=(idInfo.get("d ")).toString();
            }

            lastFourDigits = "";
            if (curbirth.length() > 4) { lastFourDigits = curbirth.substring(curbirth.length() - 4); }
            else { lastFourDigits = curbirth; }
            dob.setText(lastFourDigits);
            nxtText= Integer.parseInt(dob.getText().toString());
            toText=2021-nxtText;
            age= String.valueOf(toText);
        }catch (Exception e){
            Toast.makeText(GenerateDetails.this,"something went wrong",Toast.LENGTH_SHORT).show();
        }


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sentence.isEmpty()){
                    et.setError("value Required");
                }else{
                    QRGEncoder qrgEncoder=new QRGEncoder(sentence,null, QRGContents.Type.TEXT,500);
                    Bitmap qrBits=qrgEncoder.getBitmap();
                    qrImage.setImageBitmap(qrBits);
                }

                try {
                    if(sentence.contains("dob=")==true){
                        curbirth=(idInfo.get("dob ")).toString();
                    }else if(sentence.contains("d=")==true){
                        curbirth=(idInfo.get("d ")).toString();
                    }
                    if(sentence.contains("name=")==true){
                        pn.setText(idInfo.get("name "));
                    }else if(sentence.contains("n=")==true){
                        pn.setText(idInfo.get("n "));
                    }
                    if(sentence.contains("dob=")==true){
                        ageOf.setText(age);
                    }else if(sentence.contains("d=")==true){
                        ageOf.setText(age);
                    }
                    if(sentence.contains("gender=")==true){
                        g.setText(idInfo.get("gender "));
                    }else if(sentence.contains("g=")==true){
                        g.setText(idInfo.get("g "));
                    }
                    if(sentence.contains("m=")==true){
                        mob.setText(idInfo.get("m "));
                    }else if(sentence.contains("mob=")==true){
                        mob.setText(idInfo.get("mob "));
                    }

                }catch (Exception e){
                    Toast.makeText(GenerateDetails.this,"Please scan your QR code again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        exmbtn.setOnClickListener(v -> {


            startActivity(new Intent(getApplicationContext(), Examine.class));
            Intent i=new Intent(GenerateDetails.this,Examine.class);
            String namestr=pn.getText().toString();
            i.putExtra("name",namestr);
            startActivity(i);
            finish();
        });
        TabHost tabHost=(TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        //tab1
        TabHost.TabSpec spec=tabHost.newTabSpec("tab one");
        spec.setContent(R.id.Examine);
        spec.setIndicator("Examine");
        tabHost.addTab(spec);

        //tab2
        TabHost.TabSpec spec2=tabHost.newTabSpec("tab two");
        spec2.setContent(R.id.patientRecord);
        spec2.setIndicator("patientRecord");
        tabHost.addTab(spec2);
    }
}