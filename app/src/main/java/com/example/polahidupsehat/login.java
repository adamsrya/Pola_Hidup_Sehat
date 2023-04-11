package com.example.polahidupsehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.polahidupsehat.api.ApiInterface;
import com.example.polahidupsehat.api.ApicClient;
import com.example.polahidupsehat.model.login.Login;
import com.example.polahidupsehat.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity implements View.OnClickListener {
    private ImageView kembali;
    EditText usernm, pw;
    TextView daftarakun;
    Button login ;
    String user,psw;
    ApiInterface apiInterface;
    Sessionmanagerlogin sessionmanagerlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kembali = findViewById(R.id.back);
        usernm = findViewById(R.id.user);
        pw = findViewById(R.id.pass);
        daftarakun = findViewById(R.id.blumdaftar);
        login = findViewById(R.id.login);
        daftarakun.setOnClickListener(this);
        kembali.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                user = usernm.getText().toString();
                psw = pw.getText().toString();
                blogin(user,psw);
                break;
            case  R.id.blumdaftar:
                Intent i = new Intent(login.this, daftar.class);
                startActivity(i);
                finish();
                break;
            case R.id.back:
                Intent intent = new Intent(login.this, replacemenufr.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    private void blogin(String user, String psw) {

        Call<Login> loginCall = ApicClient.apiInterface().loginresponse(user, psw);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    //Menyimpan Sesi
                    sessionmanagerlogin = new Sessionmanagerlogin(login.this);
                    LoginData loginData = response.body().getData();
                    sessionmanagerlogin.createloginsession(loginData);
                    //move activity after login
                    Intent intent = new Intent(login.this, menu.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(login.this,response.body().getData().getNama(), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(login.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(login.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}