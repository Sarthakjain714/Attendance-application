package com.example.counsellorsection.retrofit;

import com.google.gson.annotations.SerializedName;

public class pojologinregister {

    private String response;
    public pojologinregister(String message){
        this.response=message;
    }

    public String getAnswer() {
        return response;
    }

    public void setAnswer(String answer) {
        this.response= answer;
    }
}
