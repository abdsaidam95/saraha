package com.example.saraha.adapter.recycle_comment;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.saraha.LocalDatabase.UserPref;
import com.example.saraha.R;
import com.example.saraha.api.RetrofitSettings;
import com.example.saraha.models.CommentModelResc;

import com.example.saraha.models.Message;
import com.example.saraha.models.hodel_of_search_resc;
import com.example.saraha.models.replaymassagemodel;
import com.example.saraha.views.comment_actevity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public    class holder_comment   extends RecyclerView.ViewHolder  {

    private ArrayList<Message> arraycomment = new ArrayList<>();

    private comment_adapter.RecyclerViewClickListener mListener;



    public TextView textView1;
    public ImageView imageView;
    public TextView textView3;
    public String replaytxt;
    public EditText editText1;
    public comment_adapter comm;
    public      TextView replay;
    public TextView textView2;


    public holder_comment(@NonNull final View itemView, comment_adapter.RecyclerViewClickListener listener) {
        super(itemView);
        mListener=listener;
        textView1 = itemView.findViewById(R.id.datessss);
        textView2 = itemView.findViewById(R.id.teeext);
        imageView=itemView.findViewById(R.id.imgeemassage);
        textView3 = itemView.findViewById(R.id.tvvv);
        replay = itemView.findViewById(R.id.replay);

        editText1 = itemView.findViewById(R.id.edit);











    }



    public void replaymethode() {
        replaytxt = editText1.getText().toString().trim();
        if (replaytxt.isEmpty()) {
            editText1.setError("text is required");
            editText1.requestFocus();
            return;

        }
        UserPref userPref = new UserPref(itemView.getContext());

        String token = userPref.getName();
        String idmassage = userPref.getmassage();
        Call<replaymassagemodel> call = RetrofitSettings.getInstance().getrequest().addmassagereplay(token, replaytxt, "", "", "", "", idmassage);
        call.enqueue(new Callback<replaymassagemodel>() {
            @Override
            public void onResponse(Call<replaymassagemodel> call, Response<replaymassagemodel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(itemView.getContext(), "sucsess" + response, Toast.LENGTH_SHORT).show();
                    String Tag = "tag";
                    Log.d(Tag, "hhh" + response);
                } else {
                    Toast.makeText(itemView.getContext(), "fail", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<replaymassagemodel> call, Throwable t) {

            }
        });


    }

    public void setData(Message type_of_post1) {
        String s = type_of_post1.getDate();
        String m = formatDate(s);


        textView1.setText(m.toString());
        textView2.setText(type_of_post1.getMessage());


        //  textView2.setText(type_of_post1.getMessages().toString());
    }

    private String formatDate(String dateString) {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date d = sd.parse(dateString);
            sd = new SimpleDateFormat("dd/MM/yyyy");
            return sd.format(d);
        } catch (ParseException e) {
        }
        return "";
    }


  //  @Override
 // public void onClick(View v) {
      //  mListener.onClick( getAdapterPosition());
       // int positi=getAdapterPosition();



       // if (v == replay) {



          //  textView3.setVisibility(View.VISIBLE);
            // editText1.setVisibility(View.VISIBLE);
            // textView3.setOnClickListener(new View.OnClickListener() {
           // @Override
             // public void onClick(View v) {
            // replaymethode();
             //  }
            //   });
            //  }

      //  }






    }




