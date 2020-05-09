package com.example.saraha.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.example.saraha.controllers.AppController;
import com.example.saraha.storage.preferences.AppSettingsPreferences;


import java.util.Locale;

public class AppLanguageUtil {


    private static AppLanguageUtil instance = null;
    private AppSettingsPreferences appSettingsPreferences;

    public static synchronized AppLanguageUtil getInstance() {
        if (instance == null) {
            instance = new AppLanguageUtil();
        }
        return instance;
    }

    public AppLanguageUtil() {
        appSettingsPreferences = new AppSettingsPreferences(getContext());
    }

    public void setApplicationLanguage(Context context, String newLanguage) {
        appSettingsPreferences.setAppLanguage(newLanguage);
        Resources activityRes = context.getResources();
        Configuration activityConf = activityRes.getConfiguration();
        Locale newLocale = new Locale(newLanguage);
        activityConf.setLocale(newLocale);
        activityRes.updateConfiguration(activityConf, activityRes.getDisplayMetrics());

        Resources applicationRes = context.getApplicationContext().getResources();
        Configuration applicationConf = applicationRes.getConfiguration();
        applicationConf.setLocale(newLocale);
        applicationRes.updateConfiguration(applicationConf, applicationRes.getDisplayMetrics());
    }

    public String getAppLanguage() {
        return appSettingsPreferences.getAppLanguage();
    }

    public boolean isRTL() {
        return appSettingsPreferences.getAppLanguage().equalsIgnoreCase("ar");
    }

    public void setAppLanguage(Context context, String newLanguage) {
        setApplicationLanguage(context, newLanguage);
        appSettingsPreferences.setAppLanguage(newLanguage);
    }

    private AppController getContext() {
        return AppController.getInstance();
    }
}

