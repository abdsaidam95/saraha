package com.example.saraha.adapter.adapter_of_parents_chat_recycle;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;

public class holder2_child extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView phto;
    private TextView textView;
    private Context context;
    public holder2_child(@NonNull View itemView) {
        super(itemView);
        phto=itemView.findViewById(R.id.txt_img_child);
        textView=itemView.findViewById(R.id.edit1);
        phto.setOnClickListener(this);
    }
    public void setData(type_of_post type_of_post1) {
       phto.setImageResource(type_of_post1.getPhoto());
        textView.setText(type_of_post1.getString2());

    }

    @Override
    public void onClick(View v) {
        if (v==phto){
            Toast.makeText(v.getContext(), "sadsfffds", Toast.LENGTH_SHORT).show();
        }

    }
}
