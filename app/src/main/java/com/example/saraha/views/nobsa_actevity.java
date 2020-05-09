package com.example.saraha.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.nobsa_models;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class nobsa_actevity extends AppCompatActivity {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;
   private Button buttonSend;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nobsa_actevity);
        StatusBarUtil.setTransparent(this);
        MobileAds.initialize(this,"cca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findview();

    }
    public void findview(){

        mEditTextMessage = findViewById(R.id.edit_text_message);

    buttonSend = findViewById(R.id.button_send);
    buttonSend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setinformdat();
            mEditTextMessage.setText("");

        }
    });
    }
    public void setinformdat(){
        String nobsa=mEditTextMessage.getText().toString().trim();
        if (nobsa.isEmpty()){
            mEditTextMessage.setError("Email is required");
            mEditTextMessage.requestFocus();
            return;


        }
        UserPref userPref= new UserPref(nobsa_actevity.this);
        userPref.getName();
        String l=userPref.getusername();
        Call<nobsa_models> call= RetrofitSettings.getInstance().getrequest().getnobsa(userPref.getName(),userPref.getusername(),nobsa);
        call.enqueue(new Callback<nobsa_models>() {
            @Override
            public void onResponse(Call<nobsa_models> call, Response<nobsa_models> response) {
                if (response.isSuccessful()){
                    Toasty.success(nobsa_actevity.this, "Success change Personal profile", Toast.LENGTH_SHORT, true).show();

                }
                else {
                    Toasty.error(nobsa_actevity.this, "This is an error of change Personal profile", Toast.LENGTH_SHORT, true).show();
                }

            }


            @Override
            public void onFailure(Call<nobsa_models> call, Throwable t) {

            }
        });

    }
}
