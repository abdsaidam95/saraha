package com.example.saraha.adapter.adapter_saerch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.holderofarraysearch;
import com.example.saraha.views.User_profile_actevity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class search_adapter_recycle extends RecyclerView.Adapter<holder_of_resycle1> {
    private ArrayList<holderofarraysearch> arraysearch=new ArrayList<>();
    private ArrayList<holderofarraysearch> arraysearchfull;
    public Context context;

    public search_adapter_recycle(ArrayList<holderofarraysearch> arraysearch, Context context) {
        this.arraysearch = arraysearch;
        this.context = context;
        arraysearchfull = new ArrayList<>(arraysearch);
    }




    @NonNull
    @Override
    public holder_of_resycle1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mmmmmmmmm, parent, false);
        return new holder_of_resycle1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_of_resycle1 holder, final int position) {
    //  Picasso.get().load(arraysearch.get(position).getImage()).into(holder.imageView);
        String m=arraysearch.get(position).getImage();
        final String r="https://sariiih.com/images/thumb/"+m;
        Picasso.get().load(r).into(holder.imageView);
    // Picasso.get().load(arraysearch.get(position).getImage()) .placeholder(R.drawable.butt_1).into(holder.imageView);
       holder. textView1.setText(arraysearch.get(position).getName());



       holder.textView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            //  Toast.makeText(context, "ssssssss", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(context, User_profile_actevity.class);
             //  intent.putExtra("categoryId", arraysearch.get(position).getID());
               intent.putExtra("categoryId",String.valueOf( arraysearch.get(position).getID()));
               intent.putExtra("name",arraysearch.get(position).getName());
               intent.putExtra("nikename",arraysearch.get(position).getNickName());
               intent.putExtra("photo",r);

               context.startActivity(intent);
           }
       });

     //   holder.setData(arraysearch.get(position));



    }

    @Override
    public int getItemCount() {
        return arraysearch.size();
    }


}
