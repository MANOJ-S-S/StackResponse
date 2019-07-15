package com.example.stackresponse.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.stackresponse.Model.Questions;
import com.example.stackresponse.R;
import com.example.stackresponse.Retrofit.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView stack_title;
    RecyclerView recycle;
    List<Questions.ItemsBean> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stack_title=findViewById(R.id.stack_title);
        recycle=findViewById(R.id.recycle);

        Utils utils=new Utils();


        Call <Questions> mcall= utils.getApi().quescall("desc","activity","stackoverflow");
        mcall.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                questions=response.body().getItems();

                LinearLayoutManager verticalLayoutmanager
                        = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recycle.setLayoutManager(verticalLayoutmanager);
                MyAdapter ad=new MyAdapter(questions,MainActivity.this);

                // RAdapt rAdapt=new RAdapt(employeeModelList);

                recycle.setAdapter(ad);


            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
}
