package com.example.saraha.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.saraha.interfaces.ListRequestCallback;
import com.example.saraha.interfaces.ObjectRequestCallback;
import com.example.saraha.models.Example;
import com.example.saraha.models.changeprofilephoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class api_controller {
    private Context context;
    private Requests requests;
    private String email;
    private String password;
    String s1=null;
    String s2=null;
    String s3=null;
    private static  api_controller instance;


    public api_controller(Context context) {
        this.context = context;
        requests = RetrofitSettings.getRetrofitInstance().create(Requests.class);

    }
    public static api_controller getInstance(Context context) {
        if (instance == null) {
            instance = new api_controller(context);
        }
        return instance;
    }
    public void getPosts(final ListRequestCallback<Example> listRequestCallback) {
        if (isConnectedToInternet()) {
            Call<List<Example>> call = requests.getPosts();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()) {
                    listRequestCallback.onSuccess(response.body());
                } else {
                    listRequestCallback.onFailed();
                }

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
        }
    }
    public void getobject(String token,String File_name,String base64,final ObjectRequestCallback<changeprofilephoto> object){

        if (isConnectedToInternet()){
            Call<changeprofilephoto> call= requests.changeimage(token,File_name,base64);
            call.enqueue(new Callback<changeprofilephoto>() {
                @Override
                public void onResponse(Call<changeprofilephoto> call, Response<changeprofilephoto> response) {
                    object.onSuccess(response.body());

                }

                @Override
                public void onFailure(Call<changeprofilephoto> call, Throwable t) {

                }
            });
        }



    }






    public boolean isConnectedToInternet() {
        ConnectivityManager connManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connManager.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to wifi
                return true;
            }
        }
        return false;
    }
}
