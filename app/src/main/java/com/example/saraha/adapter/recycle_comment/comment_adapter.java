package com.example.saraha.adapter.recycle_comment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.Message;
import com.example.saraha.models.replaymassagemodel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class comment_adapter extends RecyclerView.Adapter<holder_comment> {
    private ArrayList<Message> arraycomment = new ArrayList<>();
    public holder_comment hoh;
    private RecyclerViewClickListener mListener;
    View view;


    private Context context;

    public comment_adapter(Context context1, ArrayList<Message> arraycomment) {
        this.arraycomment = arraycomment;
        this.context = context1;
    }

    public interface RecyclerViewClickListener {

        void onClick(int position);
    }


    @NonNull
    @Override
    public holder_comment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_comment_item, parent, false);
        return new holder_comment(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final holder_comment holder, final int position) {
        String l="https://sariiih.com/up/"+arraycomment.get(position).getData();


        Log.d("index", "" + position);
        holder.setData(arraycomment.get(position));
        Picasso.get().load(l).into(holder.imageView);
       // final int posi = holder.getAdapterPosition();
      //  final Intent it=new Intent(context, Edit_profile_actievity.class);
        holder.textView3.setVisibility(View.VISIBLE);
        holder.editText1.setVisibility(View.VISIBLE);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //   Toast.makeText(context, "" + arraycomment.get(position).getID(), Toast.LENGTH_SHORT).show();

//                        Toast.makeText(context, "fffffffffffffffffff", Toast.LENGTH_SHORT).show();
                holder.textView3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        replaymethode(holder.editText1, "" + arraycomment.get(position).getID());
                        //  holder.textView3.setVisibility(View.GONE);
                        //   holder.editText1.setVisibility(View.GONE);
                        holder.editText1.setText("");
                    }
                });






            }
        });


    }


    @Override
    public int getItemCount() {

        return arraycomment.size();


    }


    public void replaymethode(EditText editText1 , String idmassage ) {
        String replaytxt = editText1.getText().toString().trim();
        if (replaytxt.isEmpty()) {
            editText1.setError("text is required");
            editText1.requestFocus();
            return;

        }
        UserPref userPref = new UserPref(context);

        String token = userPref.getName();
//        String idmassage = userPref.getmassage();
        Call<replaymassagemodel> call = RetrofitSettings.getInstance().getrequest().addmassagereplay(token, replaytxt, "", "", "", "", idmassage);
        call.enqueue(new Callback<replaymassagemodel>() {
            @Override
            public void onResponse(Call<replaymassagemodel> call, Response<replaymassagemodel> response) {
                if (response.isSuccessful()) {
                    Toasty.success(context, "Success replay", Toast.LENGTH_SHORT, true).show();
                    String Tag = "tag";
                    Log.d(Tag, "hhh" + response);
                } else {
                    Toasty.error(context, "This is an error replay", Toast.LENGTH_SHORT, true).show();

                }
            }

            @Override
            public void onFailure(Call<replaymassagemodel> call, Throwable t) {

            }
        });


    }

}
