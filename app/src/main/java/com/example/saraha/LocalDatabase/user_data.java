package com.example.saraha.LocalDatabase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class user_data extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "training";
    public final static String TABLE_USERS = "users";
    public static final String USER_KEY_ID = "id";
    public static final String USER_KEY_List = "List";
    public static final String USER_KEY_Token = "ToKen";
    public static final String USER_Status = "status";
    public static final String USER_Massage = "Massage";

    public user_data(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + USER_KEY_ID + " INTEGER PRIMARY KEY,"
                + USER_KEY_List + " TEXT,"
                + USER_KEY_Token + " TEXT,"
                + USER_Status + " TEXT,"
                + USER_Massage + " TEXT"
                + ")";
        db.execSQL(CREATE_USER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);

    }
}
