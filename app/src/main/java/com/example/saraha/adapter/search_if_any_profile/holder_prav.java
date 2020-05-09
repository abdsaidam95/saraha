package com.example.saraha.adapter.search_if_any_profile;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class holder_prav extends RecyclerView.ViewHolder {
    public TextView textView1 ;
    public TextView textView2 ;
    public CircleImageView imageView;
    public holder_prav(@NonNull View itemView) {
        super(itemView);
        textView1=itemView.findViewById(R.id.txt444);
        textView2=itemView.findViewById(R.id.text_butttt);
        imageView=itemView.findViewById(R.id.img_search);
    }
}
