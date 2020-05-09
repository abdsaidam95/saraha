package com.example.saraha.adapter.adaptet_pref_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.adapter.imge_profile_res.holder_of_img_prof;
import com.example.saraha.models.model_of_res_img_profile;
import com.example.saraha.models.model_pref_anather;

import java.util.ArrayList;

public class adapter_pre extends RecyclerView.Adapter<holder_pre> {
    private ArrayList<model_pref_anather> array=new ArrayList<>();
    public adapter_pre(ArrayList<model_pref_anather> array) {
        this.array = array;
    }


    @NonNull
    @Override
    public holder_pre onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_res_img_profile, parent, false);
        return new holder_pre(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_pre holder, int position) {
        holder.setData(array.get(position));

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
