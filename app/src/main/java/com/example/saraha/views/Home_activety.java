package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.saraha.Fragement.My_profile;
import com.example.saraha.Fragement.searchFragment;
import com.example.saraha.R;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;

public class Home_activety extends Base_activity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottom_nav;
    private ConstraintLayout constraintLayout ;
    private FrameLayout frameLayout;
    AdView adView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        StatusBarUtil.setTransparent( this);
    //    MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

     //   adView = findViewById(R.id.adView);


       // AdRequest adRequest = new AdRequest.Builder().build();
       // adView.loadAd(adRequest);


      //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);




            initializeView();
    }




    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        constraintLayout.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        //| View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }
    private void showSystemUI() {
        constraintLayout.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }



    public void findview(){
        bottom_nav=findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(this);
        constraintLayout=findViewById(R.id.mu_layout);
        frameLayout=findViewById(R.id.fragments_container);
    }
    private void initializeView() {
        replaceFragment(new searchFragment(), "ChatsFragment", R.id.fragments_container, false);
       findview();





    }
    private void replaceFragment(int itemId, Fragment fragment, String tag) {
        if (bottom_nav.getSelectedItemId() != itemId) {
            replaceFragment(fragment, tag, R.id.fragments_container, false);
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_Home:
                replaceFragment(item.getItemId(), new searchFragment(), "Home Fragment");


                return true;
            case R.id.navigation_story:

                replaceFragment(item.getItemId(), new My_profile(), "story Fragment");
                return true;
            case R.id.navigation_calls:

                Intent intent1 = new Intent(this, comment_actevity.class);
                startActivity(intent1);
                return true;




        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
