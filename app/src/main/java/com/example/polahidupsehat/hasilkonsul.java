package com.example.polahidupsehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class hasilkonsul extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilkonsul);
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.rkonsul);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu2 :
                        startActivity(new Intent(getApplicationContext(), menu.class));
                        return true;
                    case R.id.konsul:
                        return true;
                    case R.id.login:
                        startActivity(new Intent(getApplicationContext(),login.class));
                        return true;
                }
                return false;
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hasilkonsul.this,menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}