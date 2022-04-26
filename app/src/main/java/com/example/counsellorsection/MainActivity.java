package com.example.counsellorsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.counsellorsection.retrofit.myservice;
import com.example.counsellorsection.retrofit.pojologinregister;
import com.example.counsellorsection.retrofit.retrofitclient;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText loginemail,loginpassword;
    TextView signuptext;
    Button login;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    myservice client;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginemail=findViewById(R.id.emailidlogin);
        loginpassword=findViewById(R.id.passwordlogin);
        signuptext=findViewById(R.id.signuptext);
        login=findViewById(R.id.loginbutton);

        signuptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginuser(loginemail.getText().toString(),loginpassword.getText().toString());
            }
        });


    }

    public void loginuser(String email, String password) {
        client=retrofitclient.getInstance().create(myservice.class);
        client.loginUser(email,password).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String answer=new Gson().toJson(response.body());
                Log.d("responselogin", "onResponse: "+answer);
//                Log.d("loginresponse", ""+answer.getAnswer());
                if(answer.length()>100){
                    Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),register.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Some error occured", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}