package com.example.saraha.adapter.adaptet_pref_2;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.hodel_of_search_resc;
import com.example.saraha.models.model_pref_anather;

public class holder_pre  extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public holder_pre(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imge_profile);

    }
    public void setData(model_pref_anather type_of_post1) {
        imageView.setImageResource(type_of_post1.getPhoto());

    }
}
