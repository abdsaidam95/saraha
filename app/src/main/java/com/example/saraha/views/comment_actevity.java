package com.example.saraha.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.LocalDatabase.UserDbController;
import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.adapter.recycle_comment.comment_adapter;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.CommentModelResc;
import com.example.saraha.models.Message;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class comment_actevity extends Base_activity implements View.OnClickListener {
    private RecyclerView recyclerView;
    public int posision=0;
    private TextView textView;
    private UserDbController userDbController;
  public   View view;
  public TextView txt;
    AdView adView;


    comment_adapter adapter;
    private ConstraintLayout constraintLayout;

    private ScrollView scrollView;
    ArrayList<Message> carsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_actevity);
        StatusBarUtil.setTransparent( this);
       MobileAds.initialize(this,"ca-app-pub-8351929453534437~2943593775");

        adView = findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        findview();


        initializeRecyclerAdapter4();
    }
    public  void findview(){
        recyclerView=findViewById(R.id.rescycle_comment);
        textView=findViewById(R.id.arrow);
        textView.setOnClickListener(this);

        userDbController=new UserDbController(this);
        constraintLayout=findViewById(R.id.consssr);

        scrollView=findViewById(R.id.sdddff);
        constraintLayout.requestFocus();
        scrollView.scrollTo(0,scrollView.getBottom());
    }

    private void initializeRecyclerAdapter4() {
        recyclerView.setHasFixedSize(true);



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getmassage();


    }

    @Override
    public void onClick(View v) {
        if (v==textView){
            Intent intent1 = new Intent(this, Home_activety.class);
            startActivity(intent1);

        }

    }

    public void getmassage(){
        final UserPref userPref=new UserPref(comment_actevity.this);

        final String s= userPref.getName();




        Call<CommentModelResc> call= RetrofitSettings.getInstance().getrequest().getmassage(s);
        call.enqueue(new Callback<CommentModelResc>() {
            @Override
            public void onResponse(Call<CommentModelResc> call, Response<CommentModelResc> response) {


                if (response.isSuccessful()) {
                    if (response.body().getMassge() == null) {
                        Toasty.info(comment_actevity.this, "\n" +  getString(R.string.no_massage), Toast.LENGTH_SHORT, true).show();

                    } else {
                        UserPref userPref = new UserPref(comment_actevity.this);
                        String idmassage = String.valueOf(response.body().getMassge().get(posision).getID());

                        userPref.save(idmassage);
                        if (idmassage == null) {
                           // Toast.makeText(comment_actevity.this, "nulllll", Toast.LENGTH_SHORT).show();
                        }

                        CommentModelResc cos = response.body();

                        carsModels = new ArrayList<>(cos.getMassge());

                        adapter = new comment_adapter(comment_actevity.this, carsModels);

                        recyclerView.setAdapter(adapter);
                        final Message na = new Message();


                        //   Toast.makeText(comment_actevity.this, "faild", Toast.LENGTH_SHORT).show();

                    }

                }
            }
            private int getCategoryPos(Message sa) {
                return carsModels.indexOf(sa);
            }









            @Override
            public void onFailure(Call<CommentModelResc> call, Throwable t) {
                Toast.makeText(comment_actevity.this, "dddddd", Toast.LENGTH_SHORT).show();


            }
        });

    }

}
