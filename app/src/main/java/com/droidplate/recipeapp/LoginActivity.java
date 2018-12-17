package com.droidplate.recipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {

    EditText emailEditText, passwordEditText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEditText= findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        button = findViewById(R.id.Login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             verifyUser();

            }
        });





    }

    public void verifyUser(){


        emailEditText= findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        String userEmail = emailEditText.getText().toString().trim();
        String userPassword = passwordEditText.getText().toString().trim();

        String email = "arabmoney@gmail.com";
        String password = "12345";

        if (!email.equals(userEmail) && !password.equals(userPassword)){
            return;
        }else {
            Toast.makeText(LoginActivity.this, "welcome to flavor kitchen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }

    }


}
