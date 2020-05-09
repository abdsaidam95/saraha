package com.example.saraha.adapter.adapter_saerch;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.holderofarraysearch;

import de.hdodenhof.circleimageview.CircleImageView;


 public  class holder_of_resycle1 extends RecyclerView.ViewHolder {
    public TextView textView1 ;
    public TextView textView2 ;
    public CircleImageView imageView;

     public holder_of_resycle1(@NonNull View itemView) {
         super(itemView);

         textView1=itemView.findViewById(R.id.txt44);
         textView2=itemView.findViewById(R.id.textsetlisner);
         imageView=itemView.findViewById(R.id.img_searchsssss);
     }


     public void setData(holderofarraysearch type_of_post1) {
       //Picasso.get().load(type_of_post1.getImage()).into(imageView);
      //  textView1.setText(type_of_post1.getName());

    }
}
