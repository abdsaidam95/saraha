package com.example.saraha.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettingsPreferences {

    public final static String KEY_APP_LANGUAGE = "app_language";
    public final static String KEY_FIRST_RUN = "first_run";

    private static final String PREF_NAME = "AppSettingsPreferences";

    private int PRIVATE_MODE = 0;
    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private Context context;

    public AppSettingsPreferences(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    public String getAppLanguage() {
        return pref.getString(KEY_APP_LANGUAGE, "en");
    }

    public void setAppLanguage(String appLanguage) {
        editor = pref.edit();
        editor.putString(KEY_APP_LANGUAGE, appLanguage);
        editor.apply();
    }

    public void setFirstRun() {
        editor = pref.edit();
        editor.putBoolean(KEY_FIRST_RUN, false);
        editor.apply();
    }

    public boolean isFirstRun() {
        return pref.getBoolean(KEY_FIRST_RUN, true);
    }
}
