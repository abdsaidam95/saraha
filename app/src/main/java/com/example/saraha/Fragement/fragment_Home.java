package com.example.saraha.Fragement;


import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.saraha.R;
import com.example.saraha.adapter.adapter_of_parents_chat_recycle.adapter_parents;

import com.example.saraha.adapter.story_recycle.stories_adapter;
import com.example.saraha.models.model_of_parnts_chat;
import com.example.saraha.models.model_of_story;
import com.example.saraha.views.MainActivity;
import com.example.saraha.views.search_actevity;
import com.example.saraha.views.stories_activity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_Home extends Fragment  {
    private View view;
    private SearchView searchView;
    private HorizontalScrollView horizontalScrollView;
    private stories_adapter stories_adapter1;

    private  RecyclerView recyclerView2;
    private RecyclerView resc_story;

    private List<model_of_story> itemdata1 = new ArrayList<>();
    private List<model_of_parnts_chat> itemdata2 = new ArrayList<>();


    public fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_fragment__home, container, false);
        findview();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        setdata();
        setdataes();
        initializeRecyclerAdapter3();
       initializeRecyclerAdapter4();
    }

    private void findview(){
        horizontalScrollView=view.findViewById(R.id.scroll);
        horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_LEFT);
        horizontalScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_LEFT);

            }
        },100L);



        searchView=view.findViewById(R.id.search);
        searchView.onActionViewExpanded();

        searchView.setIconified(true);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), search_actevity.class);
                startActivity(intent);

            }
        });
        resc_story=view.findViewById(R.id.recycle_stories);
        recyclerView2=view.findViewById(R.id.recycle_home_parent);

    }
    private void initializeRecyclerAdapter3() {

        resc_story.setNestedScrollingEnabled(false);
         stories_adapter1 =new stories_adapter (itemdata1);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        resc_story.setLayoutManager(mLayoutManager);
        resc_story.setItemAnimator(new DefaultItemAnimator());
        resc_story.setAdapter(stories_adapter1);
        stories_adapter1.setOnItemClickListener(new stories_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), stories_activity.class);
                startActivity(intent);
            }
        });

    }
    private void initializeRecyclerAdapter4() {


        adapter_parents adapter =new adapter_parents (itemdata2,getContext());
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView2.setLayoutManager(mLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private void setdata (){
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));
      itemdata1.add(new model_of_story(R.drawable.ic_oval_copy,"grehrthtr"));






    }
    private void setdataes (){
        itemdata2.add(new model_of_parnts_chat("fdgdfgdfg","dsfdfgdg",R.drawable.ic_oval));
        itemdata2.add(new model_of_parnts_chat("fdgdfgdfg","dsfdfgdg",R.drawable.ic_facebook));
        itemdata2.add(new model_of_parnts_chat("fdgdfgdfg","dsfdfgdg",R.drawable.ic_facebook));
        itemdata2.add(new model_of_parnts_chat("fdgdfgdfg","dsfdfgdg",R.drawable.ic_facebook));
        itemdata2.add(new model_of_parnts_chat("fdgdfgdfg","dsfdfgdg",R.drawable.ic_facebook));





    }






}





