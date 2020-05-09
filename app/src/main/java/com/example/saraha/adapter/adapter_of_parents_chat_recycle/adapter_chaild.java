package com.example.saraha.adapter.adapter_of_parents_chat_recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;

import java.util.ArrayList;

public class adapter_chaild extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<type_of_post> array_type = new ArrayList<>();
    public adapter_chaild(ArrayList<type_of_post> array_type) {
        this.array_type = array_type;
    }

    @Override
    public int getItemViewType(int position) {
        return array_type.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==type_of_post.post1){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chaild_recycle_item_1, parent, false);
            return new holder1_child(view);

        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chaid_res_item_2, parent, false);
            return new holder2_child(view);

        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof holder1_child){
            ( (holder1_child) holder).setData(array_type.get(position));

        }
        else {( (holder2_child) holder).setData(array_type.get(position));}

    }

    @Override
    public int getItemCount() {
        return array_type.size();
    }
}
