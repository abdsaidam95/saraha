package com.example.saraha.adapter.adapter_of_parents_chat_recycle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;

public class holder1_child extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView textView1;
    private TextView textView2;
    public holder1_child(@NonNull View itemView) {
        super(itemView);
        textView1 =itemView.findViewById(R.id.txt_child);
        textView2 =itemView.findViewById(R.id.txxxxst);

    }
    public void setData(type_of_post type_of_post1) {
        textView1.setText(type_of_post1.getString1());
        textView2.setText(type_of_post1.getString2());
    }

    @Override
    public void onClick(View v) {

    }
}
