package com.example.saraha.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSettings {

    public RetrofitSettings() {


        if (retrofit == null) {





            OkHttpClient client = refreshHeaders();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
    }

    private static Retrofit retrofit;
    private static  RetrofitSettings instance;
    public static final String TAG = "API_REQUESTS";
    private static final String BASE_URL = "https://api.sariiih.com/SarWebService.asmx/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            OkHttpClient client = refreshHeaders();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient refreshHeaders() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Token", "TOKEN");
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
        return client;
    }

    public static synchronized   RetrofitSettings getInstance() {
        if (instance == null) {
            instance = new RetrofitSettings();
        }
        return instance;
    }
    public Requests getrequest(){


            return  retrofit.create(Requests.class);






    }
}
