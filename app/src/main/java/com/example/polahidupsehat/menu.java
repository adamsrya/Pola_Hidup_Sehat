package com.example.polahidupsehat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class menu extends AppCompatActivity  {
BottomNavigationView bottomNavigationView;
Sessionmanagerlogin sessionmanagerlogin;
TextView vnmlogin,vemllogin;
String vnama,vemail;
DrawerLayout drawerLayout;
NavigationView navigationView;
ImageView toolbar,konsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sessionmanagerlogin = new Sessionmanagerlogin(menu.this);
        //sesi jika
        if(!sessionmanagerlogin.isLoggedIn()){
            moveToLogin();
        }
        drawerLayout = findViewById(R.id.drawer_layout);

        //Fetch Data User
        vnmlogin = findViewById(R.id.viewnmlogin);
        vemllogin = findViewById(R.id.viewemllogin);
        vnama = sessionmanagerlogin.getUserDetail().get("nama");
        vemail = sessionmanagerlogin.getUserDetail().get("email");
        vnmlogin.setText("Hola "+vnama);
        vemllogin.setText("  "+vemail);

        //Navigation Drawer
        navigationView = findViewById(R.id.nav_view);
        /*TextView dnama = (TextView) navigationView.getHeaderView(0).findViewById(R.id.dnama);
        dnama.setText(vnama);
        TextView demail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.dnama);
        demail.setText(vnama);*/
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.keluar:
                        sessionmanagerlogin.logoutSession();
                        moveTomenubfrlogin();
                }
                return true;
            }
        });
        //Toolbar Navigation Drawer
        toolbar = findViewById(R.id.toolbarr);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        konsultasi = findViewById(R.id.konsul);
        konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menu.this,konsultasi.class);
                startActivity(i);
                return;
            }
        });
        //Bottom Navigation
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.homemenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu2 :
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


    private void moveToLogin() {
        Intent intent = new Intent(menu.this,login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
    private void moveTomenubfrlogin() {
        Intent intent = new Intent(menu.this,replacemenufr.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}