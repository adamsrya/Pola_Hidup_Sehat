package com.example.polahidupsehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class anjuran extends AppCompatActivity {
Button toremin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anjuran);
        toremin = findViewById(R.id.btntoremin);
        toremin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(anjuran.this,reminder.class);
                startActivity(i);
                finish();
            }
        });
    }
}