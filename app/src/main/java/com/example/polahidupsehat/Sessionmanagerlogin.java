package com.example.polahidupsehat;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.example.polahidupsehat.model.login.LoginData;

import java.util.HashMap;

public class Sessionmanagerlogin {
    private Context _context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String is_login = "IsLoggedIn";
    private static final String id_pasien = "id_pasien";
    private static final String id_user = "id_user";
    private static final String nama = "nama";
    private static final String username = "username";
    private static final String email = "email";

   public Sessionmanagerlogin(Context context){
       this._context = context;
       sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
       editor = sharedPreferences.edit();
   }
   public void createloginsession(LoginData user){
       editor.putBoolean(is_login,true);
       editor.putString(id_pasien,user.getIdPasien());
       editor.putString(id_user,user.getIdUser());
        editor.putString(nama,user.getNama());
       editor.putString(username,user.getUsername());
       editor.putString(email,user.getEmail());
       editor.commit();
   }
    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(id_pasien, sharedPreferences.getString(id_pasien,""));
        user.put(id_user, sharedPreferences.getString(id_user,""));
        user.put(nama, sharedPreferences.getString(nama,""));
        user.put(username, sharedPreferences.getString(username,""));
        user.put(email, sharedPreferences.getString(email,""));
        return user;

    }
    public void logoutSession(){
        editor.clear();
        editor.commit();
    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(is_login, false);
    }
}
