package com.example.saraha.adapter.res1_profile_frag;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saraha.R;
import com.example.saraha.models.model_pref_anather;
import com.example.saraha.models.model_res1_profile_frag;
import com.example.saraha.models.res2_massage_profile_frag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class holder_res1 extends RecyclerView.ViewHolder {
    private TextView textView1;
    private TextView textView2;
    public RecyclerView recyclerView;
    public holder_res1(@NonNull View itemView) {
        super(itemView);
        textView1=itemView.findViewById(R.id.date1);
        textView2=itemView.findViewById(R.id.teeext2);
        recyclerView=itemView.findViewById(R.id.rrrrrrrrescld);
    }
    public void setData(res2_massage_profile_frag type_of_post1) {
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
}
