package com.example.saraha.controllers;

import android.app.Application;

import com.example.saraha.storage.preferences.AppSettingsPreferences;
import com.example.saraha.utils.AppLanguageUtil;


public class AppController extends Application {


    private static AppController mInstance;

    public static AppController getInstance() {
        return mInstance;
    }

    private AppSettingsPreferences appSettingsPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        appSettingsPreferences = new AppSettingsPreferences(this);

        AppLanguageUtil.getInstance().setAppLanguage(this, AppLanguageUtil.getInstance().getAppLanguage());
    }

    public AppSettingsPreferences getAppSettingsPreferences() {
        return appSettingsPreferences;
    }
}

