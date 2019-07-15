package com.example.stackresponse.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class Utils {

        public Apis getApi()
        {
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Apis apis=retrofit.create(Apis.class);
            return apis;
        }

    }


