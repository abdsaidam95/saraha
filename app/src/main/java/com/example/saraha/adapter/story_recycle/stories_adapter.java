package com.example.saraha.adapter.story_recycle;

import android.content.Context;
import android.content.DialogInterface;
import android.media.tv.TvContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model_of_story;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class stories_adapter extends RecyclerView.Adapter<stories_adapter.holder> {
    private List<model_of_story> itemdata = new ArrayList<>();

    private  static  Context context;
    private OnItemClickListener mListener;




    public stories_adapter(List<model_of_story> itemdata) {
        this.itemdata = itemdata;

    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }







    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_stories_holder, parent, false);
        return  new  stories_adapter.holder(view,mListener);

    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
     holder.string1.setText(itemdata.get(position).getText());


       holder.imageView.setImageResource(itemdata.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return itemdata.size();
    }

    public  static   class holder extends RecyclerView.ViewHolder  {

        public CircleImageView imageView;
        public TextView string1;
        public holder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView =itemView.findViewById(R.id.strock_img);
            string1 =itemView.findViewById(R.id.text_story);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });




        }









    }

}
