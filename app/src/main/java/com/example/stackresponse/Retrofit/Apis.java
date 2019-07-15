package com.example.stackresponse.Retrofit;



import com.example.stackresponse.Model.Questions;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Apis {
@GET("/2.2/questions?")
Call<Questions> quescall (@Query("order") String order, @Query("sort") String sort, @Query("site") String site);
}
