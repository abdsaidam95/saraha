package com.example.saraha.adapter.res1_profile_frag;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model1chiiiiid;
import com.example.saraha.models.modelchiiid;

public class holderchhiiild extends RecyclerView.ViewHolder {
    private TextView textView;

    public holderchhiiild(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.txstr);

    }
    public void setdata(model1chiiiiid model){
        textView.setText(model.getMessage());
    }
}
