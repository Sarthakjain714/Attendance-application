package com.example.counsellorsection.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient {
    private static Retrofit instance;

    public static Retrofit getInstance(){
        if(instance==null){
            Gson gson = new GsonBuilder().create();
            instance= new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            }
        return instance;
    }

    myservice apiset(){
        return instance.create(myservice.class);
    }
}
