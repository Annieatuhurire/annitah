package com.example.pregnancyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private Button btn3;
    private TextView fo;
    private TextView doo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn3=findViewById(R.id.login);
        fo=findViewById(R.id.forgot);
        doo=findViewById(R.id.dont);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        fo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewpassword();
            }
        });
        doo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }
    public void openHome(){
        Intent intent=new Intent(this,Home.class);
        startActivity(intent);
    }
    public void openNewpassword(){
        Intent intent=new Intent(this,Newpassword.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }
}