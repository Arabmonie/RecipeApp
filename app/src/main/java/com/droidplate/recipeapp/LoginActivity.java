package com.droidplate.recipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.util.Patterns;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText emailEdit, passwordEdit;
     Button button;
     String userEmail = "arabmonie10@gmail.com";
     String userPassword = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdit = findViewById(R.id.email1);
        passwordEdit = findViewById(R.id.password1);
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = emailEdit.getText().toString().trim();
                String password = passwordEdit.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    emailEdit.setError("invalid email address");
                }

                if (TextUtils.isEmpty(password)){
                    passwordEdit.setError("invalid user password");
                }
                if (password.length() < 6){
                    Toast.makeText(LoginActivity.this, "user password must be six characters", Toast.LENGTH_SHORT).show();
                }

                if (email.equals(userEmail) && password.equals(userPassword) ){
                    Toast.makeText(LoginActivity.this, "user has been successfully authenticated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                }else {
                    Toast.makeText(LoginActivity.this, "try again", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
