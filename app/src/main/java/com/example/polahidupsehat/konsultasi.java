package com.example.polahidupsehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class konsultasi extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView back;
    Button btnkonsul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);
        btnkonsul = findViewById(R.id.btnkonsul);
        btnkonsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konsultasi.this, polamakan.class);
                startActivity(intent);

            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(konsultasi.this,menu.class);
                startActivity(intent);
            }
        });
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.homemenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu2 :
                        startActivity(new Intent(getApplicationContext(), menu.class));
                        return true;
                    case R.id.konsul:
                        startActivity(new Intent(getApplicationContext(), riwayatkons.class));
                        return true;
                    case R.id.login:
                        startActivity(new Intent(getApplicationContext(),login.class));
                        return true;
                }
                return false;
            }
        });
    }
}