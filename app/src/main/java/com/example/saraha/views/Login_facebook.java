package com.example.saraha.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.modelfaceloginparent;
import com.jaeger.library.StatusBarUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_facebook extends Base_activity implements View.OnClickListener {
    private TextView textView;
    ProgressDialog progressDoalog;
    private TextView textView1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
        StatusBarUtil.setTransparent(this);
        textView=findViewById(R.id.pass);
        button = findViewById(R.id.log_in);
        textView1=findViewById(R.id.return_to_welcome);
        button.setOnClickListener(this);
        textView1.setOnClickListener(this);
    }
    public void showprrogresspae(){
        progressDoalog = new ProgressDialog(Login_facebook.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("the request is executed");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    @Override
    public void onClick(View v) {
        if (v==button){
            loginface();
            textView.setText("");

        }
        else if (v==textView1){
            Intent intent=new Intent(this,choise_facebook.class);
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,choise_facebook.class);
        startActivity(intent);
    }

    public void loginface(){
        String nikename=textView.getText().toString().trim();

        if (nikename.isEmpty()){
            textView.setError("Email is required");
            textView.requestFocus();
            return;

        }
        String privacy="AXkWOFNSlhZCanhXQuERrzKIRMQS1BdywgZDZD";
        Call<modelfaceloginparent> call= RetrofitSettings.getInstance().getrequest().loginfacebook(nikename,privacy);
        showprrogresspae();
        // show it
        progressDoalog.show();
        call.enqueue(new Callback<modelfaceloginparent>() {
            @Override
            public void onResponse(Call<modelfaceloginparent> call, Response<modelfaceloginparent> response) {
                progressDoalog.dismiss();
                if (response.isSuccessful()){
                    if (response.body().getInfo()==null){
                        Toast.makeText(Login_facebook.this, "null", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        String id = String.valueOf(response.body().getInfo().get(0).getID());
                        UserPref userPref = new UserPref(Login_facebook.this);
                      //  Toast.makeText(Login_facebook.this, ""+response.body().getInfo().get(0).getImage(), Toast.LENGTH_SHORT).show();4
                        if(response.body().getInfo().get(0).getImage().trim().equalsIgnoreCase("")&&response.body().getInfo().get(0).getDetails().trim().equalsIgnoreCase("") )
                        {
                            userPref.saveUser(response.body().getAccessToken(),"", response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), "");

                        }else{
                            userPref.saveUser(response.body().getAccessToken(), response.body().getInfo().get(0).getImage(), response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(),response.body().getInfo().get(0).getDetails());

                        }

//                        try {
//
//                           // if (!response.body().getInfo().get(0).getDetails().toString().equals(null)){
//                            //   Toast.makeText(Login_facebook.this, "mmmmmm", Toast.LENGTH_SHORT).show();
//                             //  userPref.saveUser(response.body().getAccessToken(), "", response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), "");
//
//                          // }
//                          //  else if (!response.body().getInfo().get(0).getImage().equals(null)||response.body().getInfo().get(0).getDetails().toString()!=null){
//                            //   Toast.makeText(Login_facebook.this, "cccccccccc", Toast.LENGTH_SHORT).show();
//                            //   userPref.saveUser(response.body().getAccessToken(), response.body().getInfo().get(0).getImage(), response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), response.body().getInfo().get(0).getDetails().toString());
//                        //   }
//
//
//                        }catch (Exception  e){
//                        }
                       // Toasty.success(Login_facebook.this, getString(R.string.sucsess_login), Toast.LENGTH_SHORT, true).show();
                        Intent intent = new Intent(Login_facebook.this, Home_activety.class);
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(Login_facebook.this, "null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<modelfaceloginparent> call, Throwable t) {

            }
        });


    }
}
