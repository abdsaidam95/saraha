package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.saraha.R;
import com.jaeger.library.StatusBarUtil;

public class choise_facebook extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private Button login;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise_facebook);
        StatusBarUtil.setTransparent(this);
        register = findViewById(R.id.en_language);
        login = findViewById(R.id.ar_language);
        textView=findViewById(R.id.arrow);
        textView.setOnClickListener(this);


        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == register) {
            Intent intent=new Intent(this,Facebook_regster.class);
            startActivity(intent);
        }
        else if (v==login){
            Intent intent=new Intent(this,Login_facebook.class);
            startActivity(intent);



        }
        else if (v==textView){
            Intent intent=new Intent(this,welcome.class);
            startActivity(intent);
        }

        }

    @Override
    public void onBackPressed() {
      Intent intent=new Intent(this,welcome.class);
      startActivity(intent);
    }
}

