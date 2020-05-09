package com.example.saraha.adapter.search_if_any_profile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.chaid_model_of_any_profile;
import com.example.saraha.views.profile_of_any_profile_activity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adapter_of_any_profile extends RecyclerView.Adapter<holder_prav> implements Filterable {
    private ArrayList<chaid_model_of_any_profile> arraysearch=new ArrayList<>();
    private ArrayList<chaid_model_of_any_profile> arraysearchfull;
    private Context context;

    public adapter_of_any_profile(ArrayList<chaid_model_of_any_profile> arraysearch, Context context) {
        this.arraysearch = arraysearch;
        this.context = context;
        arraysearchfull = new ArrayList<>(arraysearch);
    }

    @NonNull
    @Override
    public holder_prav onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycl_search, parent, false);
        return new holder_prav(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder_prav holder, final int position) {
        holder. textView1.setText(arraysearch.get(position).getName());
        String m=arraysearch.get(position).getImage();
        final String r="https://sariiih.com/images/thumb/"+m;
        Picasso.get().load(r).into(holder.imageView);
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, profile_of_any_profile_activity.class);
                //  intent.putExtra("categoryId", arraysearch.get(position).getID());
                intent.putExtra("categoryIdsssssss",String.valueOf( arraysearch.get(position).getID()));
                intent.putExtra("namessssss",arraysearch.get(position).getName());
                intent.putExtra("nikenamessssssss",arraysearch.get(position).getNickName());
                intent.putExtra("photooooooooo",r);
                intent.putExtra("nobsa",arraysearch.get(position).getDetails());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (arraysearchfull!=null) {
            return arraysearch.size();
        }
        return 0;
    }
    @Override
    public Filter getFilter() {
        return examplefilter;
    }

    private Filter examplefilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<chaid_model_of_any_profile> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(arraysearchfull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (chaid_model_of_any_profile item : arraysearchfull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arraysearch.clear();
            arraysearch.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}
