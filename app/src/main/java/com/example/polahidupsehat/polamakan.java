package com.example.polahidupsehat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class polamakan extends AppCompatActivity {
TextView polamknn;
ImageView back;
Button btntomenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polamakan);
        polamknn = findViewById(R.id.polamakananj);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(polamakan.this,menu.class);
                startActivity(i);
                finish();
            }
        });


    }
}