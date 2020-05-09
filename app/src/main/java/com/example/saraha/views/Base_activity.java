package com.example.saraha.views;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Base_activity extends AppCompatActivity {
    protected FragmentTransaction transaction;
    protected String currentFragment = "";
    public void replaceFragment(Fragment fragment, String tag, int container, boolean addToBackStack) {
        currentFragment = tag;

        androidx.fragment.app.FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (!addToBackStack) {
            transaction.replace(container, fragment, tag);
        } else {
            transaction.replace(container, fragment, tag);
            transaction.addToBackStack(tag);


        }
        transaction.commit();
    }
    public void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
       // decorView.setSystemUiVisibility(uiOptions);
    }
}
