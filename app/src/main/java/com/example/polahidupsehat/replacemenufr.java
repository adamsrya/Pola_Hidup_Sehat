package com.example.polahidupsehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class replacemenufr extends AppCompatActivity {
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replacemenufr);
        navigationView = findViewById(R.id.bottomnav);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new menubfrlogFragment()).commit();
        navigationView.setSelectedItemId(R.id.body_container);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr = null;
                switch (item.getItemId()){
                    case R.id.menu2:
                        return true;
                    case R.id.konsul:
                        fr = new konsulfr();
                        return true;
                    case R.id.reminderfr:
                        fr = new reminderfr();
                        return true;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fr).commit();
                return true;
            }
        });
    }
}