package com.example.stackresponse.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.stackresponse.Model.Questions;
import com.example.stackresponse.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Questions.ItemsBean> questions;
    Context context;

    public MyAdapter(List<Questions.ItemsBean> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_layout,viewGroup,false);
        Log.e("onCreateViewHolder","hit");
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.questv.setText(questions.get(i).getTitle());
        myViewHolder.queslinktv.setText(questions.get(i).getLink());
        myViewHolder.usernametv.setText(questions.get(i).getOwner().getDisplay_name());
        myViewHolder.userstacklinktv.setText(questions.get(i).getOwner().getLink());

        Glide
                .with(context)
                .load(questions.get(i).getOwner().getProfile_image())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(myViewHolder.imgtv);


    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

       TextView questv,queslinktv,usernametv,userstacklinktv;
       ImageView imgtv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            questv=itemView.findViewById(R.id.ques_title);
            queslinktv=itemView.findViewById(R.id.ques_link);
            usernametv=itemView.findViewById(R.id.user_name);
            userstacklinktv=itemView.findViewById(R.id.user_stacklink);
            imgtv=itemView.findViewById(R.id.user_foto1);
        }
    }

}
