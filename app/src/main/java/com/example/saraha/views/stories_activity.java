package com.example.saraha.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.saraha.R;
import com.jaeger.library.StatusBarUtil;

public class stories_activity extends Base_activity implements View.OnClickListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_activity);
        StatusBarUtil.setTransparent( this);
            // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        findview();




    }
    public void findview(){
        textView=findViewById(R.id.xclose);
        textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v==textView){
            Intent intent1 = new Intent(this, Home_activety.class);
            startActivity(intent1);
        }

    }
}
