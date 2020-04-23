package com.example.e_learningnavi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText edtEmail,edtPass;
    TextInputLayout txtEmail,txtPass;
    TextView tv_Reg;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = findViewById(R.id.editTextEmail);
        edtPass = findViewById(R.id.editTextPassword);
        txtEmail = findViewById(R.id.textInputLayoutEmail);
        txtPass = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.btn_login);
        tv_Reg = findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = edtEmail.getText().toString();
                String passwordKey = edtPass.getText().toString();

                if (usernameKey.equals("siswa")&&passwordKey.equals("123")){
                    Toast.makeText(getApplicationContext(), "Login Sukses Cuuyy!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainSiswa.class);
                    startActivity(intent);
                    finish();
                }
                else if(usernameKey.equals("guru")&&passwordKey.equals("123")){
                    Toast.makeText(getApplicationContext(),"Login Sukses Untuk Guru!",
                            Toast.LENGTH_SHORT).show();
                    Intent intentGuru = new Intent(LoginActivity.this,MainGuru.class);
                    startActivity(intentGuru);
                    finish();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Salah!").setNegativeButton("Retry",null).create().show();
                }
            }
        });
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("E-Learning");
        }
    }
}
