package com.example.pregnancyhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.jar.Attributes;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText fname, lname, dob, passw, cpass;
    private Button register;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        //initializing views
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        dob = findViewById(R.id.dob);
        passw = findViewById(R.id.pass);
        cpass = findViewById(R.id.conf);
        //register = findViewById(R.id.reg);
        progressDialog = new ProgressDialog(this);
        register = findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    public void register() {
        String Fname = fname.getText().toString();
        String LastName = lname.getText().toString();
        String Dob = dob.getText().toString();
        String password = passw.getText().toString();
        String cpassword = cpass.getText().toString();
        if (TextUtils.isEmpty(Fname)) {
            fname.setError("Field is required");
            return;
        } else if (TextUtils.isEmpty(LastName)) {
            lname.setError("Field is required");
            return;

        } else if (TextUtils.isEmpty(Dob)) {
            dob.setError("Field is required");
            return;
        } else if (TextUtils.isEmpty(password)) {
            passw.setError("Enter your password");
            return;
        } else if (TextUtils.isEmpty(password)) {
            cpass.setError("Confirm your password");
            return;


        } else if (!password.equals(cpassword)) {
            passw.setError("Password mismatch");
            return;


        } else if (password.length() < 4) {
            passw.setError("Password is to short");
            return;


        }
        //Displaying progressDialog
        progressDialog.setMessage("Registration please wait......");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(Dob, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_LONG).show();

                }
                progressDialog.dismiss();

            }
        });
    }

    public void onclick(View v) {
        register();
    }


    public void openRegister(View view) {
        startActivity(new Intent(Register.this, Home.class));
    }

}