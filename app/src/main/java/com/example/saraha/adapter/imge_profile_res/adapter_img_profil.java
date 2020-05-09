package com.example.saraha.adapter.imge_profile_res;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model_of_res_img_profile;

import java.util.ArrayList;

public class adapter_img_profil extends RecyclerView.Adapter<holder_of_img_prof> {
    private ArrayList<model_of_res_img_profile> array=new ArrayList<>();

    public adapter_img_profil(ArrayList<model_of_res_img_profile> array) {
        this.array = array;
    }

    @NonNull
    @Override
    public holder_of_img_prof onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_res_img_profile, parent, false);
        return new holder_of_img_prof(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_of_img_prof holder, int position) {
        holder.setdata(array.get(position));


    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
