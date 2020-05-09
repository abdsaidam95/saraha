package com.example.saraha.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saraha.LocalDatabase.UserDbController;
import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.Example;
import com.jaeger.library.StatusBarUtil;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_activity extends Base_activity  implements View.OnClickListener {
    private TextView textView;
    private ProgressBar progressBar;
    private EditText editText1;
    String email;


    private TextView textView3;

    ProgressDialog progressDoalog;
    String password;
    private EditText editText2;
    private Example example;
    private UserDbController userDbController;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        StatusBarUtil.setTransparent(this);
        final Vibrator vibrator;

        vibrator = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);
        userDbController = new UserDbController(this);
        example = new Example();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        editText1 = findViewById(R.id.email);
        textView3 = findViewById(R.id.return_to_welcome);
        editText2 = findViewById(R.id.pass);
        progressBar = findViewById(R.id.progress);
        editText1.setOnClickListener(this);
        editText2.setOnClickListener(this);
        textView = findViewById(R.id.forget_passsss);
        button = findViewById(R.id.log_in);
        textView3.setOnClickListener(this);

        textView.setOnClickListener(this);
        button.setOnClickListener(this);
    }
    public void showprrogresspae(){
        progressDoalog = new ProgressDialog(Login_activity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getString(R.string.load));
        progressDoalog.setTitle(getString(R.string.executed));
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }


    private void userlogin(){
         email=editText1.getText().toString().trim();
         password=editText2.getText().toString().trim();
        if (email.isEmpty()){
            editText1.setError("Email is required");
            editText1.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editText1.setError("Enter Valid email");
            editText1.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editText2.setError("password required");
            editText2.requestFocus();
            return;
        }
        Call<Example>call= RetrofitSettings.getInstance().getrequest().getPostssss(email,password);
        showprrogresspae();
        // show it
        progressDoalog.show();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                progressDoalog.dismiss();
                int position = 0;
                if (response.isSuccessful()) {
                    if (response.body().getInfo() == null) {
                        Toasty.error(Login_activity.this, getString(R.string.error_in_login), Toast.LENGTH_SHORT, true).show();
                    } else {
                        String id = String.valueOf(response.body().getInfo().get(position).getID());
                        UserPref userPref = new UserPref(Login_activity.this);
                        userPref.saveUser(response.body().getAccessToken(), response.body().getInfo().get(0).getImage(), response.body().getInfo().get(position).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), response.body().getInfo().get(0).getDetails().toString());
                        Log.d("dddddd",response.body().getAccessToken());


                        Long asd = userDbController.createUser(example);

                        Toasty.success(Login_activity.this, getString(R.string.sucsess_login), Toast.LENGTH_SHORT, true).show();
                        Intent intent = new Intent(Login_activity.this, Home_activety.class);
                        startActivity(intent);

                        //   Toast.makeText(Login_activity.this, "aaaaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

                    }
                }
                else{
                        Toasty.error(Login_activity.this, "This is an error of Login", Toast.LENGTH_SHORT, true).show();

                    }

                }




            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressDoalog.dismiss();


            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forget_passsss:


                break;
            case R.id.log_in:
                userlogin();


                break;
            case R.id.return_to_welcome:
               Intent intent=new Intent(this,welcome.class);
               startActivity(intent);
                break;



        }}

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }
}

