package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saraha.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

public class contact_us_activity extends Base_activity {

    private EditText subjects;
    private EditText title;
    private Button b1;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_activity);
        StatusBarUtil.setTransparent( this);
        MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findview();
    }
    public void findview(){
        subjects=findViewById(R.id.subject);
        title=findViewById(R.id.titllle);
        b1=findViewById(R.id.sedtoemail);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
                subjects.setText("");
                title.setText("");

            }
        });



    }
    private void sendMail() {
        String recipientList = "info.sarahacc@gmail.com";
        String[] recipients = recipientList.split(",");

        String subject = subjects.getText().toString();
        String message = title.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
