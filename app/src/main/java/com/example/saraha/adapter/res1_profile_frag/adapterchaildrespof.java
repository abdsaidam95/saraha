package com.example.saraha.adapter.res1_profile_frag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model1chiiiiid;
import com.example.saraha.models.modelchiiid;
import com.example.saraha.models.res2_massage_profile_frag;

import java.util.ArrayList;

public class adapterchaildrespof extends RecyclerView.Adapter<holderchhiiild> {
    public ArrayList<model1chiiiiid> array=new ArrayList<>();
    public adapterchaildrespof(ArrayList<model1chiiiiid> array) {
        this.array = array;
    }


    @NonNull
    @Override
    public holderchhiiild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.txtrrrrrrrrr, parent, false);
        return new holderchhiiild(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holderchhiiild holder, int position) {
        holder.setdata(array.get(position));

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
