package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.change_pass_models;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forget_pass_activity extends Base_activity implements View.OnClickListener {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    private Button button;
    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_activity);
        StatusBarUtil.setTransparent( this);
        MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findview();

    }
    public void findview(){
        editText=findViewById(R.id.forget_pass_with_email);
        editText1=findViewById(R.id.confirm_pass);
        button=findViewById(R.id.send);
        textView=findViewById(R.id.close_of_interface);
        editText2=findViewById(R.id.con1ss);
        textView.setOnClickListener(this);
        button.setOnClickListener(this);
    }
    public void changepass() {
        String oldpass = editText.getText().toString().trim();
        String passcurrent = editText1.getText().toString().trim();
        String confirm = editText2.getText().toString().trim();
        if (oldpass.isEmpty()) {
            editText.setError("old password is required");
            editText.requestFocus();
            return;

        }
        else  if (passcurrent.isEmpty()){
            editText1.setError("new password is required");
            editText1.requestFocus();
            return;
        }
        else  if (confirm.isEmpty()){
            editText2.setError("confirm password is required");
            editText2.requestFocus();
            return;
        }
        else  if (!confirm.equals(passcurrent)){
            editText2.setError("new password is required");
            editText2.requestFocus();
            return;
        }
        UserPref userPref=new UserPref(Forget_pass_activity.this);

        String s= userPref.getName();
        Call<change_pass_models> call= RetrofitSettings.getInstance().getrequest().chandepass(s,oldpass,passcurrent);
        call.enqueue(new Callback<change_pass_models>() {
            @Override
            public void onResponse(Call<change_pass_models> call, Response<change_pass_models> response) {
                if (response.isSuccessful()){

                    Toasty.success(Forget_pass_activity.this, getString(R.string.sucsesschange), Toast.LENGTH_SHORT, true).show();
                }
                else {

                    Toasty.error(Forget_pass_activity.this, getString(R.string.faildofchange), Toast.LENGTH_SHORT, true).show();
                }
            }

            @Override
            public void onFailure(Call<change_pass_models> call, Throwable t) {

            }
        });



    }


    @Override
    public void onClick(View v) {
        if (v==button){
            changepass();
        }
        else if (v==textView){
            Intent intent=new Intent(this,setting_actevety.class);
            startActivity(intent);
        }

    }
}

