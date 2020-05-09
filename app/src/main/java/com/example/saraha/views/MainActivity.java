package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.modelfaceloginparent;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jaeger.library.StatusBarUtil;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;


public class MainActivity extends AppCompatActivity {
    public static final String TAG="faceAuthrization";
    private FirebaseAuth.AuthStateListener authStateListener;

    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparent(this);
        loginButton=findViewById(R.id.login_button);
        // loginButton.setPublishPermissions("email,public_profile");
//        loginButton.setReadPermissions(Arrays
//                .asList("public_profile", "user_friends", "email", "user_likes",
//                        "user_location", "user_birthday"));
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"));


        firebaseAuth=FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager=CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handlefacetoken(loginResult.getAccessToken());
              //  Toast.makeText(MainActivity.this, "gggggggg", Toast.LENGTH_SHORT).show();
                loginface(loginResult.getAccessToken().getUserId());
              //  GraphRequest request = GraphRequest.newMeRequest(
                    //    AccessToken.getCurrentAccessToken(),
                     //   new GraphRequest.GraphJSONObjectCallback() {
                        //    @Override
                        //    public void onCompleted(JSONObject object, GraphResponse response) {

                           //     String email=object.optString("email");
                           //     String id=object.optString("id");
                            //    Long o=object.optLong("id");


                         //   }
                      //  });
                //Bundle parameters = new Bundle();
               // parameters.putString("fields", "email");
               // request.setParameters(parameters);
              //  request.executeAsync();
               // Log.d(TAG,"onsucsess"+loginResult);



               // String m=   loginResult.getAccessToken().getUserId();
               // Log.d("ssafsdfsdf","onsucsess"+m);
               // Log.d("vvvvvvv","onsucsess"+loginResult.getAccessToken().getToken());


            }

            @Override
            public void onCancel() {
              //  Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {
             //   Toast.makeText(MainActivity.this, "onerroe"+error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("zxcvvb","ex:"+error.toString());

            }
        });
        authStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if (user!=null){
                   // Toast.makeText(MainActivity.this, "sucsess", Toast.LENGTH_SHORT).show();
                }

            }
        };



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public  void handlefacetoken(AccessToken token){

        Log.d(TAG,"handleToken"+token);
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG,"sign with credintal success");
                    FirebaseUser user=firebaseAuth.getCurrentUser();
                    user.getUid();
                    Log.d("asdf",":"+user.getUid());
                  //  Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }else {
                   // Toast.makeText(MainActivity.this, "faild", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
    public void loginface(final String id){


        String privacy="AXkWOFNSlhZCanhXQuERrzKIRMQS1BdywgZDZD";
        Call<modelfaceloginparent> call= RetrofitSettings.getInstance().getrequest().loginfacebook(id,privacy);

        // show it

        call.enqueue(new Callback<modelfaceloginparent>() {
            @Override
            public void onResponse(Call<modelfaceloginparent> call, Response<modelfaceloginparent> response) {

                if (response.isSuccessful()){
                    if (response.body().getInfo()==null){
                      //  Toast.makeText(MainActivity.this, "null", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Facebook_regster.class);
                        intent.putExtra("asdvvv",id);
                        startActivity(intent);


                    }
                    else {

                        String id = String.valueOf(response.body().getInfo().get(0).getID());
                        UserPref userPref = new UserPref(MainActivity.this);
                        //  Toast.makeText(Login_facebook.this, ""+response.body().getInfo().get(0).getImage(), Toast.LENGTH_SHORT).show();4
                        if(response.body().getInfo().get(0).getImage().trim().equalsIgnoreCase("")&&response.body().getInfo().get(0).getDetails()==null )
                        {
                            userPref.saveUser(response.body().getAccessToken(),"", response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), "");

                        }else{
                            userPref.saveUser(response.body().getAccessToken(), response.body().getInfo().get(0).getImage(), response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(),response.body().getInfo().get(0).getDetails());

                        }

//                        try {
//
//                           // if (!response.body().getInfo().get(0).getDetails().toString().equals(null)){
//                            //   Toast.makeText(Login_facebook.this, "mmmmmm", Toast.LENGTH_SHORT).show();
//                             //  userPref.saveUser(response.body().getAccessToken(), "", response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), "");
//
//                          // }
//                          //  else if (!response.body().getInfo().get(0).getImage().equals(null)||response.body().getInfo().get(0).getDetails().toString()!=null){
//                            //   Toast.makeText(Login_facebook.this, "cccccccccc", Toast.LENGTH_SHORT).show();
//                            //   userPref.saveUser(response.body().getAccessToken(), response.body().getInfo().get(0).getImage(), response.body().getInfo().get(0).getName(), response.body().getInfo().get(0).getEmail(), id, response.body().getInfo().get(0).getNickName(), response.body().getInfo().get(0).getDetails().toString());
//                        //   }
//
//
//                        }catch (Exception  e){
//                        }
                        // Toasty.success(Login_facebook.this, getString(R.string.sucsess_login), Toast.LENGTH_SHORT, true).show();
                        Intent intent = new Intent(MainActivity.this, Home_activety.class);
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Facebook_regster.class);
                    intent.putExtra("asdvvv",id);
                    startActivity(intent);
                   // Toast.makeText(MainActivity.this, "null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<modelfaceloginparent> call, Throwable t) {

            }
        });


    }

}
