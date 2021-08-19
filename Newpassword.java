package com.example.pregnancyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Newpassword extends AppCompatActivity {
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
        btn4=findViewById(R.id.fin);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
    }
    public void openLogin(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}