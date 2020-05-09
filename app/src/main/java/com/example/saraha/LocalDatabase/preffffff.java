package com.example.saraha.LocalDatabase;

import android.content.Context;
import android.content.SharedPreferences;

public class preffffff {
    public static final String USER_KEY_List = "imge";
    private Context context;
    private SharedPreferences sharedPreferences;
    public static final String PREF_NAME = "USER_PREFffffffffff";
    public static final String idmassagesssssssss = "massage";
    private SharedPreferences.Editor editor;
    public preffffff(Context context) {
        this.context = context;
        setupPref();
    }
    private void setupPref() {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void save(String massage){
        editor.putString(idmassagesssssssss, massage);
        editor.apply();
    }
    public String getmassage() {
        return sharedPreferences.getString(idmassagesssssssss, "");
    }
    public void logout(){
        editor.clear();
        editor.apply();
    }
}
