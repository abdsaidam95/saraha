package com.example.saraha.views;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.LocalDatabase.preffffff;
import com.example.saraha.R;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jaeger.library.StatusBarUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class welcome extends Base_activity implements View.OnClickListener {
    private Button button1;
    private Button button2;
    private ConstraintLayout constraintLayout;
    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);








        StatusBarUtil.setTransparent( this);

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e) {

        }
        catch (NoSuchAlgorithmException e) {

        }










        // MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        FacebookSdk.sdkInitialize(getApplicationContext());

        LoginManager.getInstance().logOut();







        UserPref userPref= new UserPref(this);
        userPref.logout();
        preffffff sss=new preffffff(this);
        sss.logout();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        button1=findViewById(R.id.buttsign);
        button2=findViewById(R.id.sign_up);
        constraintLayout=findViewById(R.id.intent_to_face);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        constraintLayout.setOnClickListener(this);

    }



    public void changeStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(color, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(color));
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_up:
                Intent intent = new Intent(this, create_an_account.class);
                startActivity(intent);

                break;
            case R.id.buttsign:
                Intent intent1 = new Intent(this, Login_activity.class);
                startActivity(intent1);

                break;
            case R.id.intent_to_face:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);


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

