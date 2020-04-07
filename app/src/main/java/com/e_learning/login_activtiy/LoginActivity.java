package com.e_learning.login_activtiy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username =  findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login =  findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();
                // ini di taruh sini aja kalo mau disambungkan ke punyamu
                if (usernameKey.equals("admin") && passwordKey.equals("admin")) {
                    //Jika Berhasil
                    Intent welcome = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(welcome);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda Salah !")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}
