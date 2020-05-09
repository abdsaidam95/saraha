package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.rigisterfacebookparent;
import com.jaeger.library.StatusBarUtil;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Facebook_regster extends Base_activity implements View.OnClickListener {


    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private TextView txt;
    private EditText editText4;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
        StatusBarUtil.setTransparent(this);
        findview();
    }
    private void findview(){
        editText1=findViewById(R.id.user_namessssss);
        editText2=findViewById(R.id.Email_register);

        txt=findViewById(R.id.textView);
        editText4=findViewById(R.id.data_bairth);

        button=findViewById(R.id.sign_up_data);
        button.setOnClickListener(this);
        txt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v==button){
            rigisterinfacebook();
            editText1.setText("");
            editText2.setText("");

            editText4.setText("");
        } else if (v==txt) {
            Intent intent=new Intent(this,welcome.class);
            startActivity(intent);
        }
        }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,welcome.class);
        startActivity(intent);

    }

    public void rigisterinfacebook(){
        String name=editText1.getText().toString().trim();
        String emaIL=editText2.getText().toString().trim();

        String contry=editText4.getText().toString().trim();
        String asd=getIntent().getExtras().getString("asdvvv");

        if (emaIL.isEmpty()) {
            editText2.setError("Email is required");
            editText2.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emaIL).matches()) {
            editText2.setError("Enter a valid email");
            editText2.requestFocus();
            return;
        }
        if (contry.isEmpty()) {
            editText4.setError("country required");
            editText4.requestFocus();
            return;
        }


        if (name.isEmpty()) {
            editText1.setError("name required");
            editText1.requestFocus();
            return;
        }
        Call<rigisterfacebookparent> call = RetrofitSettings.getInstance().getrequest().rigistertofacebook(name,emaIL,asd,"dssdvdsvds",contry,"","","");
        call.enqueue(new Callback<rigisterfacebookparent>() {
            @Override
            public void onResponse(Call<rigisterfacebookparent> call, Response<rigisterfacebookparent> response) {
                if (response.isSuccessful()){
                    if (response.body().getInfo()==null){
                        Toasty.error(Facebook_regster.this, getString(R.string.error_of_data), Toast.LENGTH_SHORT, true).show();
                    }
                    else {

                        Toasty.success(Facebook_regster.this, getString(R.string.createaccont), Toast.LENGTH_SHORT, true).show();
                        Intent intent=new Intent(Facebook_regster.this,MainActivity.class);
                        startActivity(intent);
                                       }



                }
                else {
                    Toasty.error(Facebook_regster.this, getString(R.string.error_of_data), Toast.LENGTH_SHORT, true).show();

                }
            }

            @Override
            public void onFailure(Call<rigisterfacebookparent> call, Throwable t) {
                Toast.makeText(Facebook_regster.this, "ssssssssssssssssssssssssssssss", Toast.LENGTH_SHORT).show();

            }
        });






    }
}
