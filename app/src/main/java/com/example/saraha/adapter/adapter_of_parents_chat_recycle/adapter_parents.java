package com.example.saraha.adapter.adapter_of_parents_chat_recycle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model_of_parnts_chat;
import com.example.saraha.models.model_of_story;
import com.example.saraha.views.Home_activety;
import com.example.saraha.views.Login_activity;
import com.example.saraha.views.User_profile_actevity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class adapter_parents extends RecyclerView.Adapter<adapter_parents.holder_of_res> {
    private List<model_of_parnts_chat> arraychat=new ArrayList<>();
    private ArrayList<type_of_post> arraychaild=new ArrayList<>();
    private Context context;

    public adapter_parents(List<model_of_parnts_chat> arraychat, Context context) {
        this.arraychat = arraychat;
        this.context = context;
    }

    @NonNull
    @Override
    public holder_of_res onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_of_recycle_parent_1, parent, false);
        return new holder_of_res(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_of_res holder, int position) {
        holder.textView1.setText(arraychat.get(position).getSt1());
        holder.textView1.setText(arraychat.get(position).getSt2());
        holder.img.setImageResource(arraychat.get(position).getPhp());
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setHasFixedSize(true);
        arraychaild.clear();
        setdata();
        adapter_chaild adapter =new adapter_chaild(arraychaild);
        holder.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return arraychat.size();
    }
    private void  setdata(){
        arraychaild.add(new type_of_post(type_of_post.post1,"hgfghfghfghfgh","dfgdfsgsdfgdsfg"));
        arraychaild.add(new type_of_post(type_of_post.post2,R.drawable.ic_imge_212,"dsgdfgdfhfhgfhfgh"));
        arraychaild.add(new type_of_post(type_of_post.post2,R.drawable.ic_imge_212,"dsgdfgdfhfhgfhfgh"));
        arraychaild.add(new type_of_post(type_of_post.post2,R.drawable.ic_imge_212,"dsgdfgdfhfhgfhfgh"));
        arraychaild.add(new type_of_post(type_of_post.post2,R.drawable.ic_imge_212,"dsgdfgdfhfhgfhfgh"));
        arraychaild.add(new type_of_post(type_of_post.post2,R.drawable.ic_imge_212,"dsgdfgdfhfhgfhfgh"));


    }

    public class  holder_of_res extends RecyclerView.ViewHolder implements View.OnClickListener{
      private   TextView textView1;
      private   TextView textView2;
      private CircleImageView img;
      private RecyclerView recyclerView;


        public holder_of_res(@NonNull View itemView) {
            super(itemView);
            textView1 =itemView.findViewById(R.id.txt_2);
            textView2 =itemView.findViewById(R.id.txt222);
            img=itemView.findViewById(R.id.img_profile);
            img.setOnClickListener(this);
            recyclerView=itemView.findViewById(R.id.chiled_res);
        }

        @Override
        public void onClick(View v) {
            if (v==img){
                Intent intent = new Intent(v.getContext(), User_profile_actevity.class);
               v.getContext().startActivity(intent);
            }

        }
    }
}
