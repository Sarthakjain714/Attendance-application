package com.example.counsellorsection.retrofit;

import android.database.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface myservice {

    @FormUrlEncoded
    @POST("register")
    Call<pojologinregister> registerUser(@Field("email") String email,
                                                @Field("name") String name,
                                                @Field("password") String password);

    @POST("login")
    @FormUrlEncoded
    Call<pojologinregister> loginUser(@Field("email") String email,
                                      @Field("password")String password);
}
