package com.example.saraha.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.saraha.Fragement.fragment_Home;
import com.example.saraha.R;
import com.example.saraha.adapter.adapter_of_parents_chat_recycle.adapter_parents;
import com.example.saraha.adapter.adapter_saerch.search_adapter_recycle;
import com.example.saraha.models.hodel_of_search_resc;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

public class search_actevity extends Base_activity implements View.OnClickListener {
    private ArrayList<hodel_of_search_resc> arraysearch1=new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView;
    private FrameLayout fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideNavigationBar();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_actevity);
        StatusBarUtil.setTransparent( this);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        findview();

    }
    public void findview (){
        recyclerView =findViewById(R.id.recycl_for_search);
        textView=findViewById(R.id.rggggg);
        textView.setOnClickListener(this);


    }







   // private void initializeRecyclerAdapter4() {


      //  search_adapter_recycle adapter =new search_adapter_recycle(arraysearch1);
       // final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
       // recyclerView.setLayoutManager(mLayoutManager);
       // recyclerView.setItemAnimator(new DefaultItemAnimator());
      //  recyclerView.setHasFixedSize(true);
       /// recyclerView.setAdapter(adapter);
       //adapter.notifyDataSetChanged();

    //}


    @Override
    public void onClick(View v) {
        if (v==textView){
            Intent intent = new Intent(this, Home_activety.class);
            startActivity(intent);





        }

    }
}
