package com.example.saraha.adapter.res1_profile_frag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.model1chiiiiid;
import com.example.saraha.models.modelchiiid;
import com.example.saraha.models.res2_massage_profile_frag;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class adapter_res1  extends RecyclerView.Adapter<holder_res1> {
 private    Context context;
    private ArrayList<res2_massage_profile_frag> array=new ArrayList<>();
    public String posit;
    private ArrayList<model1chiiiiid> array1=new ArrayList<>();


    public adapter_res1(Context context, ArrayList<res2_massage_profile_frag> array) {
        this.context = context;
        this.array = array;
    }



    @NonNull
    @Override
    public holder_res1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_res_1, parent, false);
        return new holder_res1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder_res1 holder, int position) {
        holder.setData(array.get(position));
        posit= String.valueOf(array.get(position).getID());



        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setHasFixedSize(true);

        Call<modelchiiid> call= RetrofitSettings.getInstance().getrequest().addmassagereplayinpuplic(posit);
        call.enqueue(new Callback<modelchiiid>() {
            @Override
            public void onResponse(Call<modelchiiid> call, Response<modelchiiid> response) {
                if (response.isSuccessful()){
                 //   Toast.makeText(context, ""+response.body(), Toast.LENGTH_SHORT).show();

                   modelchiiid cos = response.body();



                       if (response.body().getMessages()==null){}
                       else {
                           array1 = new ArrayList<>(cos.getMessages());
                           adapterchaildrespof adapter = new adapterchaildrespof(array1);
                           holder.recyclerView.setAdapter(adapter);
                           notifyDataSetChanged();
                         //  Toast.makeText(context, "" + response.body(), Toast.LENGTH_SHORT).show();
                       }
                   }




                else {
                  //  Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<modelchiiid> call, Throwable t) {


            }
        });

       // adapterchaildrespof adapter =new adapterchaildrespof(array1);
        //holder.recyclerView.setAdapter(adapter);
      //  adapter.notifyDataSetChanged();


    }
    public void getreplay(){


    }

    @Override
    public int getItemCount() {
        return array.size();
    }
}
