package com.example.pregnancyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button btn5;
    private Button btn6;
    private Button btn7;

    Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       btn5=findViewById(R.id.bt);
       btn6=findViewById(R.id.nutr);
       btn7=findViewById(R.id.fit);
       con=findViewById(R.id.con);

       con.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openAboutus();
           }
       });
       
       btn5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openPregnancyhealth();
           }
       });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutrition();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFitness();
            }
        });
}
    public void openPregnancyhealth(){
        Intent intent=new Intent(this,Pregnancyhealth.class);
        startActivity(intent);
    }
    public void openNutrition(){
        Intent intent=new Intent(this,Nutrition.class);
        startActivity(intent);
    }
    public void openFitness(){
        Intent intent=new Intent(this,Fittness.class);
        startActivity(intent);
    }
    public void openAboutus(){
        Intent intent=new Intent(this,Aboutus.class);
        startActivity(intent);
    }
}