package com.example.saraha.LocalDatabase;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPref {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String PREF_NAME = "USER_PREF";
    public static final int MODE_PRIVATE = 0;

    public static final String KEY_NAME = "ToKwn";
    public static final String idmassage = "massage";
    public static final String idmassagesssssssss = "massage";
    public static final String nobsa = "nobsa";
    public static final String emails = "email";
    public static final String usernames = "username";
    public static final String ids = "idd";

    public static final String KEY_MOBILE = "mobile";

    public UserPref(Context context) {
        this.context = context;
        setupPref();
    }

    private void setupPref() {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUser(String name, String mobile,String username,String email,String id,String massage,String nobs) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(idmassage, massage);
        editor.putString(usernames, username);
        editor.putString(ids, id);
        editor.putString(emails, email);
        editor.putString(nobsa, nobs);
        editor.apply();
    }
    public void save(String massage){
        editor.putString(idmassagesssssssss, massage);
        editor.apply();
    }

    public String getName(){
        return sharedPreferences.getString(KEY_NAME, "");
    }
    public String getid(){
        return sharedPreferences.getString(ids, "");
    }
    public String getnobsaaa(){
        return sharedPreferences.getString(nobsa, "");
    }



    public String getusername(){
        return sharedPreferences.getString(usernames, "");
    }
    public String getmassage() {
        return sharedPreferences.getString(idmassage, "");
    }
        public String getmassagesssssss(){
            return sharedPreferences.getString(idmassagesssssssss, "");
    }
    public String getemail(){
        return sharedPreferences.getString(emails, "");
    }
    public String Getmobile(){
        return sharedPreferences.getString(KEY_MOBILE, "");
    }
    public void logout(){
        editor.clear();
        editor.apply();
    }

}
