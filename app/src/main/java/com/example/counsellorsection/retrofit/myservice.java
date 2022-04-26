package com.example.counsellorsection.retrofit;

import android.database.Observable;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface myservice {

    @FormUrlEncoded
    @POST("createuser")
    Call<JsonObject> registerUser(@Field("email") String email,
                                                @Field("name") String name,
                                                @Field("password") String password);
//    @GET("createuser")
//    Call<pojologinregister> authtoken()
    @POST("login")
    @FormUrlEncoded
    Call<JsonObject> loginUser(@Field("email") String email,
                               @Field("password")String password);
    @Headers({
            "Accept : */*",
            "User-Agent : Counsellor section"
    })
    @POST("getuser")
    @FormUrlEncoded
    Call<JsonObject> getuser();
}
