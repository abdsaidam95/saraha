package com.example.saraha.adapter.imge_profile_res;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model_of_res_img_profile;

public class holder_of_img_prof extends RecyclerView.ViewHolder {
    private ImageView imageView;
    public holder_of_img_prof(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imge_profile);

    }
    public void setdata(model_of_res_img_profile  model){
        imageView.setImageResource(model.getImge());

    }
}
