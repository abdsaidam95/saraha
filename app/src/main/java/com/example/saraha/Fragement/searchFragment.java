package com.example.saraha.Fragement;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.adapter.adapter_saerch.search_adapter_recycle;
import com.example.saraha.adapter.search_if_any_profile.adapter_of_any_profile;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.chaid_model_of_any_profile;
import com.example.saraha.models.hodel_of_search_resc;
import com.example.saraha.models.holderofarraysearch;
import com.example.saraha.models.models_of_any_profile;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchFragment extends Fragment implements View.OnClickListener{
    private ArrayList<holderofarraysearch> arraysearch1=new ArrayList<>();
    private ArrayList<chaid_model_of_any_profile> arraysearch=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private TextView texxxxxxxxxx;
    private TextView textView;
    AdView adView;
    private SearchView searchView;
    String newTexts;
    private View view;
    private FrameLayout fr;


    public searchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       view= inflater.inflate(R.layout.fragment_search, container, false);
        findview();
       return view;
    }
    public void findview (){
        recyclerView =view.findViewById(R.id.recycl_for_search);
        recyclerView1 =view.findViewById(R.id.recycl_for_search_of_any_profile);
        texxxxxxxxxx=view.findViewById(R.id.txt222222);
        MobileAds.initialize(getContext(),"ca-app-pub-8351929453534437~2943593775");
        adView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        textView=view.findViewById(R.id.rggggg);
        searchView=view.findViewById(R.id.search1);
        textView.setOnClickListener(this);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       initializeRecyclerAdapter4();
        initializeRecyclerAdapter5();
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.INVISIBLE);
                texxxxxxxxxx.setVisibility(View.INVISIBLE);
            }
        });
    }



    @Override
    public void onClick(View v) {

    }
    private void initializeRecyclerAdapter4() {



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView1.setVisibility(View.GONE);
       getlastregister();


    }
    private void initializeRecyclerAdapter5() {



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setHasFixedSize(true);
        searchanyprofile();

       // getlastregister();

    }
    public void getlastregister(){
        Call<hodel_of_search_resc> call= RetrofitSettings.getInstance().getrequest().getuserlastrigister();
        call.enqueue(new Callback<hodel_of_search_resc>() {
            @Override
            public void onResponse(Call<hodel_of_search_resc> call, Response<hodel_of_search_resc> response) {
                if (response.isSuccessful()){
                    hodel_of_search_resc cos = response.body();
                    arraysearch1 = new ArrayList<>(cos.getInfo());
                    final search_adapter_recycle adapter =new search_adapter_recycle(arraysearch1,getContext());

                    recyclerView.setAdapter(adapter);

                   // Toast.makeText(getContext(), ""+arraysearch1.get(0).getID(), Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<hodel_of_search_resc> call, Throwable t) {

            }
        });

    }
    public void searchanyprofile(){


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {



            @Override
            public boolean onQueryTextSubmit(String query) {

                recyclerView.setVisibility(View.INVISIBLE);
                texxxxxxxxxx.setVisibility(View.INVISIBLE);
                recyclerView1.setVisibility(View.VISIBLE);
                newTexts=query;
                if (newTexts==null){}
                else {

                    Call<models_of_any_profile> call = RetrofitSettings.getInstance().getrequest().search_of_anyprofile(newTexts);
                    call.enqueue(new Callback<models_of_any_profile>() {


                        @Override
                        public void onResponse(Call<models_of_any_profile> call, Response<models_of_any_profile> response) {
                            if (response.body() == null) {
                                Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
                            } else {
                                if (response.body().getInfo() == null) {
                                    Toasty.error(getContext(), getString(R.string.accoutnotexsist), Toast.LENGTH_SHORT, true).show();

                                } else {
                                    if (response.isSuccessful()) {
                                        models_of_any_profile cos = response.body();
                                        arraysearch = new ArrayList<>(cos.getInfo());
                                        final adapter_of_any_profile adapter = new adapter_of_any_profile(arraysearch, getContext());
                                       // Toast.makeText(getContext(), "sucsess", Toast.LENGTH_SHORT).show();
                                        recyclerView1.setAdapter(adapter);

                                    } else {
                                      //  Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();

                                    }


                                }
                            }
                        }


                        @Override
                        public void onFailure(Call<models_of_any_profile> call, Throwable t) {

                        }


                    });
                }

                return true;

            }


            @Override
            public boolean onQueryTextChange(String newText) {
              //  newTexts = newText;


                return true;
            }



        });




    }
}
