package com.example.polahidupsehat.api;

import com.example.polahidupsehat.model.daftar.Daftar;
import com.example.polahidupsehat.model.login.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("AuthApi/createapi")
    Call<Daftar>daftarresponse(
            @Field("nama") String nama,
            @Field("tmptlhr") String tmptlahir,
            @Field("tgllhr") String tgllhr,
            @Field("alamat") String alamat,
            @Field("jk") String jk,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("AuthApi/login")
    Call<Login>loginresponse(
            @Field("username") String username,
            @Field("password") String password
    );

}
