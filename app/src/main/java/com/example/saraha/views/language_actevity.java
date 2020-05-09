package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.saraha.R;
import com.example.saraha.utils.AppLanguageUtil;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

public class language_actevity extends AppCompatActivity implements View.OnClickListener {
    private Button enLanguage;
    private Button arLanguage;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_actevity);
        StatusBarUtil.setTransparent( this);
        MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findViews();
    }
    private void findViews() {
        enLanguage = findViewById(R.id.en_language);
        arLanguage = findViewById(R.id.ar_language);


        enLanguage.setOnClickListener(this);
        arLanguage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.en_language:

                    AppLanguageUtil.getInstance().setAppLanguage(this, "en");
                    restart();
                    Intent intent=new Intent(this,setting_actevety.class);
                    startActivity(intent);



                break;

            case R.id.ar_language:
                if (!AppLanguageUtil.getInstance().isRTL()) {
                    AppLanguageUtil.getInstance().setAppLanguage(this, "ar");
                    restart();
                    Intent intent1=new Intent(this,setting_actevety.class);
                    startActivity(intent1);


                }
                break;


        }

    }
    private void restart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


}
