package com.example.saraha.Fragement;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.LocalDatabase.preffffff;
import com.example.saraha.R;
import com.example.saraha.adapter.adaptet_pref_2.adapter_pre;
import com.example.saraha.adapter.res1_profile_frag.adapter_res1;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.changeprofilephoto;
import com.example.saraha.models.model_pref_anather;
import com.example.saraha.models.model_res1_profile_frag;
import com.example.saraha.models.res2_massage_profile_frag;
import com.example.saraha.views.User_my_file_activity;
import com.example.saraha.views.setting_actevety;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class My_profile extends Fragment implements View.OnClickListener {
    public static final String TAG = "pos";
    private ArrayList<model_pref_anather> array1 = new ArrayList<>();
    private CircleImageView imageView;
    private ArrayList<res2_massage_profile_frag> array2 ;
   // ArrayList<Message> carsModels;
    private TextView textView;
    private TextView link_of_user;
    private TextView name;
    private TextView nikename;
    AdView adView;

    private RecyclerView recyclerView;
    private FrameLayout frameLayout;
    private RecyclerView recyclerView1;
    String namesssss;
    String nikenamessss;
    Bundle bundle;
    String strtext;

    private int position;
    private View view;
    private FragmentManager fragmentManager;




    public My_profile() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment




        view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        findview();




        return view;
    }

    public void findview() {
        recyclerView = view.findViewById(R.id.res);
        recyclerView1 = view.findViewById(R.id.res1);
        textView=view.findViewById(R.id.ing_icon);
        imageView=view.findViewById(R.id.img_profiles);
        name=view.findViewById(R.id.txtttt);
        link_of_user=view.findViewById(R.id.link_of_user);
        link_of_user.setOnClickListener(this);

        nikename=view.findViewById(R.id.tex232);
        textView.setOnClickListener(this);
        frameLayout=view.findViewById(R.id.fragments_container);
        MobileAds.initialize(getContext(),"ca-app-pub-8351929453534437~2943593775");

        adView = view.findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserPref  userPref= new UserPref(getContext());
        String link="Link:sariiih.com/up/"+userPref.getusername();
        link_of_user.setText(link.toString());
        preffffff pr=new preffffff(getContext());
        pr.getmassage();
       // Toast.makeText(getContext(), ""+pr.getmassage(), Toast.LENGTH_SHORT).show();



        String r="https://sariiih.com/Images/Thumb/"+userPref.getName();
      // String l= userPref.getmassagesssssss();
        changeprofilephoto chande=new changeprofilephoto();


      //  Toast.makeText(getContext(), ""+l, Toast.LENGTH_SHORT).show();
        userPref.Getmobile();
        userPref.getmassage();
        if (pr.getmassage()!=null) {
            final String m="https://sariiih.com/images/thumb/"+userPref.Getmobile();
            Picasso.get().load(m).into(imageView);

          try {
              Picasso.get().load(pr.getmassage()).into(imageView);
          }
          catch (Exception ex){}
        }
        else if (pr.getmassage()==""){

        }
        // Picasso.get().load(userPref.Getmobile()).into(imageView);
      //  Picasso.get().load(r).into(imageView);
        //Picasso.get().load(r).into(imageView);
        getinformation(namesssss,nikenamessss);




        setdata();

        initializeRecyclerAdapter3();
        initializeRecyclerAdapter4();


    }
    public void getinformation(String s1,String s2){
        UserPref  userPref= new UserPref(getContext());
     s1=   userPref.getusername();
     s2=   userPref.getmassage();
     name.setText(s1.toString());
     nikename.setText(s2.toString());




    }

    private void initializeRecyclerAdapter3() {

        recyclerView.setNestedScrollingEnabled(false);
        adapter_pre adapter = new adapter_pre(array1);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setdata() {
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
        array1.add(new model_pref_anather(R.drawable.ic_rc_prof_img));
    }






    private void initializeRecyclerAdapter4() {



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setHasFixedSize(true);
        getmassageinpublic();



    }


    @Override
    public void onClick(View v) {
        if (v==textView){
            Intent intent = new Intent(getActivity(), setting_actevety.class);
            startActivity(intent);
        }
        else if (v==link_of_user){
            Intent intent = new Intent(getActivity(), User_my_file_activity.class);
            startActivity(intent);

        }


    }
    public void  getmassageinpublic(){
        UserPref userPref= new UserPref(getContext());
       String id= userPref.getid();
        Call<model_res1_profile_frag> call= RetrofitSettings.getInstance().getrequest().addmassageinpuplic(id);
        call.enqueue(new Callback<model_res1_profile_frag>() {
            @Override
            public void onResponse(Call<model_res1_profile_frag> call, Response<model_res1_profile_frag> response) {
                if (response.isSuccessful()){
                    if (response.body().getMessages()==null){}
                    else {
                        model_res1_profile_frag cos = response.body();
                        array2 = new ArrayList<>(cos.getMessages());
                        adapter_res1 adapter = new adapter_res1(getContext(), array2);
                        recyclerView1.setAdapter(adapter);
                    }

                }

            }

            @Override
            public void onFailure(Call<model_res1_profile_frag> call, Throwable t) {

            }
        });


    }


}