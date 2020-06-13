package com.e_learning.navi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.arvita.crudvolley.R;

import com.e_learning.navi.Session.SessionManager;
import com.e_learning.navi.Util.ServerAPI;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edtUsername, edtPass;
    private TextInputLayout txtUsername, txtPass;
    private TextView tv_Rights;
    private Button btnLogin;
    private ProgressBar loading;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLogin()){
            finish();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }
        edtUsername = findViewById(R.id.editTextEmail);
        edtPass = findViewById(R.id.editTextPassword);

        txtUsername = findViewById(R.id.textInputLayoutEmail);
        txtPass = findViewById(R.id.textInputLayoutPassword);

        loading = findViewById(R.id.loading);

        tv_Rights = findViewById(R.id.copyrights);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUsername = edtUsername.getText().toString().trim();
                String mPass = edtPass.getText().toString().trim();

                if (!mUsername.isEmpty() || !mPass.isEmpty()){
                    login(mUsername,mPass);
                }else {
                    edtUsername.setError("Please Insert Username");
                    edtPass.setError("Please Insert Password");
                }
            }
        });
    }


    private void login(final String username, final String password) {
        loading.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.GONE);
        final String mPass = edtPass.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, ServerAPI.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            if (success.equals("1")){
                                for (int i=0; i<jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String username = object.getString("username");
//                                    String password = object.getString("password");
                                    String akses = object.getString("akses");
                                    String id = object.getString("id");
                                    String nis = object.getString("nis");
                                    String nama = object.getString("nama_siswa");
                                    if (akses.equals("3") && !mPass.isEmpty()){
//                                    Toast.makeText(LoginActivity.this, "Success Login. \n Your Name "
//                                            + username + "\n Your Akses "
//                                            + akses,Toast.LENGTH_SHORT)
//                                            .show();
//                                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
//                                    startActivity(intent);
                                        sessionManager.createSession(username,akses,id,nis,nama);

                                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                        intent.putExtra("username",username);
                                        intent.putExtra("akses",akses);
                                        intent.putExtra("id",id);
                                        intent.putExtra("nis",nis);
                                        intent.putExtra("nama",nama);
                                        startActivity(intent);
                                        finish();
                                        loading.setVisibility(View.GONE);
                                    }
                                    else {
                                        edtPass.setError("Set Your Password");
//                                        Toast.makeText(LoginActivity.this, "Anda Bukan Siswa Silahkan Login di Website", Toast.LENGTH_SHORT).show();
                                    }
                                    loading.setVisibility(View.GONE);
                                    btnLogin.setVisibility(View.VISIBLE);
                                }
                            }
                            else {
                                loading.setVisibility(View.GONE);
                                btnLogin.setVisibility(View.VISIBLE);
                                Toast.makeText(LoginActivity.this, "Error " +response, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
//                            loading.setVisibility(View.GONE);
//                            btnLogin.setVisibility(View.VISIBLE);
                            loading.setVisibility(View.GONE);
                            btnLogin.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "Username dan Password anda bukan Siswa silahkan login di website", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        loading.setVisibility(View.GONE);
//                        btnLogin.setVisibility(View.VISIBLE);
                        loading.setVisibility(View.GONE);
                        btnLogin.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this,"Errornya apa ya ?\n"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}


//JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_LOGIN, null,
//        new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d("volley", "response : " + response.toString());
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject data = response.getJSONObject(i);
//                        String id = data.getString("id");
//                        String akses = data.getString("akses");
//                        String username = data.getString("username");
//
//                        sessionManager.createSession(username, akses, id);
//
//                        Intent main = new Intent(LoginActivity.this, HomeActivity.class);
//                        main.putExtra("USERNAME", username);
//                        main.putExtra("AKSES", akses);
//                        main.putExtra("ID", id);
//                        startActivity(main);
//                        finish();
//
//                    } catch (Exception e) {
//                        Toast.makeText(getApplicationContext(), "this is " + e.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(),"this is "+error.toString(),Toast.LENGTH_SHORT).show();
//                    }
//                }){};

//                        if (response.contains("1")) {
//                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Anda Bukan Siswa Mohon Login Di Website", Toast.LENGTH_SHORT).show();
//                        }