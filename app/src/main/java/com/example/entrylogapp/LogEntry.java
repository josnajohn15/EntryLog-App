package com.example.entrylogapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LogEntry extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_entry);
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.ano);
        ed3=(EditText) findViewById(R.id.sno);
        ed4=(EditText) findViewById(R.id.dno);
        b1=(AppCompatButton) findViewById(R.id.add);
        b2=(AppCompatButton) findViewById(R.id.back);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ed1.getText().toString();
                String adm=ed2.getText().toString();
                String sys=ed3.getText().toString();
                String dep=ed4.getText().toString();
                Toast.makeText(getApplicationContext(),name+" "+adm+" "+sys+" "+dep,Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("Logged",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}
