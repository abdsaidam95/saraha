package com.example.saraha.Fragement;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saraha.R;
import com.example.saraha.adapter.recycle_comment.comment_adapter;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class comment_fra extends Fragment {
    private RecyclerView recyclerView;
    private View view;



    public comment_fra() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_comment_fra, container, false);
        findview();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeRecyclerAdapter4();
    }

    public void findview() {
        recyclerView = view.findViewById(R.id.rescycle_comment);
    }



    private void initializeRecyclerAdapter4() {



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);



    }
}