package com.example.saraha.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.LocalDatabase.preffffff;
import com.example.saraha.R;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

public class setting_actevety extends Base_activity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private TextView textView;
    private TextView textView1;
    private TextView languges;
    private TextView logout;
    private  TextView nobbbbsaaa;
    private TextView forpassss;
    private TextView languge;
    private TextView txtprofile;
    private TextView contactus;
    private TextView policy;
    private TextView outtt;
    private TextView contacttttt;
    private TextView nobsaoersonal;
    AdView adView;
    private TextView privacy;
    private FragmentManager fragmentManager;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTransparent( this);
        setContentView(R.layout.activity_setting_actevety);
        MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        findview();



    }
    private void findview(){
        textView=findViewById(R.id.arrrow);
        textView1=findViewById(R.id.roooooo);
        contactus=findViewById(R.id.contact_us_action);
        logout=findViewById(R.id.table_raw1);
        policy =findViewById(R.id.txt7);
        outtt=findViewById(R.id.txt26);
        outtt.setOnClickListener(this);
       policy.setOnClickListener(this);
        privacy=findViewById(R.id.privacy_policy);
        languges=findViewById(R.id.txt2);
        forpassss=findViewById(R.id.txt25);
        forpassss.setOnClickListener(this);
        languges.setOnClickListener(this);
        nobsaoersonal=findViewById(R.id.nobsa_prof);
        contactus.setOnClickListener(this);
        privacy.setOnClickListener(this);
        nobbbbsaaa=findViewById(R.id.txt9);
        nobbbbsaaa.setOnClickListener(this);
        contacttttt=findViewById(R.id.txt6);
        contacttttt.setOnClickListener(this);
        txtprofile=findViewById(R.id.txt1);
        txtprofile.setOnClickListener(this);
        textView.setOnClickListener(this);
        nobsaoersonal.setOnClickListener(this);
        languge=findViewById(R.id.language);
        languge.setOnClickListener(this);
        logout.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2=findViewById(R.id.table_raw);
        textView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==textView1  ||  v==txtprofile){
            Intent intent = new Intent(this, Edit_profile_actievity.class);
            startActivity(intent);
        }else if (v==textView){
            Intent intent = new Intent(this, Home_activety.class);
            startActivity(intent);
        //    Fragment mFragment = null;
          //  fragmentManager=getSupportFragmentManager();


//            fragmentManager.beginTransaction().replace(R.id.fragments_container, mFragment).commit();
        }
        else if (v==textView2  ||  v==forpassss){
            Intent intent = new Intent(this, Forget_pass_activity.class);
            startActivity(intent);

        }
        else if (v==contactus  ||  v==contacttttt){
            Intent intent = new Intent(this, contact_us_activity.class);
            startActivity(intent);

        }
        else if (v==languge  ||  v==languges){
            Intent intent = new Intent(this, language_actevity.class);
            startActivity(intent);

        }
        else if (v==privacy  || v==policy){
            getprivacypage();

        }
        else if (v==logout || v==outtt){
            UserPref userPref= new UserPref(this);
            userPref.logout();
            preffffff sss=new preffffff(this);
            sss.logout();
            FacebookSdk.sdkInitialize(getApplicationContext());

            LoginManager.getInstance().logOut();

            Intent intent = new Intent(this,welcome.class);
            startActivity(intent);

        }
        else if (v==nobsaoersonal  ||  v==nobbbbsaaa){
            Intent intent = new Intent(this,nobsa_actevity.class);
            startActivity(intent);

        }

        }
        public void getprivacypage(){
            String url="https://sariiih.com/Privacy/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home_activety.class);
        startActivity(intent);

    }

}
