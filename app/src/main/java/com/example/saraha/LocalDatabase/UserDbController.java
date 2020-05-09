package com.example.saraha.LocalDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.saraha.models.Example;
import com.example.saraha.models.Info;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Momen on 12/11/16.
 */

public class UserDbController {

    private static final String TAG = "UserDbController";

    private Context context;
    private user_data user;

    public UserDbController(Context context) {
        this.context = context;
        user = new user_data(context);
    }
    public static String strSeparator = "__,__";
    public static String convertArrayToString(List<Info> array){
        String str = "";
        if (array==null){

        }
        else {
            for (int i = 0; i < array.size(); i++) {
                str = str + array.get(i);
                // Do not append comma at the end of last element
                if (i < array.size() - 1) {
                    str = str + strSeparator;
                }
            }
        }
        return str;
    }
    public static String[] convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        return arr;
    }

    public long createUser(Example example) {
        SQLiteDatabase db = user.getWritableDatabase();


        Example example1=new Example();
        example1=example;
         List<Info>  info= example1.getInfo();
        String s4= convertArrayToString(info);



        ContentValues values = new ContentValues();
        values.put(user_data.USER_KEY_List, s4);
        values.put(user_data.USER_KEY_Token, example.getAccessToken());
        values.put(user_data.USER_Status, example.getStatus());
        values.put(user_data.USER_Massage, example.getMessageError());


        return db.insert(user_data.TABLE_USERS, "", values);
    }
    public Example getUser(int userID) {
        SQLiteDatabase db = user.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + user.TABLE_USERS + " WHERE " + user.USER_KEY_ID + " = ?";

        Log.e("User", selectQuery);

        Cursor c = db.rawQuery(selectQuery, new String[]{String.valueOf(userID)});

        if (c != null) {
            c.moveToFirst();
            return getUser(c);
        }
        return null;
    }
    private Example getUser(Cursor c) {
        Example users = new Example();

        users.setAccessToken(c.getString(c.getColumnIndex(user_data.USER_KEY_Token)));

        return users;
    }






}
