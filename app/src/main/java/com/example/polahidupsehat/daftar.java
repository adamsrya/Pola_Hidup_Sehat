package com.example.polahidupsehat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.polahidupsehat.api.ApiInterface;
import com.example.polahidupsehat.api.ApicClient;
import com.example.polahidupsehat.model.daftar.Daftar;
import com.example.polahidupsehat.model.daftar.DaftarData;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class daftar extends AppCompatActivity {
EditText tgl,nm,tlahir,alamat,user,email,pass;
ImageView kembali;
RadioGroup jk;
RadioButton jkterpilih;
Button daftar;
String nama,tmptlahir,tgllahir,almat,jkl,usernm,eml,pw;
ApiInterface apiInterface;


DatePickerDialog.OnDateSetListener listen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        tgl = findViewById(R.id.tgllahir);
        nm = findViewById(R.id.nama);
        tlahir = findViewById(R.id.tmptlahir);
        alamat = findViewById(R.id.alamat);
        user = findViewById(R.id.username);
        email = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
        jk = findViewById(R.id.jk);
        daftar = findViewById(R.id.daftar);
        Calendar calender = Calendar.getInstance();
        final int year = calender.get(Calendar.YEAR);
        final int month = calender.get(Calendar.MONTH);
        final int day = calender.get(Calendar.DAY_OF_MONTH);

    tgl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    daftar.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month+1;
                    String date = year+"/"+month+"/"+day;
                    tgl.setText(date);
                }
            },year,month,day);
            datePickerDialog.show();
        }
    });
        kembali = findViewById(R.id.back);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(daftar.this,replacemenufr.class);
                startActivity(intent);
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idterpilih = jk.getCheckedRadioButtonId();
                jkterpilih = findViewById(idterpilih);
                nama = nm.getText().toString();
                tmptlahir = tlahir.getText().toString();
                tgllahir = tgl.getText().toString();
                almat = alamat.getText().toString();
                jkl = jkterpilih.getText().toString();
                usernm = user.getText().toString();
                eml = email.getText().toString();
                pw = pass.getText().toString();
                bdatar(nama,tmptlahir,tgllahir,almat,jkl,usernm,eml,pw);

            }

            private void bdatar(String nama, String tmptlahir, String tgllahir, String almat, String jkl, String usernm,
                                String eml, String pw) {


                Call<Daftar> call = ApicClient.apiInterface().daftarresponse(nama,tmptlahir,tgllahir,almat,jkl,usernm,eml,pw);
                call.enqueue(new Callback<Daftar>() {
                    @Override
                    public void onResponse(Call<Daftar> call, Response<Daftar> response) {
                        if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                            DaftarData daftarData = response.body().getData();
                            Intent intent = new Intent(daftar.this, login.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(daftar.this,response.body().getData().toString(), Toast.LENGTH_SHORT).show();

                        }else{
                             Toast.makeText(getApplicationContext(),"Keluarin Motor Dulu ygy", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Daftar> call, Throwable t) {
                        Toast.makeText(daftar.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}